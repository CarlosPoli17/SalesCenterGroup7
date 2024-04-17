package CentralSalesCenterOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class GenerateSalesReport {

	// List to store seller data
	private ArrayList<String[]> sellerList = new ArrayList<>();
	// List to store product data
	private ArrayList<String[]> productList = new ArrayList<>();
	// List to store the generated sales report
	private ArrayList<ArrayList<String>> report = new ArrayList<>();

	
	public GenerateSalesReport() {	
		// Constructor method that reads seller information, product information, orders and Generate a sales report sorted.
		if (salesMenRead()&&productListRead()&&ordersRead()&&report())
			System.out.println("The sales report was generated and exported correctly.");	
		else 
			System.out.println("An error occurred while generating the sales report.");
	}	
	/*With this method, we achieve, on one hand, creating an ArrayList with the available
	 *  sales report for use, and on the other hand, generating the same sales report and exporting 
	 *  it to a .txt file.
	 */
	

	public boolean salesMenRead() {
		 // Method to read seller information from a .txt file and fill out the seller list.
		String ruta="SalesMenInfo.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
	        String sellerX;
	        String[] sellerRead;
	        while ((sellerX = reader.readLine()) != null) {
	            sellerRead = sellerX.split(";");
	            sellerList.add(sellerRead);        
	        }
	        return true;
	    }catch (IOException e) {
	    	e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean productListRead() {
		// Method to read product information from a .txt file and fill the product list.
		String ruta="ProductsInfo.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
	        String productX;
	        String[] productRead;
	     // Loop to read each line of the file
	        while ((productX = reader.readLine()) != null) {
	        	// Splitting the line to extract individual product data
	            productRead = productX.split(";"); 
	            // Adding the product data to the ArrayList product list
	            productList.add(productRead);
	        }
	        return true;
	    }catch (IOException e) {
	    	e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean ordersRead() {	
		//Method to count how many files are in the Orders folder and read each one of them
		String orderFolder="Orders";
		File folder= new File (orderFolder);
		File[] qFiles = folder.listFiles();
		//According to the quantity of files in the folder, we iterate through each file
		for (int i=0;i<qFiles.length;i++) {
			//Invoke method to read each order and calculate the subtotal
			orderReadCount(i);
		}
		return true;	
	}
	
	public void orderReadCount(int orderId) {
		// Method to read order details from a specific .txt order file.
				//The filename pattern for the general file is 'order0' + the parameter 'i' received from the ordersRead method
		String ruta="Orders/order0"+orderId+".txt";
		ArrayList<String[]> orderItems = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
			String orderX;
			// Read the first line of the order file which contains seller information
			String check=reader.readLine();
			String [] check2=check.split(";");
			ArrayList<String> sellerReport=new ArrayList<>();
			 // Loop through the seller list to find the matching seller for the order
			for (int i=1;i<sellerList.size();i++) {
				// Check if the seller ID matches the one in the order
				if(Long.parseLong(sellerList.get(i)[1])==Long.parseLong(check2[1])) {
					// If a matching seller is found, add the seller's information to the report
					sellerReport.add(check2[1]);
					String[] orderRead;
					// Read the remaining lines of the order file containing the product ID and the quantity of sales.
					while ((orderX = reader.readLine()) != null) {
						orderRead = orderX.split(";");	
						orderItems.add(orderRead);
					}
					// Calculate the subtotal for the order and add it to the seller report
					sellerReport.add(String.valueOf(calculateSubtotal(orderItems)));
					// Add the seller report to the overall sales report
					report.add(sellerReport);
				}
			}
	    }catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public long calculateSubtotal(ArrayList<String[]> List) {
		 // Method to calculate the subtotal of an order.
		long count=0;
		// Loop through each item in the order
		for(int i=0;i<List.size();i++) {
			// Nested loop to find the corresponding product in the product list
			for(int j=1;j<productList.size();j++) {
				// Check if the product ID matches the one in the order
				if(Integer.parseInt(productList.get(j)[0])==Integer.parseInt(List.get(i)[0])) {
					 // Calculate the subtotal by multiplying the quantity by the unit price
					count=count+(Integer.parseInt(List.get(i)[1])*Integer.parseInt(productList.get(j)[2]));
				}	
			}
		}
		return count;
	}
	public boolean report() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Report.txt"))) {
			// Initialize the header line of the report
			String reportLines="NombreVendedor;VentasTotalMes";
			// Write the header line to the file
        	writer.write(reportLines);
        	// Iterate over each entry in the report data
    	    for (int i=0;i<report.size();i++) {
    	    	/*We obtain the seller's identification number and send 
    	    	 * it as a parameter to obtain the two names, these will be written in the report
    	    	 */
    	    	long idSeller=Long.valueOf(report.get(i).get(0));
    	    	String nameSeller=nameOf(idSeller);
    	    	// Move to a new line in the report file
    			writer.newLine();
    			// Get the vendor document number and total sales for the month from the report data
    	        reportLines=nameSeller+";"+report.get(i).get(1);      
    	        // Write the vendor data to the report file
        		writer.write(reportLines); 
    	    }
    	    // Return true indicating successful export of the report
    	    return true;	    
    	}catch (IOException e) {
    		// If an IOException, print error message
    		System.err.println("error exporting file: " + e.getMessage()); 
    		// Return false indicating failure to export the report
    	    return false;
    	}
	}
	/*Find the seller's identification number by iterating over the list and 
	 * return the first and middle name, join them in a String and return them
	 */
	public String nameOf(long id) {
		String name="";
		for (int i=1;i<sellerList.size();i++) {
			if(Long.valueOf(sellerList.get(i)[1])==id) {
			   String firstName=sellerList.get(i)[2];
			   String lastName=sellerList.get(i)[3];
			   name=firstName+" "+lastName;
			}
		}
		return name;
	}
}