package Security;

public aspect PolicyAccess {
	pointcut productRead() : execution(void ProductManager.readProducts(..));
	pointcut productAdd() : execution(void ProductManager.addProduct(..));
	pointcut productUpdate() : execution(void ProductManager.updateProduct(..));
	pointcut productRemove() : execution(void ProductManager.RemoveProduct(..));
	
	pointcut orderRead() : execution(void OrderManager.readOrders(..));
	pointcut orderAdd() : execution(void OrderManager.addOrder(..));
	pointcut orderUpdate() : execution(void OrderManager.updateOrder(..));
	pointcut orderRemove() : execution(void OrderManager.removeOrder(..));
	
	void around() : productRead() {
		if (Authenticator.hasPermission(PermissionManager.productRead))
			proceed();
	}
	
	void around() : productAdd() {
		if (Authenticator.hasPermission(PermissionManager.productAdd))
			proceed();
	}
	
	void around() : productUpdate() || productRemove() {
		if (Authenticator.hasPermission(PermissionManager.productUpdate))
			proceed();
	}
	
	void around() : orderRead() {
		if (Authenticator.hasPermission(PermissionManager.orderRead))
			proceed();
	}
	
	void around() : orderAdd() {
		if (Authenticator.hasPermission(PermissionManager.orderAdd))
			proceed();
	}
	
	void around() : orderUpdate() || orderRemove() {
		if (Authenticator.hasPermission(PermissionManager.orderUpdate))
			proceed();
	}
}