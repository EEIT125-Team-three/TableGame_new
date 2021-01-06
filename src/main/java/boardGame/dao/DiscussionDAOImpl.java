package boardGame.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import boardGame.model.DiscussionBoard;

@Repository
public class DiscussionDAOImpl implements DiscussionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	//List all article
	@SuppressWarnings("unchecked")
	@Override
	public List<DiscussionBoard> getListOfArtical() {
		List<DiscussionBoard> listofArtical = new ArrayList<>();
		String hql = "FROM DiscussionBoard";
		Session session=sessionFactory.getCurrentSession();
		Query<DiscussionBoard> query = session.createQuery(hql);
		listofArtical=query.getResultList();
		return listofArtical;
	}

	//EDIT
	@Override
	public void editArtical(DiscussionBoard discussionBoard) {
		Session session = sessionFactory.getCurrentSession();
		session.update(discussionBoard);
	}

	//insert new 
	@Override
	public void addArtical(DiscussionBoard discussionBoard) {
		Session session = sessionFactory.getCurrentSession();
		session.save(discussionBoard);
	}

//取得文章ID
	@Override
	public DiscussionBoard getDiscussionBoardID  (Integer DiscussionBoardID) {
		Session session = sessionFactory.getCurrentSession();
		DiscussionBoard discussionBoard= (DiscussionBoard) session.get(DiscussionBoard.class,DiscussionBoardID);
		return discussionBoard;
		
	}
	
	@Override
	public void deleteArtical(Integer DiscussionBoardID) {
		Session session = sessionFactory.getCurrentSession();	
		session.delete(getDiscussionBoardID(DiscussionBoardID));
	}
	
	//文章列表
	@SuppressWarnings("unchecked")
	@Override
	public List<DiscussionBoard> getArtList(Integer DiscussionBoardID) {
		return sessionFactory.getCurrentSession().createQuery("From DiscussionBoard where discussionBoardID=" + DiscussionBoardID+" order by disDate desc").list();
	}

	
	//個人留言歷史查詢
	@SuppressWarnings("unchecked")
	@Override
	public List<DiscussionBoard> getDisHistory(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("From DiscussionBoard where memId=" + id + " order by disDate desc ").list();
	}
	
	


}
