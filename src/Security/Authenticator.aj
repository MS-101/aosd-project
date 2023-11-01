package Security;

import java.util.*;

public aspect Authenticator {
	private UserManager userManager = new UserManager();
	private static User currentUser = null;
	
	private Scanner scanner = new Scanner(System.in);

	private pointcut main() : execution(void Main.main(String[]));
	private pointcut printHelp() : execution(void Console.printHelp());
	private pointcut parseCommand(String command) : execution(boolean Console.parseCommand(String)) && args(command);
	
	before() : main() {
		while (!requestLogin());
	}
	
	after() : printHelp() {
		System.out.println("logout - logout from the current account");
	}
	
	boolean around(String command) : parseCommand(command) {
		if (command.equals("logout")) {
			logout();
			return true;
		} else {
			return proceed(command);
		}
	}
	
	private void logout() {
		System.out.println("You have logged out of the current account!");
		while (!requestLogin());
	}
	
	private boolean requestLogin() {
		System.out.println("Enter your credentials:");
		System.out.print("name: ");
		String name = scanner.nextLine();
		System.out.print("password: ");
		String password = scanner.nextLine();
		
		if (login(name, password)) {
			System.out.println("Login successful!");
			return true;
		}
		else {
			System.out.println("Incorrect name or password!");
			return false;
		}
	}
	
	private boolean login(String name, String password) {
		User user = userManager.getUser(name);
		if (user != null && user.password.equals(password)) {
			currentUser = user;
			return true;
		}
		else
			return false;
	}

	static boolean hasPermission(Permission permission) {
		if (currentUser.hasPermission(permission))
			return true;
		else {
			System.out.println("You don't have the required permission - " + permission.name + " (" + permission.description + ") !");
			return false;
		}
	}
}
