package temps;

public class Product {

	/*Class attributes, a product has id, name and price; getter and setter methods 
	 * are added for each attribute
	 */
	private int Id;
	private String productName;
	private long productPrice;
	

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	
}
