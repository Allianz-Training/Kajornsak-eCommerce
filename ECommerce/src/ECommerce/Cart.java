package ECommerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
List<Product> cartItems = new ArrayList<Product>();
	
	public void addProductById(int id) {
		Product product = getProductByid(id);
		addToCart(product);
	}
	public void removeProductById(int id) {
		Product product = getProductByid(id);
		cartItems.remove(product);
	}
	public void addToCart(Product product) {
		cartItems.add(product);
	}
	public Product getProductByid(int id) {
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
	
	
	public void printCartItems() {
		for(Product prod : cartItems) {
			System.out.println(prod.getName());
		}
	}
}
