package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch01.service.MemberService;
import ch01.service.impl.MemberServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String page = "loginPage.jsp";
		request.setCharacterEncoding("utf-8");
	  if(account.trim().length() >= 0 && account  != null &&
	    password.trim().length() >= 0 && password != null) {
	   MemberService loginService = new MemberServiceImpl();
	   boolean flag = loginService.login(account, password);
	   if(flag) {
	    System.out.println("登入成功!!!");
	    request.setAttribute("account", account);
	    request.setAttribute("msg", "Login Success.....");
	    page = "index.jsp";
	   } else {
	    request.setAttribute("msg", "錯誤的帳號密碼,請重新輸入!!!");
	   }
	  } else {
	   request.setAttribute("msg", "請輸入帳號密碼");
	  }
	  request.getRequestDispatcher(page).forward(request, response);
	}

}
