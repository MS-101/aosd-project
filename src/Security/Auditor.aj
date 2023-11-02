package Security;

import Logistics.*;
import Logistics.Product.ProductType;

public aspect Auditor {
	public pointcut productConstructor(ProductType type, String name, String description) : call(Product.new(ProductType, String, String)) && args(type, name, description);
	
	Product around(ProductType type, String name, String description) : productConstructor(type, name, description) {
		if (type == ProductType.MACHINERY || type == ProductType.TOOLS)
			return new AuditedProduct(type, name, description, Authenticator.getCurrentUser());
		else
			return proceed(type, name, description);
	}
}
