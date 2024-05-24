package Course;

import java.util.*;
import java.awt.EventQueue;


public class Main {
    public static void main(String[] args) {
    	ReadAccounts readAccounts = new ReadAccounts("Account.csv");

        LinkedList<Account> accounts = new LinkedList<>();
        LinkedList<String> fname = new LinkedList<>(readAccounts.getFirstNames());
        LinkedList<String> Lname = new LinkedList<>(readAccounts.getLastNames());
        LinkedList<Integer> account = new LinkedList<>(readAccounts.getAccounts());
        LinkedList<Integer> balance = new LinkedList<>(readAccounts.getBalance());
        for (int i = 0; i < readAccounts.firstNames.size(); i++) {
            accounts.add(new Account(fname.get(i), Lname.get(i), account.get(i), balance.get(i)));
        }
     
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI(accounts);
                    frame.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}