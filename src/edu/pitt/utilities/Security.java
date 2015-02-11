package edu.pitt.utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.pitt.bank.Customer;

public class Security {

	private String userID;

	public Customer validateLogin(String loginName, int pin){
		String sql = "SELECT * FROM jcp65_bank1017.customer WHERE ";
		sql += "loginName = '" + loginName + "'"; 
		sql += "AND pin = '" + pin + "';";
		DbUtilities db = new DbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			if (rs.next()) {
				Customer c = new Customer(rs.getString("customerID"));
				return c;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> listUserGroups(String userID) {

	}

}