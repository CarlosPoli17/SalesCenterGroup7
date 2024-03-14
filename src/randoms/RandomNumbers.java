package randoms;

public class RandomNumbers {
		//generate a 10-digit pseudorandom number using the math class
	public long documentNumber(long lastNumber) {		
		long cc = (long) (Math.random() * 9_000_000_000L) + 1_000_000_000L;
		// If the generated number is equal to the method parameter, we recursively generate another number
		if(lastNumber==cc) {
			documentNumber(lastNumber);
		}
		//If the generated number is different from the method parameter, we return the number
		return cc;
	}
	//obtain a number in the range between 10 and 30, we return it as the number of salespeople in the company
	public int randomEmployees() {
    	int num = (int) (Math.random() * 21) + 10;;
		return num;	
    }
}
