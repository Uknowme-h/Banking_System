package Course;

public class Account extends Customer{
	  int accountNumber;
	    int balance;
	    String key;

	    Account(String FName, String LName, int accountNumber, int balance ,String key) {
	        super(FName, LName);
	        this.accountNumber = accountNumber;
	        this.balance = balance;
	        this.key = key;
	    }

	    void deposit(int amount) {
	        balance += amount;
	    }

	    void withdraw(int amount) {
	        if (balance >= amount) {
	            balance -= amount;
	        } else {
	            System.out.println("Insufficient balance");
	        }
	    }
	    int getAccountNumber() {
	        return this.accountNumber;
	    }
	    
	    String getkey() {
	    	return this.key;
	    }

	    double getBalance() {
	        return this.balance;
	    }
}
