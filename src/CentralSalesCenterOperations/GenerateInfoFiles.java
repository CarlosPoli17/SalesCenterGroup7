package CentralSalesCenterOperations;

//import the classes to create and export files, exception handling.
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import classes to obtain pseudo random numbers and names
import randoms.RandomNames;
import randoms.RandomNumbers;
//import classes to instantiate employees and products
import temps.Product;
import temps.Seller;
import java.util.ArrayList;
	//class attributes
public class GenerateInfoFiles {
	private RandomNames randomName ;
	private RandomNumbers randomNumber;
	private ArrayList <Seller> salesMenList ;
	private ArrayList <Product> productList ;

	/*class constructor
	*upon instantiation creates instances of the classes RandomNames, RandomNumbers and creates two ArrayLists to store 
	*instances of with employees and individual products.*/
	public GenerateInfoFiles() {
		this.randomName = new RandomNames();
		this.randomNumber = new RandomNumbers();
		this.salesMenList = new ArrayList<>();
		this.productList = new ArrayList<>();
		/*From the constructor we call the methods of the class in a chain and at the end it will return true if the files
		 *  were exported or false if there was an error.
		 */
		createFiles();
	}
	/*Method to call the methods that create the seller, product list and order data files, each method 
	 * is expected to return true to show that the export was successful.
	 */
	public void createFiles() {
		//If all three methods return true
		if (createSalesManInfoFile()&&createProductsFile()&&createSalesMenFile())
			System.out.println("the files have been exported successfully.");	
		else 
			System.out.println("An error occurred when exporting the files.");
	}

	public boolean createSalesManInfoFile(){
		//in sellerInfo the lines that the .txt file will contain are assigned
		String sellerInfo=null;
		/*creates a random number of employees, calling the method on the instance of the RandonNumbers 
		 * class created by the constructor.
		 */
		int qEmployees =randomNumber.randomEmployees();
		//initializes a BufferedWriter to write to the SalesMenInfo.txt file
  	try (BufferedWriter writer = new BufferedWriter(new FileWriter("SalesMenInfo.txt"))) {
  		long lastNumber=0;
  		/*cycle to create instances of the seller class, the condition for continuing the cycle is 
  		 * that i is less than the random number obtained in qEmployees.*/ 
  	    for (int i=0;i<qEmployees;i++) {
  	    	Seller seller=new Seller();
  	        if(i==0) {	
  	        	/*the first line i=0 corresponds to the headers of the .txt file
  	        	 * DocumentType,DocumentId,FirstName,LastName*/
  	        	sellerInfo="TipoDocumento;NúmeroDocumento;NombresVendedor;ApellidosVendedor";
  	        	//write headers to file
  	        	writer.write(sellerInfo);
  	        	//write line break to file
  	        	writer.newLine();
  	        }else
  	        	//i!=1 are no longer headers, the sellers' personal data is written to the file
  	        	writer.newLine();
  	        	//get a random document type
  	        	seller.setDocumentType(randomName.documentType());
  	        	//get a random document number, send the last document number as a parameter so that this is not repeated
  	        	long newNumber=randomNumber.documentNumber(lastNumber);
  	        	lastNumber=newNumber;
  	        	seller.setDocumentNumber(newNumber);
  	        	//get a random name
  	        	seller.setFirstName(randomName.firstName());
  	        	//get a random last name
  	        	seller.setLastName(randomName.lastName());
  	        	//prepare the seller data on a new line using the get methods of the instance.
  	        	sellerInfo= seller.getDocumentType()+";"+seller.getDocumentNumber()+";"+seller.getFirstName()+";"+seller.getLastName();
      			//write the line to the file
  	        	writer.write(sellerInfo);
  	        	//Save the instance with the seller's data in the ArrayList for later use.
      			salesMenList.add(seller);	 	
  	    }
  	}catch (IOException e) {
  		//catch the exception, print to console and return false
  		System.err.println("error exporting file: " + e.getMessage());
  		return false;
  	}
  	//If the loop and file export were executed, return true
  	return true; 
	}
	
