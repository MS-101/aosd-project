package logistics;

public class Product {
	public enum ProductType {
		MACHINERY,
		TOOLS,
		MATERIALS,
	}
	
	private ProductType type;
	private String name;
	private String description;

	public Product(ProductType type, String name, String description) {
		this.type = type;
		this.name = name;
		this.description = description;
	}
	
	public ProductType getType() {
		return type;
	}
 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	 
	@Override
	public String toString() {
		return type.name() + " (type) | " + name + " (name) | " + description + " (description)";
	}
}
