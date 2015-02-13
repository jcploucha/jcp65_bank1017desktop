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

public class LoginUI {

	private JFrame frmBankLogin;
	private JTextField txtLoginName;
	private JPasswordField txtPassword;
	private JLabel lblLoginName;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frmBankLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankLogin = new JFrame();
		frmBankLogin.setTitle("Bank 1017 Login");
		frmBankLogin.setResizable(false);
		frmBankLogin.setBounds(100, 100, 450, 300);
		frmBankLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmBankLogin.getContentPane().setLayout(springLayout);
		
		txtLoginName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtLoginName, 40, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtLoginName, 164, SpringLayout.WEST, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtLoginName, 90, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtLoginName, 400, SpringLayout.WEST, frmBankLogin.getContentPane());
		txtLoginName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frmBankLogin.getContentPane().add(txtLoginName);
		txtLoginName.setColumns(10);
		
		JButton btnExitbutton = new JButton("Exit");
		springLayout.putConstraint(SpringLayout.NORTH, btnExitbutton, 198, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnExitbutton, 301, SpringLayout.WEST, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnExitbutton, 238, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnExitbutton, 401, SpringLayout.WEST, frmBankLogin.getContentPane());
		btnExitbutton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnExitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		txtPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPassword, 115, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtPassword, 163, SpringLayout.WEST, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtPassword, 165, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtPassword, 400, SpringLayout.WEST, frmBankLogin.getContentPane());
		txtPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		frmBankLogin.getContentPane().add(txtPassword);
		
		JButton btnLoginbutton = new JButton("Login");
		springLayout.putConstraint(SpringLayout.NORTH, btnLoginbutton, 198, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnLoginbutton, 195, SpringLayout.WEST, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnLoginbutton, 238, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLoginbutton, 295, SpringLayout.WEST, frmBankLogin.getContentPane());
		btnLoginbutton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnLoginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmBankLogin.getContentPane().add(btnLoginbutton);
		frmBankLogin.getContentPane().add(btnExitbutton);
		
		lblLoginName = new JLabel("Login Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblLoginName, 55, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblLoginName, 40, SpringLayout.WEST, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblLoginName, 140, SpringLayout.WEST, frmBankLogin.getContentPane());
		lblLoginName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frmBankLogin.getContentPane().add(lblLoginName);
		
		lblPassword = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 130, SpringLayout.NORTH, frmBankLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 40, SpringLayout.WEST, frmBankLogin.getContentPane());
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frmBankLogin.getContentPane().add(lblPassword);
	}
}
