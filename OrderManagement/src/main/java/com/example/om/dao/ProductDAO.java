package com.example.om.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.om.model.Product;
import com.example.om.util.ConnectionUtil;

public class ProductDAO {

	public void createProduct(Product product) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into product(name, cat_id, price, description, quantity) values(?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, product.getName());
			stmt.setInt(2, product.getCategoryId());
			stmt.setDouble(3, product.getPrice());
			stmt.setString(4, product.getDescription());
			stmt.setInt(5, product.getQuantity());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(Product product) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "delete from product where p_id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, product.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAllProducts() {
		return getProductsByCategory("");
	}

	public List<Product> getProductsByCategory(String categoryId) {
		List<Product> products = new ArrayList<Product>();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from product";
		if (!categoryId.isEmpty()) {
			sql = sql + " where cat_id=?";
		}
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			if (!categoryId.isEmpty())
				stmt.setString(1, categoryId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("p_id"));
				product.setName(rs.getString("name"));
				product.setCategoryId(rs.getInt("cat_id"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setQuantity(rs.getInt("quantity"));
				products.add(product);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public Product getProductById(int id) {
		Product product = new Product();
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from product where p_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				product.setId(rs.getInt("p_id"));
				product.setName(rs.getString("name"));
				product.setCategoryId(rs.getInt("cat_id"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setQuantity(rs.getInt("quantity"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

}
