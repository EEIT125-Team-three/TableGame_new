package boardGame.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.TrackList;

@Repository
public class trackLikeDao {
	
	@Autowired
	SessionFactory factory;
	
	public void insert(TrackList trackList) {
		factory.getCurrentSession().save(trackList);
	}
	
	public List<TrackList> selectAll(Integer memberId) {
		return factory.getCurrentSession().createQuery("From TrackList where mId = " + memberId).getResultList();
	}
	
	public void delete(Integer memberId, Integer productId) {
		factory.getCurrentSession().createQuery("Delete From TrackList as t where mId = " + memberId + " and pId = " + productId).executeUpdate();
	}
}
