package CentralSalesCenterOperations;


public class Main {

	public static void main(String[] args) {
		/*Instantiate an object of the GenerateInfoFiles class, the constructor of the instance will 
		 *create the .txt files with information about employees, products and orders
		 */
		GenerateInfoFiles newFiles = new GenerateInfoFiles();
		/*Creates an instance of an object of the GenerateISalesReport class, the instance constructor 
		 * imports the .txt files created by the GenerateInfoFiles class with information about employees, products and orders.
		 */
		GenerateSalesReport salesReport = new GenerateSalesReport();

		salesReport.GenerateReportsSales(newFiles.productList, newFiles.salesMenList, newFiles.orderList);
		
		
	}
}
