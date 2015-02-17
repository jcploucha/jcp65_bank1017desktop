package edu.pitt.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import edu.pitt.bank.Account;
import edu.pitt.utilities.DbUtilities;
import edu.pitt.utilities.MySqlUtilities;

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

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccountDetailsUI window = new AccountDetailsUI();
//					window.frmBankAccountDetails.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AccountDetailsUI() {
		initialize();
		frmBankAccountDetails.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankAccountDetails = new JFrame();
		frmBankAccountDetails.setTitle("Bank1017 Account Details");
		frmBankAccountDetails.setBounds(100, 100, 450, 401);
		frmBankAccountDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmBankAccountDetails.getContentPane().setLayout(null);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(189, 182, 99, 40);
		btnDeposit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frmBankAccountDetails.getContentPane().add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(294, 182, 111, 40);
		btnWithdraw.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frmBankAccountDetails.getContentPane().add(btnWithdraw);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(109, 136, 296, 40);
		frmBankAccountDetails.getContentPane().add(txtAmount);
		txtAmount.setColumns(10);
		
		JComboBox boxAccount = new JComboBox();
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
		
		JLabel lblWelcome = new JLabel("DICKBUTT");
		lblWelcome.setBounds(159, 10, 279, 16);
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		frmBankAccountDetails.getContentPane().add(lblWelcome);
		
		JLabel lblPermissionsText = new JLabel("You have the following permissions in this system:");
		lblPermissionsText.setBounds(10, 32, 322, 16);
		frmBankAccountDetails.getContentPane().add(lblPermissionsText);
		
		JLabel lblPermissions = new JLabel("POOP, POOPBUTT, POOPYBUTT");
		lblPermissions.setBounds(20, 54, 408, 16);
		lblPermissions.setFont(new Font("Lucida Grande", Font.BOLD, 13));
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
		
		JLabel lblAcctType = new JLabel("CHECKING");
		lblAcctType.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblAcctType.setBounds(138, 255, 83, 16);
		frmBankAccountDetails.getContentPane().add(lblAcctType);
		
		JLabel lblBalance = new JLabel("$1,000,000,000.00");
		lblBalance.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblBalance.setBounds(98, 289, 134, 16);
		frmBankAccountDetails.getContentPane().add(lblBalance);
		
		JLabel lblPenalty = new JLabel("DOLLA BILLZ");
		lblPenalty.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPenalty.setBounds(294, 289, 111, 16);
		frmBankAccountDetails.getContentPane().add(lblPenalty);
		
		JLabel lblInterestRate = new JLabel("99.99%");
		lblInterestRate.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblInterestRate.setBounds(330, 255, 75, 16);
		frmBankAccountDetails.getContentPane().add(lblInterestRate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnExit.setBounds(340, 333, 100, 40);
		frmBankAccountDetails.getContentPane().add(btnExit);
		
		JButton btnShowTranctions = new JButton("Show Transactions");
		btnShowTranctions.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnShowTranctions.setBounds(10, 333, 179, 40);
		frmBankAccountDetails.getContentPane().add(btnShowTranctions);
		
		DbUtilities db = new MySqlUtilities(); 
		String sql = "SELECT * FROM jcp65_bank1017.account;";
		try {
			ResultSet rs = db.getResultSet(sql);
			while (rs.next()) {
				Account acct = new Account(rs.getString("accountID"));
				boxAccount.addItem(acct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
