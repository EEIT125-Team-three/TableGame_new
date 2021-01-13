package boardGame.service;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import boardGame.dao.MemberDAO;
import boardGame.dao.SessionDAO;
import boardGame.model.MemberBean;
import boardGame.model.SessionBean;

@Service
public class HomeService{

	@Autowired
	SessionDAO SessionDAO;
	@Autowired
	MemberDAO memberDAO;
	@Transactional
	public Integer cheakSessionId(HttpServletResponse response, HttpServletRequest request, Integer id, Model model) {
		Cookie[] cookies = request.getCookies();
		if(id == null) {
				if(cookies != null) {
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals("sessionId")) {
							MemberBean member = SessionDAO.getMember(cookie.getValue());
							if(member == null) {
								return null;
							}
							Cookie sessionId = new Cookie("sessionId", cookie.getValue());
							sessionId.setMaxAge(60*60*24*365);
							sessionId.setPath(request.getContextPath());
							model.addAttribute("name", member.getMemName());
							response.addCookie(sessionId);
							return member.getMemId();
						}
					}			
				}
				else {
					return null;
				}
		}
		else {
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("sessionId")) {
						Cookie sessionId = new Cookie("sessionId", cookie.getValue());
						sessionId.setMaxAge(60*60*24*365);
						sessionId.setPath(request.getContextPath());
						response.addCookie(sessionId);
					}
				}
			}
			model.addAttribute("name", memberDAO.getMember(id).getMemName());
			
			return id;
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
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
			else if(cookie.getName().equals("sessionId")) {
				SessionDAO.delSession(cookie.getValue());
				cookie.setMaxAge(0);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
		}
		sessionStatus.setComplete();
	}
	
	@Transactional
	public Boolean checkCookieHasSessionId(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("sessionId")) {
					if(SessionDAO.getMember(cookie.getValue()) != null) {
						return true;
					}
				}
			}			
		}
		return false;
	}
}
