package Course;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static JLabel Account_list;
    private LinkedList<Account> globalAccounts;
    private JTextField textField;
    private JTextField deposit_amount;
    private JLabel Account_deposit;
    private JLabel deposit_amount_label;
    private JButton Deposit;
	protected Component frame;
	private JButton Withdraw_btn;
	private JLabel Acc_1;
	private JLabel Acc_2;
	private JLabel Transfer_amount;
	private JTextField Transfer_text;
	private JTextField Acc_1_text;
	private JTextField Acc_2_text;
	private JButton Transfer_btn;
	private JTable table;
    private JScrollPane scrollPane;
    private JLabel Account_details;
	


  
    public GUI(LinkedList<Account> accounts) {
        this.globalAccounts = accounts;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1265, 716);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0, 0, 0));
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Home");
        mnNewMenu.setIcon(null);
        mnNewMenu.setForeground(new Color(255, 255, 255));
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Account Lists");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            	scrollPane.setVisible(true);
            	Account_details.setVisible(true);
            	table.setVisible(true);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                
                model.setRowCount(0);
                
//                for (Account account : globalAccounts) {
//                    model.addRow(new Object[]{
//                        account.getFirstName(),
//                        account.getLastName(),
//                        account.getAccountNumber(),
//                        account.getBalance()
//                    });
//                   
//                }
                		StringBuilder sb = new StringBuilder();
                try (
                	  
                	  BufferedWriter bw = new BufferedWriter(new FileWriter("Account.csv"))) { // Open CSV file with resource management
                	  for (Account account : globalAccounts) {
                		  model.addRow(new Object[]{
                                  account.getFirstName(),
                                  account.getLastName(),
                                  account.getAccountNumber(),
                                  account.getBalance()
                              });
                	   // System.out.print(account.getFirstName() + "," + account.getLastName() + "," + account.getAccountNumber() + "," + account.getBalance() + "\n");
                	    sb.append(account.getFirstName()).append(",").append(account.getLastName())
                	    .append(",").append(account.getAccountNumber()).append(",").append(account.getBalance()).append("\n");
                	    bw.write(sb.toString());
                	    sb.setLength(0);
                	    
                	    
                	  }
                	 
                	} catch (IOException io) {
                	  io.printStackTrace();
                	}
            }
        });
        mnNewMenu.add(mntmNewMenuItem);
        
        
        
        JMenu mnNewMenu_1 = new JMenu("Transactions");
        mnNewMenu_1.setForeground(new Color(255, 255, 255));
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Withdraw");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textField.setVisible(true);
        		Account_deposit.setVisible(true);
        		Account_deposit.setText("Enter the Account to withdraw from:");
        		deposit_amount_label.setVisible(true);
        		deposit_amount_label.setText("Enter the amount to withdraw :");
        		Deposit.setVisible(false);
        		deposit_amount.setVisible(true);
        		Withdraw_btn.setVisible(true);
        		Acc_2.setVisible(false);
        		Acc_1.setVisible(false);
        		Transfer_amount.setVisible(false);
        		
        		
        		Acc_1.setVisible(false);
        		Acc_2.setVisible(false);
        		Transfer_amount.setVisible(false);
        		Acc_2_text.setVisible(false);
        		Acc_1_text.setVisible(false);
        		Transfer_btn.setVisible(false);
        		Transfer_text.setVisible(false);
        		
        	}
        });
        mnNewMenu_1.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Deposit");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textField.setVisible(true);
        		Account_deposit.setVisible(true);
        		Account_deposit.setText("Enter the account to deposit in :");
        		deposit_amount_label.setVisible(true);
        		deposit_amount_label.setText("Enter the amount to deposit :");
        		Deposit.setVisible(true);
        		deposit_amount.setVisible(true);
        		Withdraw_btn.setVisible(false);
        		Acc_2.setVisible(false);
        		Acc_1.setVisible(false);
        		Transfer_amount.setVisible(false);
        		
        		Acc_1.setVisible(false);
        		Acc_2.setVisible(false);
        		Transfer_amount.setVisible(false);
        		Acc_2_text.setVisible(false);
        		Acc_1_text.setVisible(false);
        		Transfer_btn.setVisible(false);
        		Transfer_text.setVisible(false);
        	
        	}
        });
        mnNewMenu_1.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Transfer");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Deposit.setVisible(false);
        		deposit_amount.setVisible(false);
        		Withdraw_btn.setVisible(false);
        		deposit_amount_label.setVisible(false);
        		textField.setVisible(false);
        		Account_deposit.setVisible(false);
        		
        		//Transfer section 
        		Acc_1.setVisible(true);
        		Acc_2.setVisible(true);
        		Transfer_amount.setVisible(true);
        		Acc_2_text.setVisible(true);
        		Acc_1_text.setVisible(true);
        		Transfer_btn.setVisible(true);
        		Transfer_text.setVisible(true);
        	}
        });
        mnNewMenu_1.add(mntmNewMenuItem_3);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        Deposit = new JButton("Deposit");
        Deposit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			Boolean found = true;
                    String accountNumber = textField.getText();
                    int amount = Integer.parseInt(deposit_amount.getText());
                    for (Account account : globalAccounts) {
                        if (Integer.toString(account.accountNumber).equals(accountNumber)) {
                        	found = true;
                            account.deposit(amount);
                            JOptionPane.showMessageDialog(frame, "Deposited Sucessfully!");
                            mntmNewMenuItem.doClick();
                           break;
                        }else {
                        	found = false;
                        }
                    }
                    if(!found) {
                  	  JOptionPane.showMessageDialog(frame, "Account Doesnt exist!");
                    }
                }	 catch (NumberFormatException e1) {
                	JOptionPane.showMessageDialog(frame,"Invalid input for deposit amount or account number");
                }
        	}
        });
        Deposit.setBounds(776, 300, 100, 46);
        Deposit.setVisible(false);
        
        Withdraw_btn = new JButton("Withdraw");
        Withdraw_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		  Boolean found = true;
                  String accountNumber = textField.getText();
                  int amount = Integer.parseInt(deposit_amount.getText());
                  for (Account account : globalAccounts) {
                      if (Integer.toString(account.accountNumber).equals(accountNumber)) {
                    	  found = true;
                    	  if(account.getBalance()>= amount) {
	                          account.withdraw(amount);
	                          JOptionPane.showMessageDialog(frame, "Withdrawn Sucessfully!");
	                          mntmNewMenuItem.doClick();
	                          break;
                    	  }else {
                    		  JOptionPane.showMessageDialog(frame, "Insuffient Balance!");
                    	  }
                      }else {
                    	  found = false;
                      }
                  }
                  
                  if(!found) {
                	  JOptionPane.showMessageDialog(frame, "Account Doesnt exist!");
                  }
                  
                  
                  
              } catch (NumberFormatException e2) {
            	  JOptionPane.showMessageDialog(frame,"Invalid input for withdraw amount or account number");
              }
        	}
        });
        Withdraw_btn.setBounds(776, 300, 100, 46);
        Withdraw_btn.setVisible(false);
        
        Acc_2 = new JLabel("Enter the account to transfer to :");
        Acc_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        Acc_2.setBounds(329, 247, 259, 29);
        Acc_2.setVisible(false);
        
        Transfer_amount = new JLabel("Enter the amount :");
        Transfer_amount.setFont(new Font("Tahoma", Font.BOLD, 15));
        Transfer_amount.setBounds(403, 308, 173, 29);
        Transfer_amount.setVisible(false);
        
        Acc_2_text = new JTextField();
        Acc_2_text.setBounds(630, 252, 246, 24);
        Acc_2_text.setVisible(false);
        
        Transfer_btn = new JButton("Transfer");
        Transfer_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		    String fromAccountNumber = Acc_1_text.getText();
        		    String toAccountNumber = Acc_2_text.getText();
        		    String amountText = Transfer_text.getText();
        		    if(fromAccountNumber.trim().isEmpty() || toAccountNumber.trim().isEmpty() || amountText.trim().isEmpty()) {
        		        JOptionPane.showMessageDialog(frame,"Inputs cannot be empty");
        		        return;
        		    }
        		    int amount = Integer.parseInt(amountText);
        		    Account fromAccount = null, toAccount = null;
        		    Boolean f1 = false , f2 = false;
        		    for (Account account : globalAccounts) {
        		        if (Integer.toString(account.accountNumber).equals(fromAccountNumber)) {
        		            fromAccount = account;
        		            f1 = true;
        		        } else if (Integer.toString(account.accountNumber).equals(toAccountNumber)) {
        		            toAccount = account;
        		            f2 = true;
        		        }
        		    }
        		   
        		    if(!f1 || !f2) {
        		    	JOptionPane.showMessageDialog(frame, "Account Doesnt Exist!");
        		    }
        		    if (fromAccount != null && toAccount != null) {
        		    	if(fromAccount.getBalance() >= amount) {
        		    		Transaction.transfer(fromAccount, toAccount, amount);
        		    		mntmNewMenuItem.doClick();
        		    		JOptionPane.showMessageDialog(frame,"Sucessfully transfered!");
        		    		
        		    	}else {
        		    		JOptionPane.showMessageDialog(frame,"Insufficient Balance!");
        		    	}
        		    }
        		} catch (Exception e3) {
        		    JOptionPane.showMessageDialog(frame,"Invalid input for transfer amount or account number");
        		}
        	}
        });
        Transfer_btn.setBounds(776, 302, 111, 42);
        Transfer_btn.setVisible(false);
        
        scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBounds(10, 347, 591, 111);
        scrollPane.setVisible(false);
        
        
        Account_details = new JLabel("Account Details :");
        Account_details.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Account_details.setBounds(10, 302, 182, 35);
        Account_details.setVisible(false);
        contentPane.add(Account_details);
        contentPane.add(scrollPane);
        
        table = new JTable(new DefaultTableModel(new Object[]{"Fname", "Lname", "Account_No", "Balance"}, 0));
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setForeground(new Color(0, 0, 128));
//        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        scrollPane.setViewportView(table); 
        table.setVisible(false);
        contentPane.add(Transfer_btn);
        contentPane.add(Acc_2_text);
        Acc_2_text.setColumns(10);
        mntmNewMenuItem.doClick();
        
        Acc_1_text = new JTextField();
        Acc_1_text.setBounds(630, 200, 246, 29);
        Acc_1_text.setVisible(false);
        contentPane.add(Acc_1_text);
        Acc_1_text.setColumns(10);
        
        Transfer_text = new JTextField();
        Transfer_text.setBounds(632, 300, 96, 34);
        contentPane.add(Transfer_text);
        Transfer_text.setColumns(10);
        Transfer_text.setVisible(false);
        contentPane.add(Transfer_amount);
        contentPane.add(Acc_2);
        
        Acc_1 = new JLabel("Enter the account to transfer from :");
        Acc_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        Acc_1.setBounds(303, 198, 279, 29);
        Acc_1.setVisible(false);
        contentPane.add(Acc_1);
        contentPane.add(Withdraw_btn);
        contentPane.add(Deposit);
        
        deposit_amount_label = new JLabel("Enter the amount to deposit :");
        deposit_amount_label.setForeground(new Color(0, 0, 0));
        deposit_amount_label.setFont(new Font("Tahoma", Font.BOLD, 15));
        deposit_amount_label.setBounds(329, 247, 291, 29);
        deposit_amount_label.setVisible(false);
        contentPane.add(deposit_amount_label);
        
        deposit_amount = new JTextField();
        deposit_amount.setBounds(630, 249, 245, 29);
        contentPane.add(deposit_amount);
        deposit_amount.setVisible(false);
        deposit_amount.setColumns(10);
        
        Account_deposit = new JLabel("Enter the account to deposit in :");
        Account_deposit.setForeground(new Color(0, 0, 0));
        Account_deposit.setFont(new Font("Tahoma", Font.BOLD, 15));
        Account_deposit.setBounds(303, 198, 317, 29);
        Account_deposit.setVisible(false);
        contentPane.add(Account_deposit);
        
        textField = new JTextField();
        textField.setBounds(630, 202, 245, 29);
        contentPane.add(textField);
        textField.setVisible(false);
        textField.setColumns(10);
        
        Account_list = new JLabel("");
        Account_list.setFont(new Font("Tahoma", Font.BOLD, 15));
        Account_list.setBounds(10, 212, 309, 183);
        contentPane.add(Account_list);
        
        
        JLabel lblNewLabel_2 = new JLabel("Banking Application");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_2.setIcon(new ImageIcon("Logo.png"));
        lblNewLabel_2.setBounds(0, 0, 384, 103);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1 = new JLabel("WELCOME TO OUR BANKING APPLICATION,");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_1.setBounds(43, 97, 418, 75);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("BgImage.jpg"));
        lblNewLabel.setBounds(0, 0, 1261, 691);
        contentPane.add(lblNewLabel);
    }
}