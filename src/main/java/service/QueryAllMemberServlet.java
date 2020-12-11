package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import service.MemberService;
import service.MemberServiceImpl;

public class QueryAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService ms = new MemberServiceImpl();
		List <MemberBean>list = ms.getAllMembers();
		request.setAttribute("allMembers", list);
		RequestDispatcher rd = request.getRequestDispatcher("/showMembers.jsp");
		rd.forward(request, response);
		return;		
	}

}
