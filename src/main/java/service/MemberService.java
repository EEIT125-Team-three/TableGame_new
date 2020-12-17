package service;

import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanAttributeInfo;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDAOInterface;
import dao.MemberDAO;

import model.MemberBean;
import service.MemberServiceInterface;

@Service
public class MemberService implements MemberServiceInterface {

	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	MemberDAOInterface dao;

	@Transactional
	@Override
	public int insertMember(MemberBean mb) {
		int count = 0;		
			dao.insertMember(mb);
			count++;
		return count;
	}
	
	@Transactional
	@Override
	public List<MemberBean> getAllMembers() {
		return dao.getAllMembers();
	}

	@Transactional
	@Override
	public MemberBean getMember(Integer id) {
		MemberBean mb = null;		
			mb = dao.getMember(id);
		return mb;
	}

	@Transactional
	@Override
	public Integer deleteMember(int id) {
		int count = 0;
			dao.deleteMember(id);
			count++;		
		return count;
	}
	
	@Transactional
	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;		
			dao.updateMember(mb);
			count++;			
		return count;
	}
	
	@Transactional
	@Override
	public boolean login(String account, String password) {
		 boolean mb =dao.login(account, password);
		return mb;		
	}
}
