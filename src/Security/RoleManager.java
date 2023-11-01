package Security;

public class RoleManager {
	final Role director = new Role("director", "has unlimited access");
	final Role supplierManager = new Role("supplier manager", "responsible for maintaining product catalog");
	final Role procurementManager = new Role("procurement manager", "responsible for ordering products");
	
	public RoleManager() {
		director.addPermission(PermissionManager.productRead);
		director.addPermission(PermissionManager.productAdd);
		director.addPermission(PermissionManager.productUpdate);
		director.addPermission(PermissionManager.orderRead);
		director.addPermission(PermissionManager.orderAdd);
		director.addPermission(PermissionManager.orderUpdate);
		
		supplierManager.addPermission(PermissionManager.productRead);
		supplierManager.addPermission(PermissionManager.productAdd);
		supplierManager.addPermission(PermissionManager.productUpdate);
		
		procurementManager.addPermission(PermissionManager.orderRead);
		procurementManager.addPermission(PermissionManager.orderAdd);
		procurementManager.addPermission(PermissionManager.orderUpdate);
	}
}
