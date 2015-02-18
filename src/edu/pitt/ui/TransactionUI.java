package edu.pitt.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.pitt.bank.Account;
import edu.pitt.bank.Transaction;
import edu.pitt.utilities.DbUtilities;
import edu.pitt.utilities.MySqlUtilities;

public class TransactionUI {

	private JFrame frmBankAccountTransactions;
	private JScrollPane transactionPane;
	private JTable tblTransactions; 
	private Account acct;

	/**
	 * Create the application.
	 */
	
	public TransactionUI(Account a) {
		acct = a;
		initialize();
		frmBankAccountTransactions.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankAccountTransactions = new JFrame();
		frmBankAccountTransactions.setTitle("Bank1017 Account Transactions");
		frmBankAccountTransactions.setBounds(100, 100, 450, 300);
		frmBankAccountTransactions.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		transactionPane = new JScrollPane();
		frmBankAccountTransactions.getContentPane().add(transactionPane);

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		for (int i = 0; i < acct.getTransactionList().size(); i++) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(acct.getTransactionList().get(i).getTransactionDate());
			vector.add(acct.getTransactionList().get(i).getTransactionID());
			// vector.add(acct.getTransactionList().get(i).getAccountID());
			vector.add(acct.getTransactionList().get(i).getAmount());
			vector.add(acct.getTransactionList().get(i).getType());
			vector.add(acct.getTransactionList().get(i).getBalance());
			data.add(vector);
		}


		Vector<String> cols = new Vector<String>();
		cols.add("Transaction Date");
		cols.add("Transaction ID");
		cols.add("Amount");
		cols.add("Type");
		cols.add("Balance");
		
		DefaultTableModel transactionList = new DefaultTableModel(data, cols);
		tblTransactions = new JTable(transactionList);
		tblTransactions.setFillsViewportHeight(true);
		tblTransactions.setShowGrid(true);
		tblTransactions.setGridColor(Color.black);
		transactionPane.getViewport().add(tblTransactions);
	}

}
