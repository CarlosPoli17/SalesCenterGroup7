package randoms;

import java.util.ArrayList;
import java.util.Random;

import temps.Product;
import temps.Seller;

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
	
	public int randomProducts() {
    	int num = (int) (Math.random() * 51) + 50;
		return num;	
    }
	
	public long productPrice() {		
		long price = (long) (Math.random() * 100_000L) + 1_000L;
		return price;
	}
	
	public int randomOrders() {
    	int num = (int) (Math.random() * 9) + 2;
		return num;	
	}
	
	public int productPerOrder() {
    	int num = (int) (Math.random() * 9) + 2;
		return num;	
	}
	
	public int qProductPerOrder() {
    	int num = (int) (Math.random() * 9) + 1;
		return num;
	}
	
	public int randomIdProduct(ArrayList<Product> productList) {
		Random random = new Random();
		int num = random.nextInt(productList.size());
		if(num==0) {
			randomIdProduct(productList);
		}
		return num;	
	}
	
	public int randomIdSeller(ArrayList<Seller> sellerList) {
		Random random = new Random();
		int num = random.nextInt(sellerList.size());
		return num;
	}
	
}
