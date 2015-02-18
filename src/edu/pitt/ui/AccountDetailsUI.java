package edu.pitt.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import edu.pitt.bank.Account;
import edu.pitt.bank.Customer;
import edu.pitt.bank.Transaction;
import edu.pitt.utilities.DbUtilities;
import edu.pitt.utilities.MySqlUtilities;
import edu.pitt.utilities.Security;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;

import java.awt.FlowLayout;

import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;

import java.awt.Window.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class AccountDetailsUI {

	private JFrame frmBankAccountDetails;
	private JTextField txtAmount;
	private Customer accountOwner;
	private Account acct;
	private JLabel lblBalance;
	private JLabel lblAcctType;
	private JLabel lblPenalty;
	private JLabel lblInterestRate;
	private Account a;
	private String strBalance;
	private String strInterest;
	private String strAcctType;
	private String strPenalty;
	private String permissions = "";
	private String strAccountID;


	/**
	 * Create the application.
	 */
	public AccountDetailsUI(Customer c) {
		accountOwner = c;
		initialize();
		frmBankAccountDetails.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		for(int i = 0; i <= accountOwner.getGroups().size() - 1; i ++) {
			permissions += accountOwner.getGroups().get(i) + ", ";
		}
		permissions = permissions.substring(0, permissions.length()-2);
		
		
		frmBankAccountDetails = new JFrame();
		frmBankAccountDetails.setTitle("Bank1017 Account Details");
		frmBankAccountDetails.setBounds(100, 100, 450, 401);
		frmBankAccountDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmBankAccountDetails.getContentPane().setLayout(null);
				
		txtAmount = new JTextField();
		txtAmount.setBounds(109, 136, 296, 40);
		frmBankAccountDetails.getContentPane().add(txtAmount);
		txtAmount.setColumns(10);
		
		JComboBox<Account> boxAccount = new JComboBox<Account>();
		boxAccount.setBounds(106, 103, 296, 27);
		frmBankAccountDetails.getContentPane().add(boxAccount);
		
		JLabel lblAccount = new JLabel("Account:");
		lblAccount.setBounds(44, 107, 56, 16);
		frmBankAccountDetails.getContentPane().add(lblAccount);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(44, 149, 54, 16);
		frmBankAccountDetails.getContentPane().add(lblAmount);
		
		JLabel lblWelcomeText = new JLabel("Welcome to Bank1017,");
		lblWelcomeText.setBounds(10, 10, 143, 16);
		frmBankAccountDetails.getContentPane().add(lblWelcomeText);
		
		JLabel lblWelcome = new JLabel(accountOwner.getFirstName() + " " + accountOwner.getLastName());
		lblWelcome.setBounds(159, 10, 279, 16);
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		frmBankAccountDetails.getContentPane().add(lblWelcome);
		
		JLabel lblPermissionsText = new JLabel("You have the following permissions in this system:");
		lblPermissionsText.setBounds(10, 32, 322, 16);
		frmBankAccountDetails.getContentPane().add(lblPermissionsText);
		
		JLabel lblPermissions = new JLabel(permissions);
		lblPermissions.setBounds(20, 54, 408, 16);
		lblPermissions.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblPermissions.setHorizontalAlignment(SwingConstants.CENTER);
		frmBankAccountDetails.getContentPane().add(lblPermissions);
		
		JLabel lblAcctTypeText = new JLabel("Account Type:");
		lblAcctTypeText.setBounds(44, 255, 90, 16);
		frmBankAccountDetails.getContentPane().add(lblAcctTypeText);
		
		JLabel lblInterestRateText = new JLabel("Interest Rate:");
		lblInterestRateText.setBounds(244, 255, 83, 16);
		frmBankAccountDetails.getContentPane().add(lblInterestRateText);
		
		JLabel lblBalanceText = new JLabel("Balance:");
		lblBalanceText.setBounds(44, 289, 54, 16);
		frmBankAccountDetails.getContentPane().add(lblBalanceText);
		
		JLabel lblPenaltyText = new JLabel("Penalty:");
		lblPenaltyText.setBounds(244, 289, 54, 16);
		frmBankAccountDetails.getContentPane().add(lblPenaltyText);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnExit.setBounds(340, 333, 100, 40);
		frmBankAccountDetails.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
				
		
		DbUtilities db = new MySqlUtilities(); 
		String sql = "SELECT * FROM jcp65_bank1017.account JOIN "; 
		sql += "jcp65_bank1017.customer_account ON jcp65_bank1017.account.accountID = ";
		sql += "jcp65_bank1017.customer_account.fk_accountID JOIN ";
		sql += "jcp65_bank1017.customer ON ";
		sql += "jcp65_bank1017.customer_account.fk_customerID = jcp65_bank1017.customer.customerID ";
		sql += "WHERE jcp65_bank1017.customer.customerID = '" + accountOwner.getCustomerID() + "';";
		try {
			ResultSet rs = db.getResultSet(sql);
			while (rs.next()) {
				Account acct = new Account(rs.getString("accountID"));
				boxAccount.addItem(acct);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		a = (Account) boxAccount.getSelectedItem();
		strBalance = Double.toString(a.getBalance());
		strInterest = Double.toString(a.getInterestRate());
		strAcctType = a.getAccountType();
		strPenalty = Double.toString(a.getPenalty());
		strAccountID = a.getAccountID();
		double bal = a.getBalance();

		
		lblBalance = new JLabel(strBalance);
		lblBalance.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblBalance.setBounds(98, 289, 134, 16);
		frmBankAccountDetails.getContentPane().add(lblBalance);
		
		lblAcctType = new JLabel(strAcctType);
		lblAcctType.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblAcctType.setBounds(138, 255, 83, 16);
		frmBankAccountDetails.getContentPane().add(lblAcctType);
		
		lblPenalty = new JLabel(strPenalty);
		lblPenalty.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblPenalty.setBounds(294, 289, 111, 16);
		frmBankAccountDetails.getContentPane().add(lblPenalty);
		
		lblInterestRate = new JLabel(strInterest);
		lblInterestRate.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblInterestRate.setBounds(330, 255, 75, 16);
		frmBankAccountDetails.getContentPane().add(lblInterestRate);

		boxAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = (Account) boxAccount.getSelectedItem();
				strBalance = Double.toString(a.getBalance());
				strInterest = Double.toString(a.getInterestRate());
				strAcctType = a.getAccountType();
				strPenalty = Double.toString(a.getPenalty());
				strAccountID = a.getAccountID();
				
				lblBalance.setText(strBalance);
				lblInterestRate.setText(strInterest);
				lblAcctType.setText(strAcctType);
				lblPenalty.setText(strPenalty);

			}
		});

		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(189, 182, 99, 40);
		btnDeposit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frmBankAccountDetails.getContentPane().add(btnDeposit);
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double amt = Double.parseDouble(txtAmount.getText());	
				Transaction t = new Transaction(strAccountID, "deposit", amt, bal + amt);
				strBalance = Double.toString(bal + amt);
				lblBalance.setText(strBalance);
			}
		});
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(294, 182, 111, 40);
		btnWithdraw.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frmBankAccountDetails.getContentPane().add(btnWithdraw);
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double amt = Double.parseDouble(txtAmount.getText());	
				Transaction t = new Transaction(strAccountID, "withdrawal", amt, bal - amt);
				strBalance = Double.toString(bal - amt);
				lblBalance.setText(strBalance);
			}
		});

		JButton btnShowTransactions = new JButton("Show Transactions");
		btnShowTransactions.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnShowTransactions.setBounds(10, 333, 179, 40);
		frmBankAccountDetails.getContentPane().add(btnShowTransactions);
		btnShowTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionUI t = new TransactionUI(a);
			}
		});
	}
}
