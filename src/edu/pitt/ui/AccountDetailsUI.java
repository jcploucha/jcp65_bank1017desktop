package edu.pitt.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
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

public class AccountDetailsUI {

	private JFrame frmBankAccountDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountDetailsUI window = new AccountDetailsUI();
					window.frmBankAccountDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountDetailsUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankAccountDetails = new JFrame();
		frmBankAccountDetails.setTitle("Bank1017 Account Details");
		frmBankAccountDetails.setBounds(100, 100, 450, 400);
		frmBankAccountDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		SpringLayout springLayout_1 = new SpringLayout();
		frmBankAccountDetails.getContentPane().setLayout(springLayout_1);
		
		
		JButton btnExitbutton = new JButton("Exit");
		springLayout_1.putConstraint(SpringLayout.SOUTH, btnExitbutton, -34, SpringLayout.SOUTH, frmBankAccountDetails.getContentPane());
		springLayout_1.putConstraint(SpringLayout.EAST, btnExitbutton, -46, SpringLayout.EAST, frmBankAccountDetails.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnExitbutton, 198, SpringLayout.NORTH, frmBankAccountDetails.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnExitbutton, 301, SpringLayout.WEST, frmBankAccountDetails.getContentPane());
		btnExitbutton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnExitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		frmBankAccountDetails.getContentPane().add(btnExitbutton);
		
	}

}