	public boolean createProductsFile(){
		//in productInfo the lines that the .txt file will contain are assigned
		String productInfo=null;
		/*Creates a random number for the products in the product list, by calling the method on 
		 * the RandonNumbers class instance created by the constructor.
		 */
		int qProducts =randomNumber.randomProducts();
		//initializes a BufferedWriter to write to the ProductsInfo.txt file
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("ProductsInfo.txt"))) {
    		/*Through a loop we create instances of the products class, the conditional of the loop 
    		 * is the variable qProducts
    		 */
    		for (int i=0;i<qProducts;i++) {
    			Product product=new Product();
    			/*In the first line of the .txt file we write the headers*/
    	        if(i==0) {	
    	        	productInfo="IDProducto;NombreProducto;PrecioPorUnidadProducto";
    	        	writer.write(productInfo);
    	        	writer.newLine();
    	        }else
    	        	writer.newLine();
    	        	product.setId(i+1);
    	        	/*For each product instance, a characteristic and a pseudo-random price are given and the 
    	        	 * corresponding attribute is changed.*/
    	        	product.setProductName(randomName.stationeryProduct()+" "+randomName.characteristicsProduct());;
    	        	product.setProductPrice(randomNumber.productPrice());;
    	        	/*prepare the line that will be written to the file*/
    	        	productInfo= product.getId()+";"+product.getProductName()+";"+product.getProductPrice();
    	        	/*write the line to the file and give a line break*/
        			writer.write(productInfo);
        			/*save the product instance in an array to use in creating orders*/
        			productList.add(product);
    	    }
    	}catch (IOException e) {
    		System.err.println("error exporting file: " + e.getMessage());
    		//catch the exception, print to console and return false
    		return false;
    	}
    	//If the loop and file export were executed, return true
    	return true;
    }
	
	public boolean createSalesMenFile() {
		//in orderInfo the lines that the .txt file will contain are assigned
		String orderInfo=null;
		/*generates a random number to define how many order orders will be generated, this number is divided into two depending on how
		 *  many sellers were previously created*/
		int qOrders =(int) salesMenList.size()/2;
		/*Through a cycle, create the number of orders, each order is associated with the ID number of a seller, which is selected randomly 
		 * in the arraylist of sellers previously created, for this we send the ArrayList as a parameter.
		 */
    	for (int i=0;i<qOrders;i++) {
    		int idSeller=randomNumber.randomIdSeller(salesMenList);
    		/*initializes a BufferedWriter to write to the file Order0+i.txt, this causes us to have dynamic names for each file; 
    		 * The files are created in the Orders folder.
    		 */
    	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Orders/Order0"+i+".txt"))){
    	    	/*We obtain the attributes of the instantiated seller through its document 
    	    	 * number and write it as the order header
    	    	 */
    	    	orderInfo=salesMenList.get(idSeller).getDocumentType()+";"+salesMenList.get(idSeller).getDocumentNumber();
    	    	writer.write(orderInfo);
        	    writer.newLine();
        	    /*Through a cycle, a random id is selected from the list of products and a pseudo random number of the 
        	     * quantity sold of the product is generated.
        	     */
    	    	for(int j=0;j<randomNumber.productPerOrder();j++) {
    	    		/*prepares the line to write to the file and the line is 
    	    		 * written to the file and then a line break
    	    		 */
    	    		orderInfo=randomNumber.randomIdProduct(productList)+";"+randomNumber.qProductPerOrder();
    	    		writer.write(orderInfo);
    	    		writer.newLine();
    	    	}
    	    }catch (IOException e) {
    	    	System.err.println("error exporting file: " + e.getMessage());
    	    	//catch the exception, print to console and return false
    	    	return false;
    	    }
    	}
    	//If the loop and file export were executed, return true
    	return true;
	}
	
}
