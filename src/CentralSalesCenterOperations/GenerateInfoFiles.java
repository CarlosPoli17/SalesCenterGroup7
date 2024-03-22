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
			System.out.println("Los ficheros se han exportado correctamente.");	
		else 
			System.out.println("Ocurrio un error al exportar los ficheros.");
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
  	        	sellerInfo="TipoDocumento,NúmeroDocumento,NombresVendedor,ApellidosVendedor";
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
  	        	sellerInfo= seller.getDocumentType()+","+seller.getDocumentNumber()+","+seller.getFirstName()+","+seller.getLastName();
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
		String productInfo=null;
		int qProducts =randomNumber.randomProducts();
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("ProductsInfo.txt"))) {
    		for (int i=0;i<qProducts;i++) {
    			Product product=new Product();
    	        if(i==0) {	
    	        	/*DocumentType,DocumentId,FirstName,LastName*/
    	        	productInfo="IDProducto,NombreProducto,PrecioPorUnidadProducto";
    	        	writer.write(productInfo);
    	        	writer.newLine();
    	        }else
    	        	writer.newLine();
    	        	product.setId(i+1);
    	        	product.setProductName(randomName.stationeryProduct()+" "+randomName.characteristicsProduct());;
    	        	product.setProductPrice(randomNumber.productPrice());;
    	        	productInfo= product.getId()+","+product.getProductName()+","+product.getProductPrice();
        			writer.write(productInfo);
        			productList.add(product);
    	    }
    	}catch (IOException e) {
    		System.err.println("error exporting file: " + e.getMessage()); 
    		return false;
    	}
    	return true;
    }
	
	public boolean createSalesMenFile() {
		String orderInfo=null;
		int qOrders =(int) salesMenList.size()/2;	    
    	for (int i=0;i<qOrders;i++) {
    		int idSeller=randomNumber.randomIdSeller(salesMenList);
    	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Orders/Order0"+i+".txt"))){
    	    	orderInfo=salesMenList.get(idSeller).getDocumentType()+","+salesMenList.get(idSeller).getDocumentNumber();
    	    	writer.write(orderInfo);
        	    writer.newLine();
    	    	for(int j=0;j<randomNumber.productPerOrder();j++) {
    	    		orderInfo=randomNumber.randomIdProduct(productList)+","+randomNumber.qProductPerOrder();
    	    		writer.write(orderInfo);
    	    		writer.newLine();
    	    	}
    	    }catch (IOException e) {
    	    	System.err.println("error exporting file: " + e.getMessage());
    	    	return false;
    	    }
    	}
    	return true;
	}
	
}
