package com.yq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.entity.ReplyMem;
import com.yq.entity.Topic;
import com.yq.service.MemberImpl;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailServlet() {
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
		String bid = request.getParameter("bid");
		String tid = request.getParameter("tid");
		HttpSession session = request.getSession();
		session.setAttribute("bid", bid);
		session.setAttribute("tid", tid);
		MemberImpl mi = new MemberImpl();
		List<Topic> topic = mi.getTopic(tid);
		session.setAttribute("topic", topic.get(0));
		List<ReplyMem> replm = mi.getreplyMem(tid);
		session.setAttribute("replm", replm);
		response.sendRedirect("detail.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
