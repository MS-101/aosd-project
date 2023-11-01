package Security;

public class PermissionManager {
	static final Permission productRead = new Permission("productRead", "permission to read products.");
	static final Permission productAdd = new Permission("productAdd", "permission to create new products.");
	static final Permission productUpdate = new Permission("productUpdate", "permission to update or delete existing products.");
	
	static final Permission orderRead = new Permission("orderRead", "permission to read orders.");
	static final Permission orderAdd = new Permission("orderRead", "permission to create new orders.");
	static final Permission orderUpdate = new Permission("orderUpdate", "permission to update or delete existing orders.");
}
