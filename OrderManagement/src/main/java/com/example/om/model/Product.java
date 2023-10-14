package com.example.om.model;

import java.util.HashMap;
import java.util.Map;

public class Product {
	private int id;
	private String name;
	private int categoryId;
	private double price;
	private String description;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", price=" + price
				+ ", description=" + description + ", quantity=" + quantity + "]";
	}

	public Map<String, String> getDetails() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", Integer.toString(id));
		map.put("name", name);
		map.put("categoryId", Integer.toString(categoryId));
		map.put("price", Double.toString(price));
		map.put("description", description);
		map.put("quantity", Integer.toString(quantity));
		return map;
	} 
}
