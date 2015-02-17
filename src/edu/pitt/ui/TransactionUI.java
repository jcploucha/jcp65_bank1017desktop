package edu.pitt.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.pitt.utilities.DbUtilities;
import edu.pitt.utilities.MySqlUtilities;

public class TransactionUI {

	private JFrame frmBankAccountTransactions;
	private JScrollPane transactionPane;
	private JTable tblTransactions; 

	/**
	 * Create the application.
	 */
	
	//TODO: ADD ACCOUNT TO CONSTRUCTOR
	public TransactionUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankAccountTransactions = new JFrame();
		frmBankAccountTransactions.setTitle("Bank1017 Account Transactions");
		frmBankAccountTransactions.setBounds(100, 100, 450, 300);
		frmBankAccountTransactions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		transactionPane = new JScrollPane();
		frmBankAccountTransactions.getContentPane().add(transactionPane);
		DbUtilities db = new MySqlUtilities();
		//WONT NEED QUERY, CAN LOOP THRU ARRAYLIST FROM ACCT CLASS
		String[] cols = {"Transaction ID", "Acount Number", "Amount"};
		String sql = "SELECT transactionID, accountID, amount  FROM jcp65_bank1017.transaction;";
		try {
			DefaultTableModel transactionList = db.getDataTable(sql, cols);
			tblTransactions = new JTable(transactionList );
			tblTransactions.setFillsViewportHeight(true);
			tblTransactions.setShowGrid(true);
			tblTransactions.setGridColor(Color.black);
			transactionPane.getViewport().add(tblTransactions);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
