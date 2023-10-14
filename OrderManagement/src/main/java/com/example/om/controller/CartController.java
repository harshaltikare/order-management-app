package com.example.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.om.dao.ProductDAO;
import com.example.om.model.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO productDao = new ProductDAO();

	public CartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		viewCart(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		addToCart(request, response);
	}

	protected void viewCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<Product, Integer> cartContents = (Map<Product, Integer>) session.getAttribute("cartContents");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (cartContents != null) {
			out.print("<b>Products in Cart!</b><br/><br/>");
			int count = 1;
			for (Map.Entry<Product, Integer> entry : cartContents.entrySet()) {
				out.print("Item No. " + count++ + "<br/>");
				out.print(entry.getKey() + "<br/>");
				out.print("Quantity : " + entry.getValue() + "<br/><br/>");
			}
			out.print("<form action='orders' method='post'><input type='submit' value='Check Out' /></form>");
		} else {
			out.print("<b>Nothing in Cart! Please add some products.<b/>");
		}
		out.print("<br><a href='products'>Home</a>");
	}

	protected void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<Product, Integer> cartContents = (Map<Product, Integer>) session.getAttribute("cartContents");
		if (cartContents == null) {
			cartContents = new HashMap<Product, Integer>();
		}
		Product product = productDao.getProductById(Integer.parseInt(request.getParameter("productId")));
		cartContents.put(product, Integer.parseInt(request.getParameter("qty")));

		session.setAttribute("cartContents", cartContents);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Added to Cart!</b>");
		out.print("<br><a href='cart'>View Cart</a>");
		out.print("<br><a href='/OrderManagement'>Home</a>");
	}

}
