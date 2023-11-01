package Logistics;

import java.util.*;

public class Console {
	Scanner input = new Scanner(System.in);
	OrderManager orderManager;
	ProductManager productManager;
	
	public Console() {
		productManager = new ProductManager();
		orderManager = new OrderManager(productManager);
	}
	
	public boolean readCommand() {
		System.out.print("Write command (type 'help' for instructions): ");
		return parseCommand(input.nextLine());
	}
	
	public void printHelp() {
		System.out.println("Available basic commands:");
		System.out.println("=========================");
		System.out.println("help - prints this message");
		System.out.println("product <command> - use product commands (type 'product help' for more instructions)");
		System.out.println("order <command> - use order commands (type 'order help' for more instructions)");
		System.out.println("quit - terminate application");
	}
	
	public boolean parseCommand(String command) {
		String[] tokens = command.split(" ");
		
		if (tokens[0].equals("quit")) {
			System.out.println("Exiting application!");
			
			return false;
		} else if (tokens[0].equals("help"))
			printHelp();
		else if (tokens[0].equals("order"))
			orderManager.parseCommand(command.substring(tokens[0].length() + 1));
		else if (tokens[0].equals("product"))
			productManager.parseCommand(command.substring(tokens[0].length() + 1));
		else
			System.out.println("Command unrecognised.");
		
		return true;
	}
}
