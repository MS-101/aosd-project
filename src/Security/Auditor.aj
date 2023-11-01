package Security;

import Logistics.*;

public aspect Auditor {
	public pointcut productConstructor(String username, String password) : call(Product.new(String, String)) && args(username, password);
	public pointcut orderConstructor(String description, OrderItem[] items) : call(Order.new(String, OrderItem[])) && args(description, items);
	
	Product around(String username, String password) : productConstructor(username, password) {
		return new AuditedProduct(username, password, Authenticator.getCurrentUser());
	}
	
	Order around(String description, OrderItem[] items) : orderConstructor(description, items) {
		return new AuditedOrder(description, items, Authenticator.getCurrentUser());
	}
}
