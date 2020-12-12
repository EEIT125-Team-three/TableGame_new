package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import service.MemberServiceInterface;
import service.MemberService;

@Controller
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
		int id = Integer.parseInt(key);
		ServletContext sc = getServletContext();
		WebApplicationContext ctx =
		WebApplicationContextUtils.getWebApplicationContext(sc);
		MemberService ms = ctx.getBean(MemberService.class);		
		MemberBean mb = ms.getMember(id);
		request.setAttribute("mb", mb);
		RequestDispatcher rd = request.getRequestDispatcher("/updateMember.jsp");
		rd.forward(request, response);
		return;
	}
}
