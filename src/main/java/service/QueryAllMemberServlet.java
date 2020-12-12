package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import service.MemberServiceInterface;
import service.MemberService;

public class QueryAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		WebApplicationContext ctx =
		WebApplicationContextUtils.getWebApplicationContext(sc);
		MemberService ms = ctx.getBean(MemberService.class);
		
		List <MemberBean>list = ms.getAllMembers();
		request.setAttribute("allMembers", list);
		RequestDispatcher rd = request.getRequestDispatcher("/showMembers.jsp");
		rd.forward(request, response);
		return;		
	}

}
