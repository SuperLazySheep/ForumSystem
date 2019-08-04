package com.yq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.entity.Member;
import com.yq.service.MemberImpl;

/**
 * Servlet implementation class LoginRegServlet
 */
@WebServlet("/LoginRegServlet")
public class LoginRegServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String str = request.getParameter("uhidden");
			MemberImpl mi = new MemberImpl();
			//PrintWriter out = response.getWriter();
			if(str.equals("1")) {
				String uName = request.getParameter("uName");
				String uPass = request.getParameter("uPass");
				String city = request.getParameter("city");
				String gender = request.getParameter("gender");
				String head = request.getParameter("head");
				String province = request.getParameter("province");
				//实现增加用户功能
				if(mi.insertMember(new Member(uName,uPass,head,city,gender,province))>0) {
					response.sendRedirect("login.jsp");
				}
			}else {
					HttpSession session = request.getSession();
					String uName = request.getParameter("uName");
					String uPass = request.getParameter("uPass");
					List<Member> list = mi.searchMember(uName, uPass);
					if(list.size()>0) {
						session.setAttribute("user", list.get(0));
						response.sendRedirect("IndexServlet");
					}else {
						request.getRequestDispatcher("login.jsp").forward(request, response);;
					}
			}
		}catch(Exception e) {
		
		}
	}
}
