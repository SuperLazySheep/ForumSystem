package com.yq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.entity.Member;
import com.yq.entity.Topic;
import com.yq.service.MemberImpl;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
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
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		Integer bid = Integer.parseInt(request.getParameter("bid"));
		MemberImpl mi = new MemberImpl();
		String tluser=((Member)session.getAttribute("user")).getMembername();
		List<Member> list = mi.getMember(tluser);
		int memberid=list.get(0).getMemberid();
		
		//Ìí¼ÓÌû×Ó
		int i=mi.insertTopic(new Topic(title,content,bid,memberid,tluser));
		if(i>0) {
			response.sendRedirect("ListServlet");
		}
		session.setAttribute("bid", bid);
		doGet(request, response);
	}

}
