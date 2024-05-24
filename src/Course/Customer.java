package Course;

public class Customer {
	 private String firstName;
	    private String lastName;

	    Customer(String firstName, String lastName) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	    }

	    String getFirstName() {
	        return this.firstName;
	    }

	    String getLastName() {
	        return this.lastName;
	    }

	    void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
}
