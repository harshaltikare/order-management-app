package com.example.om.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.om.model.Staff;
import com.example.om.util.ConnectionUtil;

public class StaffDAO {

	public void createStaff(Staff staff) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into staff(first_name,last_name,phone,mail,password,role) values(?, ?, ?, ?, ?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, staff.getFirstName());
			stmt.setString(2, staff.getLastName());
			stmt.setString(3, staff.getPhone());
			stmt.setString(4, staff.getMail());
			stmt.setString(5, staff.getPassword());
			stmt.setString(6, staff.getRole());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStaff(Staff staff) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "delete from staff where staff_id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, staff.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Staff validateStaff(String email, String password) {
		String sql = "select * from staff where mail=? and password=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);) {
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Staff staff = new Staff();
				staff.setId(rs.getInt("staff_id"));
				staff.setFirstName(rs.getString("first_name"));
				staff.setLastName(rs.getString("last_name"));
				staff.setRole(rs.getString("role"));
				return staff;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Staff> getAllStaff() {
		List<Staff> staffs = new ArrayList<Staff>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from staff";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setId(rs.getInt("staff_id"));
				staff.setFirstName(rs.getString("first_name"));
				staff.setLastName(rs.getString("last_name"));
				staff.setMail(rs.getString("mail"));
				staff.setPhone(rs.getString("phone"));
				staff.setRole(rs.getString("role"));
				staffs.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staffs;
	}

}
