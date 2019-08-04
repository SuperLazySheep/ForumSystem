package com.yq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.entity.Member;

/**
 * Servlet Filter implementation class Loginfiter
 */
//@WebFilter(urlPatterns = { "/index.jsp" }, servletNames = { "LoginRegServlet" })
public class Loginfiter extends HttpServlet implements Filter {

    /**
     * Default constructor. 
     */
    public Loginfiter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response= (HttpServletResponse)res;
		HttpSession session = request.getSession();
		Member user=(Member)session.getAttribute("user");
		if(user != null) {
			chain.doFilter(req, res);
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
