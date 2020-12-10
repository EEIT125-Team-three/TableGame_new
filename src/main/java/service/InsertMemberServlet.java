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

                   
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("error", errorMsg);
		
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
		
		
		//企業邏輯的運算
		MemberService ms = new MemberServiceImpl();
		if (ms.isDup(account)){
			errorMsg.put("account", "帳號重複，請重新輸入新帳號");
			RequestDispatcher rd = request.getRequestDispatcher("/MemberForm.jsp");
			rd.forward(request,response);
			return;
		}
		//轉向成功加入會員頁面
		HttpSession session = request.getSession();
		try{
			//將要寫入的資料裝到Bean內
			MemberBean mb = new MemberBean(null, account,password,name,gender,birthday,phone,mailaddress,address,idnumber,null, pic);
			session.setAttribute("mb", mb);    
			ms.save(mb);    
		}catch(Exception e){
			errorMsg.put("account", "寫入資料時發生異常,訊息:"+ e.getMessage());
		}
		//沒有任何錯誤時
		if(errorMsg.isEmpty()){
			//不這樣寫是因為頁面不會跳轉,若案重新整理寫入資料會重做一遍,容易有疑慮
			//RequestDispatcher rd = request.getRequestDispatcher("/ch01/InsertMemberSuccess.jsp");
			String url = request.getContextPath()+ "/InsertMemberSuccess.jsp";
			String targetURL = response.encodeRedirectURL(url);
			//新增資料成功,利用response.encodeRedirect送出回應,共用資料放在Session物件
			//新增資料失敗,利用RequestDispatcher送出回應,共用資料放在request物件
			response.sendRedirect(targetURL);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/MemberForm.jsp");
			rd.forward(request,response);
			return;
		}
	}
}
