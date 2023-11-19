package logistics;

public class Order {
	private String description;
	private OrderItem[] items;
	
	public Order(String description, OrderItem[] items) {
		this.description = description;
		this.items = items;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public OrderItem[] getItems() {
		return items;
	}
	
	public void setItems(OrderItem[] items) {
		this.items = items;
	}
	
    @Override
    public String toString() {
        String itemsString = "";
		for (OrderItem item : items) {
			if (!itemsString.isEmpty())
				itemsString += " ";
			itemsString += item.getProduct().getName() + "/" + item.getCount();
		}
		itemsString += " (item/count)";
    	
    	return getDescription() + " (description) | " + itemsString;
    }
}
