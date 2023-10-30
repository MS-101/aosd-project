import java.util.*;
import java.util.Map.Entry;

public class ProductManager implements IConsoleManager {
	private Map<Integer, Product> products = new HashMap<>();
	
	public void PrintHelp() {
		System.out.println("Available product commands:");
		System.out.println("=====================================================================================================");
		System.out.println("product help - prints this message");
		System.out.println("product read - prints all existing products");
		System.out.println("product add name '<name>' description '<description>' - create new product");
		System.out.println("product update <ID> name '<name>' description '<description>' - update existing product");
		System.out.println("product remove <ID> - delete existing product");
	}
	
	public void ParseCommand(String command) {
		String[] tokens = command.split(" ");
		if (tokens[0].equals("help"))
			PrintHelp();
		else if (tokens[0].equals("read"))
			PrintProducts();
		else if (tokens[0].equals("add")) {
			try {
				tokens = command.split("'");
				String name = tokens[1];
				String description = tokens[3];
				
				AddProduct(name, description);
			} catch (Exception ex) {
				System.out.println("Parsing error.");	
			}
		} else if (tokens[0].equals("update")) {
			try {
				int id = Integer.parseInt(tokens[1]);
				
				tokens = command.split("'");
				String name = tokens[1];
				String description = tokens[3];
				
				UpdateProduct(id, name, description);
			} catch (Exception ex) {
				System.out.println("Parsing error.");
			}
		} else if (tokens[0].equals("remove")) {
			try {
				int id = Integer.parseInt(tokens[1]);
				RemoveProduct(id);
			} catch (Exception ex) {
				System.out.println("Parsing error.");
			}
		} else {
			System.out.println("Command unrecognised.");
		}
	}
	
	public void PrintProducts() {
		System.out.println("Printing products:");
		System.out.println();
		System.out.println("ID | name | description");
		System.out.println("=======================");
		
        for (Entry<Integer, Product> productEntry : products.entrySet()) {
        	int id = productEntry.getKey();
            Product product = productEntry.getValue();
			
		    System.out.println(id + " | " + product.name + " | " + product.description);
        }
		System.out.println();
	}
	
	public Product GetProduct(int id) {
		return products.get(id);
	}
	
	public void AddProduct(String name, String description) {
		int id = 1;
		Set<Integer> productIDs = products.keySet();
		if (!productIDs.isEmpty())
			id = Collections.max(productIDs)+1;
		
		products.put(id, new Product(name, description));
		System.out.println("Created new product with id " + id + ".");
	}
	
	public void UpdateProduct(int id, String name, String description) {
		Product product = GetProduct(id);
		if (product != null) {
			product.name = name;
			product.description = description;
			
			System.out.println("Updated product with id " + id + ".");
		} else {
			System.out.println("Order with id " + id + " was not found!");
		}
	}
	
	public void RemoveProduct(int id) {
		Product product = GetProduct(id);
		if (product != null) {
			products.remove(id);
			System.out.println("Deleted product with id " + id + "!");
		} else {
			System.out.println("Product with id " + id + " was not found!");	
		}
	}
}
