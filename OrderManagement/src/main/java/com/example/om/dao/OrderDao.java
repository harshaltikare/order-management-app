package com.example.om.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.om.model.Order;
import com.example.om.util.ConnectionUtil;

public class OrderDao {
	public void createOrder(Order order) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into `order`(description, c_id, order_date, delivery_date, status) values(?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, order.getDescription());
			stmt.setInt(2, order.getCustomerId());
			stmt.setString(3, order.getOrderDate());
			stmt.setString(4, order.getDeliveryDate());
			stmt.setString(5, "active");
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteOrder(Order order) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "delete from `order` where o_id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, order.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateStatus(Order order, String status) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "update table `order` set status=? where o_id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, order.getStatus());
			stmt.setInt(2, order.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from `order`";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("o_id"));
				order.setDescription(rs.getString("description"));
				order.setCustomerId(rs.getInt("c_id"));
				order.setOrderDate(rs.getString("order_date"));
				order.setDeliveryDate(rs.getString("delivery_date"));
				order.setStatus(rs.getString("status"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
