package boardGame.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

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
	public void addArtical(String distitle, String disArtical,Model model ) {
		Date disDate = new Date(0);
		System.out.println(disDate);
		
		discussionDAO.addArtical(new DiscussionBoard(distitle,disArtical , disDate,0, memberDAO.getMember((Integer)model.getAttribute("id")))) ;

	}


}
