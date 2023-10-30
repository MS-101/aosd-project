import java.util.*;

public aspect Authentificator {
	pointcut mainPointCut() : execution(public static void Main.main(String[]));
	
	/*
	before() : mainPointCut() {
		while (!RequestLogin());
	}
	*/
	
	private Dictionary<String, String> accounts = new Hashtable<>();
	
	private boolean Login(String name, String password) {
		return (accounts.get(name) == accounts.get(name));
	}
	
	private boolean RequestLogin() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("ZADAJTE SVOJE PRIHLASOVACIE ÚDAJE.");
			System.out.print("meno: ");
			String name = scanner.nextLine();
			System.out.print("heslo: ");
			String password = scanner.nextLine();
			
			return Login(name, password);
		}
	}
}
