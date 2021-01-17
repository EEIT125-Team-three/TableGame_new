package boardGame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import boardGame.dao.AreaDao;
import boardGame.dao.MemberDAO;
import boardGame.dao.SessionDAO;
import boardGame.model.City;
import boardGame.model.District;
import boardGame.model.MemberBean;
import boardGame.model.Road;
import boardGame.model.SessionBean;
import javassist.expr.NewArray;

@Service
public class HomeService{

	@Autowired
	SessionDAO SessionDAO;
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	AreaDao AreaDao;
	
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
	
	@Transactional
	public List<City> getAllCity(){
		return AreaDao.getAllCity();
	}
	
	@Transactional
	public List<District> getAllDistrict(Integer cityId){
		Set<District> set = AreaDao.getCity(cityId).getDistricts();
		List<District> relist = new ArrayList<District>();
		int relistSize = relist.size();
		Integer districtId;
		for(District district : set) {
			districtId = district.getDistrictId();
			relistSize = relist.size();
			if(relistSize == 0) {
				relist.add(district);
			}else if(districtId < relist.get(0).getDistrictId()) {
				relist.add(0, district);
			}else if(relistSize == 1){
				relist.add(district);
			}else {
				for(int i=1; i<relistSize; i++) {
					if(districtId < relist.get(i).getDistrictId()) {
						relist.add(i, district);
						break;		
					}
				}
				if(relistSize == relist.size()) {
					relist.add(district);
				}
			}
		}
		return relist;
	}
	
	@Transactional
	public List<Road> getAllRoad(Integer districtId) {
		Set<Road> set = AreaDao.getDistrict(districtId).getRoads();
		List<Road> relist = new ArrayList<Road>();
		int relistSize = relist.size();
		Integer roadId;
		for(Road road : set) {
			roadId = road.getRoadId();
			relistSize = relist.size();
			if(relistSize == 0) {
				relist.add(road);
			}else if(roadId < relist.get(0).getRoadId()) {
				relist.add(0, road);
			}else if(relistSize == 1){
				relist.add(road);
			}else {
				for(int i=1; i<relistSize; i++) {
					if(roadId < relist.get(i).getRoadId()) {
						relist.add(i, road);
						break;		
					}
				}
				if(relistSize == relist.size()) {
					relist.add(road);
				}
			}
		}
		return relist;
	}
	
	@Transactional
	public District getDistrict(Integer districtId) {
		return AreaDao.getDistrict(districtId);
	}
	
	@Transactional
	public Road getRoad(Integer roadId) {
		return AreaDao.getRoad(roadId);
	}
	
}
