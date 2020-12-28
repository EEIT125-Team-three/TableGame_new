package boardGame.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import boardGame.dao.DiscussionDAO;
import boardGame.dao.MemberDAO;
import boardGame.model.DiscussionBoard;
import boardGame.model.MemberBean;
import javassist.Loader.Simple;

@Service
public class DiscussionServiceImpl implements DiscussionService {
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	public DiscussionDAO discussionDAO;

	@Override
	@Transactional
	public List<DiscussionBoard> getListOfArtical() {
		return discussionDAO.getListOfArtical();
	}

//	@Transactional
//	public void addArtical(DiscussionBoard discussionBoard){
//		 discussionDAO.addArtical(discussionBoard);
//	}
	@Transactional
	public void editArtical(DiscussionBoard discussionBoard) {
		discussionDAO.editArtical(discussionBoard);
	}

	@Transactional
	public void deleteArtical(String distitle) {
		discussionDAO.deleteArtical(distitle);
	}

	@Override
	public boolean findDisID(Integer DiscussionBoardID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public void addArtical(Integer id,String distitle, String disArtical)  {
		Date disDate = new Date();
		discussionDAO.addArtical(new DiscussionBoard(memberDAO.getMember(id),distitle,disArtical , disDate,0 )) ;
		System.out.println(disDate);
	}

	@Override
	public DiscussionBoard getDiscussionBoardID(Integer discussionBoardID) {
	return 	discussionDAO.getDiscussionBoardID(discussionBoardID);
		
		
	}


}
