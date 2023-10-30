import java.time.*;

public class Order {
	LocalDate date;
	String description;
	OrderItem[] items;
	
	public Order(String description, OrderItem[] items) {
		this.date = LocalDate.now();
		this.description = description;
		this.items = items;
	}
	
}
