package Security;

import java.util.*;

public class UserManager {
	private RoleManager roleManager = new RoleManager();
	private Map<String, User> users = new HashMap<>();
	
	public UserManager() {
		User user1 = new User("John", "password123");
		user1.addRole(roleManager.director);

		User user2 = new User("Emily", "password");
		user2.addRole(roleManager.supplierManager);
		
		User user3 = new User("Bob", "weakPassword");
		user3.addRole(roleManager.procurementManager);
		
		addUser(user1);
		addUser(user2);
		addUser(user3);
	}
	
	public User getUser(String username) {
		return users.get(username);
	}
	
	private void addUser(User user) {
		users.put(user.username, user);
	}
}
