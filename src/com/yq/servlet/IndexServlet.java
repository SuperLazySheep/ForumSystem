package com.yq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.entity.Board;
import com.yq.entity.Count;
import com.yq.entity.Forcum;
import com.yq.entity.Member;
import com.yq.entity.Test;
import com.yq.service.MemberImpl;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
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
		// request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
//		try {
		Member user = (Member) session.getAttribute("user");
		MemberImpl mi = new MemberImpl();
		List<Forcum> forcum = mi.getForcum();
		List<Board> board = mi.getBoard();
		List<Count> count = mi.gettotal();
		List<Test> count2 = mi.gettotal2();
		session.setAttribute("forcum", forcum);
		session.setAttribute("board", board);
		session.setAttribute("count", count);
		session.setAttribute("user", user);
		session.setAttribute("c2", count2);
		response.sendRedirect("index.jsp");
//		}catch(Exception e) {
//			MemberImpl mi = new MemberImpl();
//			List<Forcum> forcum=mi.getForcum();
//			List<Board> board=mi.getBoard();
//			List<Count> count=mi.gettotal();
//			List<Member> user=new ArrayList<>();
//			user.add(new Member(null));
//			session.setAttribute("forcum", forcum);
//			session.setAttribute("board", board);
//			session.setAttribute("count", count);
//			session.setAttribute("user", user);
//			response.sendRedirect("index.jsp");
//			e.printStackTrace();
//			}

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
