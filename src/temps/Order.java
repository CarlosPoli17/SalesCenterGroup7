package temps;

public class Order {
    private int Id;
	private String documentType;
	private long documentNumber;
    private int productId;
    private int quantity;
	

    public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

    public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public long getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(long documentNumber) {
		this.documentNumber = documentNumber;
	}

    public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

    public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
