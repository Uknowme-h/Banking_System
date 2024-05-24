package Course;

public class Account extends Customer{
	  int accountNumber;
	    int balance;

	    Account(String FName, String LName, int accountNumber, int balance) {
	        super(FName, LName);
	        this.accountNumber = accountNumber;
	        this.balance = balance;
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

	    double getBalance() {
	        return this.balance;
	    }
}
