package Course;

public class Transaction {
	 static void transfer(Account acc1, Account acc2, int amount) {
	        if (acc1.balance >= amount) {
	            acc1.withdraw(amount);
	            acc2.deposit(amount);
//	            JOptionPane.showMessageDialog(frame, "Transfered Sucessfully!");
	        } else {
	            System.out.println("Insufficient balance");
	        }
	    }
}
