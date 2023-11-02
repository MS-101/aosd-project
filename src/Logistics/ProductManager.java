package Logistics;

import java.util.*;
import java.util.Map.Entry;

import Logistics.Product.ProductType;

public class ProductManager implements IConsoleManager {
	private Map<Integer, Product> products = new HashMap<>();
	
	public ProductManager() {
		products.put(1, new Product(ProductType.MACHINERY, "someMachine", "description of machine"));
		products.put(2, new Product(ProductType.TOOLS, "someTool", "description of tool"));
		products.put(3, new Product(ProductType.MATERIALS, "someMaterial", "description of material"));
	}
	
	public void printHelp() {
		System.out.println("Available product commands:");
		System.out.println("===========================");
		System.out.println("product help - prints this message");
		System.out.println("product read - prints all existing products");
		System.out.println("product add type <ID> name '<name>' description '<description>' - create new product");
		System.out.println("product update <ID> name '<name>' description '<description>' - update existing product");
		System.out.println("product remove <ID> - delete existing product");
	}
	
	public void parseCommand(String command) {
		String[] tokens = command.split(" ");
		if (tokens[0].equals("help")) {
			printHelp();
		} else if (tokens[0].equals("read")) {
			readProducts();
		} else if (tokens[0].equals("add")) {
			try {
				int idType = Integer.parseInt(tokens[2]);
				ProductType type = ProductType.values()[idType];
				
				tokens = command.split("'");
				String name = tokens[1];
				String description = tokens[3];
				
				addProduct(type, name, description);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else if (tokens[0].equals("update")) {
			try {
				int id = Integer.parseInt(tokens[1]);
				
				tokens = command.split("'");
				String name = tokens[1];
				String description = tokens[3];
				
				updateProduct(id, name, description);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else if (tokens[0].equals("remove")) {
			try {
				int id = Integer.parseInt(tokens[1]);
				removeProduct(id);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else {
			System.out.println("Command unrecognised.");
		}
	}
	
	public void readProducts() {
		System.out.println("Printing products:");
		System.out.println("==================");
		
        for (Entry<Integer, Product> productEntry : products.entrySet()) {
        	int id = productEntry.getKey();
            Product product = productEntry.getValue();
            
			System.out.println(id + " (id) | " + product.toString());
        }
	}
	
	public Product getProduct(int id) {
		return products.get(id);
	}
	
	public void addProduct(ProductType type, String name, String description) {
		int id = 1;
		Set<Integer> productIDs = products.keySet();
		if (!productIDs.isEmpty())
			id = Collections.max(productIDs)+1;
		
		products.put(id, new Product(type, name, description));
		System.out.println("Created new product with id " + id + ".");
	}
	
	public void updateProduct(int id, String name, String description) {
		Product product = getProduct(id);
		if (product != null) {
			product.setName(name);
			product.setDescription(description);
			
			System.out.println("Updated product with id " + id + ".");
		} else {
			System.out.println("Order with id " + id + " was not found!");
		}
	}
	
	public void removeProduct(int id) {
		Product product = getProduct(id);
		if (product != null) {
			products.remove(id);
			System.out.println("Deleted product with id " + id + "!");
		} else {
			System.out.println("Product with id " + id + " was not found!");	
		}
	}
}
