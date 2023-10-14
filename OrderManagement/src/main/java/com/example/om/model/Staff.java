package com.example.om.model;

import java.util.HashMap;
import java.util.Map;

public class Staff extends User {

	private String mail;
	private String password;
	private String phone;

	public int getId() {
		return super.getId();
	}

	public void setId(int id) {
		super.setId(id);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return super.getRole();
	}

	public void setRole(String role) {
		super.setRole(role);
	}

	@Override
	public String toString() {
		return "Staff [id=" + super.getId() + ", firstName=" + super.getFirstName() + ", lastName="
				+ super.getLastName() + ", mail=" + mail + ", phone=" + phone + ", role=" + super.getRole() + "]";
	}

	public Map<String, String> getDetails() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", Integer.toString(super.getId()));
		map.put("firstName", super.getFirstName());
		map.put("lastName", super.getLastName());
		map.put("mail", mail);
		map.put("phone", phone);
		return map;
	}
}
