package com.example.om.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.om.dao.CustomerDAO;
import com.example.om.dao.StaffDAO;
import com.example.om.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CustomerDAO customerDao = new CustomerDAO();
	private static StaffDAO staffDao = new StaffDAO();

	public LoginController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rs = req.getRequestDispatcher("login.jsp");
		rs.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		authenticateUser(request, response);
	}

	public void authenticateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		String isStaff = request.getParameter("isStaff");
		User user = null;

		if (isStaff != null && isStaff.equals("true")) {
			user = staffDao.validateStaff(username, password);

		} else {
			user = customerDao.validateCustomer(username, password);
		}
		if (user == null) {
			request.setAttribute("error", "Please enter correct credentials!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			String role = user.getRole();
			HttpSession session = request.getSession();
			session.setAttribute("customer_id", user.getId());
			session.setAttribute("role", role);
			request.removeAttribute("error");
			RequestDispatcher rd = null;
			if (role.equals("manager")) {
				rd = request.getRequestDispatcher("manage.jsp");
			} else if (role.equals("admin")) {
				rd = request.getRequestDispatcher("admin.jsp");
			} else {
				rd = request.getRequestDispatcher("products");
			}
			rd.forward(request, response);
		}

	}

}
