package service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch01.model.MemberBean;
import ch01.service.MemberService;
import ch01.service.impl.MemberServiceImpl;

public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession hsession = request.getSession();
		Map<String,String> errorMsg = new HashMap<>();
		hsession.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision");
		String id = request.getParameter("id");
		int ipk = Integer.parseInt(id);
		System.out.println("modify="+modify);
		MemberService ms = new MemberServiceImpl();
		int count=0;
		if(modify.equalsIgnoreCase("DELETE")){
			count = ms.deleteMember(ipk);
			if(count ==1){
				hsession.setAttribute("modify", "刪除成功");
			}else{
				hsession.setAttribute("modify", "刪除時發生異常");
			}
			String url = request.getContextPath()+"/QueryAllMemberServlet";
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
			
		}else if(modify.equalsIgnoreCase("UPDATE")){
			String account =request.getParameter("account");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String birthday = request.getParameter("birthday");
			String phone =request.getParameter("phone");
			String mailaddress = request.getParameter("mailaddress");
			String address = request.getParameter("address");
			String idnumber = request.getParameter("idNumber");
			String pic = request.getParameter("pic");

			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/updateMember.jsp");
				rd.forward(request, response);
				return;
			}
			
			MemberBean mb = new MemberBean(ipk,account,password,name,gender,birthday,phone,mailaddress,address,idnumber,null,pic);
			count = ms.updateMember(mb);
			if(count==1){
				hsession.setAttribute("modify", "修改成功");
			}else{
				hsession.setAttribute("modify", "修改時發生異常");
			}
			String url = request.getContextPath()+"/QueryAllMemberServlet";
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
		}
	}
}
