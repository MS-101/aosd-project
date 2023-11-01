package Security;

import java.time.*;
import Logistics.*;

public class AuditedOrder extends Order {
	User createdBy;
	LocalDateTime createdDate;
	User editedBy;
	LocalDateTime editedDate;
	
	public AuditedOrder(String description, OrderItem[] items, User user) {
		super(description, items);
		
		createdBy = user;
		createdDate = LocalDateTime.now();
		
		editedBy = user;
		editedDate = LocalDateTime.now();
	}
	
	public void setDescription(String description) {
		super.setDescription(description);
		
		editedBy = Authenticator.getCurrentUser();
		editedDate = LocalDateTime.now();
	}
	
	public void setItems(OrderItem[] items) {
		super.setItems(items);
		
		editedBy = Authenticator.getCurrentUser();
		editedDate = LocalDateTime.now();
	}
	
    @Override
    public String toString() {
        String itemsString = "";
		for (OrderItem item : getItems()) {
			if (!itemsString.isEmpty())
				itemsString += " ";
			itemsString += item.getProduct().getName() + "/" + item.getCount();
		}
		itemsString += " (item/count)";
    	
    	return getDescription() + " (description) | " + itemsString
    			+ createdBy.username + " (createdBy) | " + createdDate + " (createdDate) | "
    			+ editedBy.username + " (editedBy) | " + editedDate + " (editedDate)";
    }
}
