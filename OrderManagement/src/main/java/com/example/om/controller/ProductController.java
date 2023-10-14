package com.example.om.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.om.dao.ProductDAO;
import com.example.om.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO dao = new ProductDAO();

	public ProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		displayProducts(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action!=null) {
			if (action.equals("create")) {
				createProduct(request, response);
			} else if (action.equals("delete")) {
				deleteProduct(request, response);
			}
		} else {
			doGet(request, response);
		}
	}

	public void createProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int categoryId = Integer.parseInt(request.getParameter("cat_id"));
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		Product product = new Product();
		product.setName(name);
		product.setCategoryId(categoryId);
		product.setPrice(price);
		product.setDescription(description);
		product.setQuantity(quantity);

		dao.createProduct(product);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Product Created</b>");
		out.print("<br><a href='/OrderManagement'>Home</a>");
	}

	public void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Product product = new Product();
		product.setId(id);

		dao.deleteProduct(product);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Product Deleted</b>");
		out.print("<br><a href='/OrderManagement'>Home</a>");
	}

	public void displayProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> products = dao.getAllProducts();
		
		request.setAttribute("itemType", "Product");
		request.setAttribute("items", products);
		request.getRequestDispatcher("display.jsp").forward(request, response);;

	}
}
