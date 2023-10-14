package com.example.om.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String servletPath = request.getServletPath();

		List<String> exclude = new ArrayList<String>();
		exclude.add("/login");
		exclude.add("/index.html");
		exclude.add("/products");
		exclude.add("/productDetails.jsp");
		exclude.add("/createUser.jsp");
		exclude.add("/display.jsp");
		if (!exclude.contains(servletPath)) {
			HttpSession session = request.getSession();
			if (session.getAttribute("customer_id") != null) {
				chain.doFilter(req, resp);
			} else {

				request.setAttribute("error", "Please login first to proceed further.");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
		} else {
			chain.doFilter(req, resp);
		}
	}

}
