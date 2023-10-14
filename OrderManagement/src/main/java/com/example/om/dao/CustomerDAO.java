package com.example.om.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.om.model.Customer;
import com.example.om.util.ConnectionUtil;

public class CustomerDAO {

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from customer";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("c_id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setDob(rs.getString("dob"));
				customer.setCreatedTimestamp(rs.getString("created_timestamp"));
				customer.setMail(rs.getString("mail"));
				customer.setPhone(rs.getString("phone"));
				customer.setWalletBalance(rs.getDouble("walletbalance"));
				customer.setAddress(rs.getString("address"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public Customer validateCustomer(String email, String password) {
		String sql = "select * from customer where mail=? and password=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);) {
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("c_id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void createCustomer(Customer customer) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into customer(firstName, mail, password) values(?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getMail());
			stmt.setString(3, customer.getPassword());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
