package Security;

import java.util.*;

public class User {
	String username;
	String password;
	List<Role> roles = new LinkedList<>();
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	protected void addRole(Role role) {
		roles.add(role);
	}
	
	public boolean hasPermission(Permission permission) {
		for (Role role : roles) {
			if (role.hasPermission(permission))
				return true;
		}
		
		return false;
	}
}
