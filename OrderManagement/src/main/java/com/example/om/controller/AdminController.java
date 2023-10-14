
package com.example.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.om.dao.CustomerDAO;
import com.example.om.dao.StaffDAO;
import com.example.om.model.Customer;
import com.example.om.model.Staff;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerDAO customerDao = new CustomerDAO();
	private static StaffDAO staffDao = new StaffDAO();
	private static CustomerController cc = new CustomerController();
	public AdminController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		try {
			if (type.equals("customer")) {
				cc.displayCustomers(request, response);
				//getCustomers(request, response);
			} else if (type.equals("staff")) {
				displayStaff(request, response);
				//getStaff(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("add")) {
			addStaff(request, response);
		} else if (action.equals("delete")) {
			deleteStaff(request, response);
		}
	}

	public static void getCustomers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Customer> customers = customerDao.getAllCustomers();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>List of Customers : </b><br/>");
		for (Customer customer : customers) {
			out.print(customer + "<br/>");
		}
		out.print("<br><a href='/OrderManagement'>Home</a>");
	}

	public static void getStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Staff> staffs = staffDao.getAllStaff();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Staff Available : </b><br/>");
		for (Staff staff : staffs) {
			out.print(staff + "<br/>");
		}
		out.print("<br><a href='/OrderManagement'>Home</a>");
	}

	public static void addStaff(HttpServletRequest request, HttpServletResponse response) {
		Staff staff = new Staff();
		staff.setFirstName(request.getParameter("first_name"));
		staff.setLastName(request.getParameter("last_name"));
		staff.setPhone(request.getParameter("phone_number"));
		staff.setMail(request.getParameter("email"));
		staff.setPassword(request.getParameter("password"));
		staff.setRole(request.getParameter("role"));

		staffDao.createStaff(staff);

		response.setContentType("text/html");
		try {
			PrintWriter out = response.getWriter();
			out.print("<b>Staff Added</b>");
			out.print("<br><a href='/OrderManagement'>Home</a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Staff staff = new Staff();
		staff.setId(id);
		staffDao.deleteStaff(staff);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Staff Deleted</b>");
		out.print("<br><a href='/OrderManagement'>Home</a>");
	}
	
	public void displayStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Staff> staff = staffDao.getAllStaff();
		
		request.setAttribute("itemType", "Staff");
		request.setAttribute("items", staff);
		request.getRequestDispatcher("display.jsp").forward(request, response);
		
	}

}
