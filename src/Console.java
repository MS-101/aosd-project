import java.util.*;

public class Console {
	Scanner input = new Scanner(System.in);
	OrderManager orderManager;
	ProductManager productManager;
	
	public Console() {
		productManager = new ProductManager();
		orderManager = new OrderManager(productManager);
	}
	
	public boolean ReadCommand() {
		System.out.print("Write command (type 'help' for instructions): ");
		return ParseCommand(input.nextLine());
	}
	
	public void PrintHelp() {
		System.out.println("Available basic commands:");
		System.out.println("================================================================================================");
		System.out.println("help - prints this message");
		System.out.println("quit - terminate application");
		System.out.println("order <command> - use orders commands (type 'orders help' for more instructions)");
		System.out.println("inventorie <command> - use inventories commands (type 'inventories help' for more instructions)");
	}
	
	public boolean ParseCommand(String command) {
		String[] tokens = command.split(" ");
		
		if (tokens[0] == "quit")
			return false;
		else if (tokens[0].equals("help"))
			PrintHelp();
		else if (tokens[0].equals("order"))
			orderManager.ParseCommand(command.substring(tokens[0].length() + 1));
		else if (tokens[0].equals("product"))
			productManager.ParseCommand(command.substring(tokens[0].length() + 1));
		else
			System.out.println("Command unrecognised.");
		
		return true;
	}
}
