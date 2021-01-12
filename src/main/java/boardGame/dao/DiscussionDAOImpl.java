package boardGame.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.Cata2;
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
		session.saveOrUpdate(discussionBoard);
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
	public List<DiscussionBoard> getArtList(Integer cata2) {
		return sessionFactory.getCurrentSession().createQuery("From DiscussionBoard where cata2=" + cata2).getResultList();
	}

	
	//個人留言歷史查詢
	@SuppressWarnings("unchecked")
	@Override
	public List<DiscussionBoard> getDisHistory(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("From DiscussionBoard where memId=" + id + " order by disDate desc ").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cata2 getCata2Name(Integer cata2) {
		List<Cata2>result = sessionFactory.getCurrentSession().createQuery("FROM Cata2 where keys ="+cata2).getResultList();
		return result.get(0);
	}
	
	


}
