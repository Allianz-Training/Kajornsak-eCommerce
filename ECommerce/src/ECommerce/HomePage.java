package ECommerce;

import java.util.List;
import java.util.Scanner;

public class HomePage {
	Cart cart = new Cart();
	private int choice = 0;
    List<Product> allProducts = new Products().getProducts();
	
	public HomePage() {
		Products.initStoreItem();
		menu();
	}
	
	private void startMenu() {
		System.out.println("What do you want to do?");
		System.out.println("1. Purchase order");
		System.out.println("2. Manage product");
	}
	private void purchaseOrderMenu() {
		System.out.println("1. Add to Cart");
		System.out.println("2. Remove From Cart");
		System.out.println("3. Show cart items");
		System.out.println("0. Back");
	}
	private void manageProductMenu() {
		System.out.println("1. Add product");
		System.out.println("2. Delete Product");
		System.out.println("3. Back");
	}
	private void menu() {
		startMenu();
		choice = getUserInput();
		while(choice != 0) {
			if(choice==1) {
				displayStoreProducts();
				purchaseOrderMenu();
				getUserInput();
				purchaseChoice();
				break;
			}
			if(choice==2) {
				displayStoreProducts();
				manageProductMenu();
				getUserInput();
				manageChoice();
				break;
			}
			else break;
		}
		menu();
	}
	private void purchaseChoice() {
		while(choice!=0) {
			if(choice==1) {
				addProductToCart();
				showCart();
				break;
			}
			if(choice==2) {
				removeProductFromCart();
				break;
			}
			if(choice==3) {
				showCart();
				break;
			}
			else break;
		}
		menu();
	}
	private void manageChoice() {
		while(choice!=0) {
			if(choice==1) {
				addProduct();
				menu();
			}
			if(choice==2) {
				deleteProduct();
				menu();
			}
			if(choice==3) {
				menu();
			}
			else break;
		}
		menu();
	}
	private int getUserInput() throws NumberFormatException {
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		return choice;
	}
	private String getInputName() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	private double getInputPrice() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
	private int getInputStock() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	private void displayStoreProducts() {
        for (Product prod: allProducts) {
            System.out.println(
                    prod.getId() + "- " +
                            prod.getName() + " " +
                            prod.getPrice() + " " +
                            prod.getStock()
            );
        }
    }
	private void showCart() {
        cart.printCartItems();
    }
	private void addProductToCart() {
		int pid = getUserInput();
	    cart.addProductById(pid);      
	}
	private void removeProductFromCart() {
        int pid = getUserInput();
        cart.removeProductById(pid);
    }
	private void addProduct() {
		System.out.println("Products name : ");
		String name = getInputName();
		System.out.println("Product price : ");
		double price = getInputPrice();
		System.out.println("Product stock : ");
		int stock = getInputStock();
		
		Products.addProducts(name, price, stock);
	}
	private void deleteProduct() {
		int id = getUserInput();
		Products.deleteProducts(id);
	}
}
