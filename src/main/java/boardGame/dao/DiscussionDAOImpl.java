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

//	public boolean findDisID (Integer DiscussionBoardID) {
//		DiscussionBoard ID=(DiscussionBoard)sessionFactory.getCurrentSession().load(
//				DiscussionBoard.class, (Serializable) ID);
//		return null!=ID;
//	}

	@Override
	public void deleteArtical(String distitle) {
		// TODO Auto-generated method stub

	}
//取得文章ID
	@Override
	public DiscussionBoard getDiscussionBoardID  (Integer DiscussionBoardID) {
		Session session = sessionFactory.getCurrentSession();
		DiscussionBoard discussionBoard= (DiscussionBoard) session.load(DiscussionBoard.class, new Integer(DiscussionBoardID));
		return discussionBoard;
		
	}


}
