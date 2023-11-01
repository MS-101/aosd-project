package Security;

import java.time.*;
import Logistics.*;

public class AuditedProduct extends Product {
	User createdBy;
	LocalDateTime createdDate;
	User editedBy;
	LocalDateTime editedDate;
	
	public AuditedProduct(String name, String description, User user) {
		super(name, description);
		
		createdBy = user;
		createdDate = LocalDateTime.now();
		
		editedBy = user;
		editedDate = LocalDateTime.now();
	}
	
	public void setName(String name) {
		super.setName(name);
		
		editedBy = Authenticator.getCurrentUser();
		editedDate = LocalDateTime.now();
	}
	
	public void setDescription(String name) {
		super.setDescription(name);
		
		editedBy = Authenticator.getCurrentUser();
		editedDate = LocalDateTime.now();
	}
	
    @Override
    public String toString() {
    	return getName() + " (name) | " + getDescription() + " (description) | " 
    			+ createdBy.username + " (createdBy) | " + createdDate + " (createdDate) | "
    			+ editedBy.username + " (editedBy) | " + editedDate + " (editedDate)";
    }
}
