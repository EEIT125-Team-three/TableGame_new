package boardGame.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import boardGame.model.DiscussionBoard;

@Repository
public class DiscussionDAOImpl implements DiscussionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<DiscussionBoard> getListOfArtical() {
		List<DiscussionBoard> articalsList = new ArrayList<DiscussionBoard>();
//		try {

//		}

		return articalsList;
	}

//	public void addArtical(DiscussionBoard discussionBoard) {
//		Session session = sessionFactory.getCurrentSession();
//		session.save(discussionBoard);
//
//	}

	public void editArtical(DiscussionBoard discussionBoard) {
		Session session = sessionFactory.getCurrentSession();
		session.save(discussionBoard);

	}

	public void addArtical(String distitle) {
		Session session = sessionFactory.getCurrentSession();
		session.save(distitle);

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

	@Override
	public void addArtical(int discussionBoardID, String distitle, String disArtical) {
		Session session = sessionFactory.getCurrentSession();
		session.save(discussionBoardID);

	}

}
