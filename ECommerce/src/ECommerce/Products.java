package ECommerce;

import java.util.ArrayList;
import java.util.List;

public class Products extends Cart {
public static ArrayList<Product> products = new ArrayList<Product>();
	
	public Products() {
	}
	public List<Product> getProducts() {
		return products;
	}
	public static Product getProductById(int id) {
		Product product = null;
		List<Product> products = new Products().getProducts();
		for (Product product2 : products) {
			if(product2.id == id) {
				product = product2;
				break;
			}
		}
		return product;	
	}
	public static void initStoreItem() {
		String [] productName = {"Lung Cancer", "Liver Cancer"};
		double [] productPrice = {40.00d, 20.00d};
		int [] productStock = {2, 5};
		
		for (int i = 0; i < productName.length; i++) {
			products.add(new Product(i+1, productName[i], productPrice[i], productStock[i]));
		}
 	}
	public static void addProducts(String name, double price, int stock) {
		int lastId = products.size();
		products.add(new Product(lastId+1, name, price, stock));
	}
	public static void deleteProducts(int id) {
		Product rm = getProductById(id);
		products.remove(rm);
	}
}
