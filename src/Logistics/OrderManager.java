package logistics;

import java.util.*;
import java.util.Map.Entry;

public class OrderManager implements IConsoleManager {
	private Map<Integer, Order> orders = new HashMap<>();
	private ProductManager productManager;
	
	public OrderManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	
	public void printHelp() {
		System.out.println("Available order commands:");
		System.out.println("=========================");
		System.out.println("order help - prints this message");
		System.out.println("order read - prints all existing orders");
		System.out.println("order add description '<description>' items <item1ID>/<item1Count> <item2ID>/<item2Count> ... - create new order");
		System.out.println("order update <ID> description '<description>' items <item1ID>/<item1Count> <item2ID>/<item2Count> ... - update existing order");
		System.out.println("order remove <ID> - delete existing order");
	}
	
	public void parseCommand(String command) {
		String[] tokens = command.split(" ");
		if (tokens[0].equals("help")) {
			printHelp();
		} else if (tokens[0].equals("read")) {
			readOrders();
		} else if (tokens[0].equals("add")) {
			try {
				tokens = command.split("'");
				String description = tokens[1];
				tokens = tokens[2].split(" ");
				
				OrderItem[] items = new OrderItem[tokens.length - 2];
				for (int i = 2; i < tokens.length; i++) {
					String itemString = tokens[i];
					String[] itemTokens = itemString.split("/");
					
					int productID = Integer.parseInt(itemTokens[0]);
					Product product = productManager.getProduct(productID);
					if (product == null)
						throw new Exception("Product does not exist!");
					int count = Integer.parseInt(itemTokens[1]);
					
					items[i-2] = new OrderItem(product, count);
				}
					
				addOrder(description, items);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else if (tokens[0].equals("update")) {
			try {
				int orderID = Integer.parseInt(tokens[1]);
				
				tokens = command.split("'");
				String description = tokens[1];
				tokens = tokens[2].split(" ");
				
				OrderItem[] items = new OrderItem[tokens.length - 2];
				for (int i = 2; i < tokens.length; i++) {
					String itemString = tokens[i];
					String[] itemTokens = itemString.split("/");
					
					int productID = Integer.parseInt(itemTokens[0]);
					Product product = productManager.getProduct(productID);
					if (product == null)
						throw new Exception("Product does not exist!");
					int count = Integer.parseInt(itemTokens[1]);
					
					items[i-2] = new OrderItem(product, count);
				}
				
				updateOrder(orderID, description, items);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else if (tokens[0].equals("remove")) {
			try {
				int id = Integer.parseInt(tokens[1]);
				removeOrder(id);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else {
			System.out.println("Command unrecognised.");
		}
	}
	
	public void readOrders() {
		System.out.println("Printing orders:");
		System.out.println("================");
		
        for (Entry<Integer, Order> orderEntry : orders.entrySet()) {
        	int id = orderEntry.getKey();
            Order order = orderEntry.getValue();
            
		    System.out.println(id + " (id) | " + order.toString());
        }
	}
	
	public Order getOrder(int id) {
		return orders.get(id);
	}
	
	public void addOrder(String description, OrderItem[] items) {
		int id = 1;
		Set<Integer> orderIDs = orders.keySet();
		if (!orderIDs.isEmpty())
			id = Collections.max(orderIDs)+1;
		
		orders.put(id, new Order(description, items));
		System.out.println("Created new order with id " + id + ".");
	}
	
	public void updateOrder(int id, String description, OrderItem[] items) {
		Order order = getOrder(id);
		if (order != null) {
			order.setDescription(description);
			order.setItems(items);
			
			System.out.println("Updated order with id " + id + ".");
		} else {
			System.out.println("Order with id " + id + " was not found!");
		}
	}
	
	public void removeOrder(int id) {
		Order order = getOrder(id);
		if (order != null) {
			orders.remove(id);
			System.out.println("Deleted order with id " + id + "!");
		} else {
			System.out.println("Order with id " + id + " was not found!");	
		}
	}
}
