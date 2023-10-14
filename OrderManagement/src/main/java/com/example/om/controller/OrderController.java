package com.example.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.om.dao.OrderDao;
import com.example.om.model.Order;
import com.example.om.model.Product;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/orders")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDao orderDao = new OrderDao();

	public OrderController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getAllOrders(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		createOrder(request, response);
	}

	protected void getAllOrders(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Order> orders = orderDao.getAllOrders();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Products Available:</b><br/>");
		for (Order order : orders) {
			out.print(order + "<br/>");
		}
		out.print("<br><a href='/OrderManagement'>Home</a>");
	}

	protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<Product, Integer> cartContents = (Map<Product, Integer>) session.getAttribute("cartContents");
		int customerId = (int) session.getAttribute("customer_id");
		Map<String, String> descMap = new HashMap<String, String>();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		double amount = 0;
		if (cartContents != null && customerId>0) {
			for (Map.Entry<Product, Integer> entry : cartContents.entrySet()) {
				Product product = entry.getKey();
				int qtyOrdered = entry.getValue();
				descMap.put("id : " + product.getId(), "qty : " + qtyOrdered);
				amount += (product.getPrice() * qtyOrdered);
			}
			
			Order order = new Order();
			order.setDescription(descMap.toString());
			order.setCustomerId(customerId);
			order.setAmount(amount);
			orderDao.createOrder(order);

			out.print("<b>Order Created</b>");
		}

		out.print("<br><a href='products'>Product Dashboard</a>");
	}
}
