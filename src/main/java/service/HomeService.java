package service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.support.SessionStatus;

import dao.SessionDAO;
import model.MemberBean;
import model.SessionBean;

@Service
public class HomeService{

	@Autowired
	SessionDAO SessionDAO;
	@Transactional
	public Integer cheakSessionId(HttpServletResponse response, HttpServletRequest request, Integer id) {
		System.out.println("id = " + id);
		if(id == null) {
				Cookie[] cookies = request.getCookies();
				if(cookies != null) {
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals("sessionId")) {
							MemberBean member = SessionDAO.getMember(cookie.getValue());
							Cookie name = new Cookie("name", member.getMemName());
							name.setMaxAge(60);
							name.setPath("/TestVersion");
							response.addCookie(name);
							return member.getMemId();
						}
					}			
				}
		}
		return null;
	}
	@Transactional
	public void addSession(String SessionId, MemberBean memberBean) {
		SessionDAO.addSession(new SessionBean(SessionId, memberBean));
	}
	@Transactional
	public void logout(HttpServletResponse response,
			HttpServletRequest request,
			SessionStatus sessionStatus) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("name")) {
				cookie.setMaxAge(0);
				cookie.setPath("/TestVersion");
				response.addCookie(cookie);
			}
			else if(cookie.getName().equals("sessionId")) {
				SessionDAO.delSession(cookie.getValue());
				cookie.setMaxAge(0);
				cookie.setPath("/TestVersion");
				response.addCookie(cookie);
			}
		}
		
		sessionStatus.setComplete();
	}
	
}
