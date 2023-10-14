package com.example.om.model;

import java.util.HashMap;
import java.util.Map;

public class Customer extends User {
	private String dob;
	private String createdTimestamp;
	private String mail;
	private String phone;
	private double walletBalance;
	private String address;
	private String password;
	private String role = "customer";
	
	public Customer() {
		super();
		super.setRole(role);
	}

	public int getId() {
		return super.getId();
	}

	public void setId(int id) {
		super.setId(id);
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getFirstName() {
		return super.getFirstName();
	}

	public void setFirstName(String firstName) {
		super.setFirstName(firstName);
	}

	public String getLastName() {
		return super.getLastName();
	}

	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return this.role;
	}

	@Override
	public String toString() {
		return "Customer [id=" + super.getId() + ", dob=" + dob + ", createdTimestamp=" + createdTimestamp + ", firstName="
				+ super.getFirstName() + ", lastName=" + super.getLastName() + ", mail=" + mail + ", phone=" + phone + ", walletBalance="
				+ walletBalance + ", address=" + address + "]";
	}
	
	public Map<String, String> getDetails() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", Integer.toString(super.getId()));
		map.put("firstName", super.getFirstName());
		map.put("lastName", super.getLastName());
		map.put("mail",mail);
		map.put("phone", phone);
		return map;
	} 
	
}
