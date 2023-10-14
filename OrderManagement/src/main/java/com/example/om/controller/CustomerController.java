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
import com.example.om.model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/customers")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO customerDao = new CustomerDAO();

	public CustomerController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		createCustomer(request, response);
	}

	protected void createCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setFirstName(request.getParameter("firstName"));
		customer.setMail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));

		customerDao.createCustomer(customer);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Customer Created</b>");
		out.print("<br><a href='/OrderManagement'>Home</a>");
	}

	public void displayCustomers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Customer> customer = customerDao.getAllCustomers();

		request.setAttribute("itemType", "Customer");
		request.setAttribute("items", customer);
		request.getRequestDispatcher("display.jsp").forward(request, response);

	}

}
