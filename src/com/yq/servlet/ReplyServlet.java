package com.yq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.entity.Member;
import com.yq.entity.Reply;
import com.yq.service.MemberImpl;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReplyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String replycontent = request.getParameter("content");
		Integer boardid = Integer.parseInt((String)session.getAttribute("bid"));
		Integer topicid = Integer.parseInt((String)session.getAttribute("tid"));
		int memberid = ((Member)session.getAttribute("user")).getMemberid();
		MemberImpl mi = new MemberImpl();
		int i = mi.insertReply(new Reply(boardid,topicid,memberid,replycontent));
		if(i>0) {
			response.sendRedirect("DetailServlet?bid="+boardid+"&tid="+topicid);
		}
	}
}
