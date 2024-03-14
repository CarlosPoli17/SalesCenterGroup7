package temps;

public class Seller {
	
	/*Class attributes, a seller has document type, document number, first name and last name; 
	 * getter and setter methods are added for each attribute.
	 */
	private String documentType;
	private long documentNumber;
	private String firstName;
	private String lastName;
	

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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
