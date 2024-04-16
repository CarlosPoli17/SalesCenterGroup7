package CentralSalesCenterOperations;

import java.util.List;

import temps.Order;
import temps.Product;
import temps.Seller;

public class GenerateSalesReport {

	public static void main(String[] args) {
        
    }       

    public void GenerateReportsSales(List<Product> productList,List<Seller> sellerList, List<Order> orderList)
    {
        for (Order order : orderList) {
			System.out.println(order.getDocumentNumber()+";"+order.getDocumentType()+";"+order.getProductId()+";"+order.getQuantity());
		}

        for (Seller seller : sellerList) {
			System.out.println(seller.getDocumentNumber()+";"+seller.getFirstName()+";"+seller.getLastName());
		}

        for (Product product : productList) {
			System.out.println(product.getProductName()+";"+product.getProductPrice());
		}
    }
}
