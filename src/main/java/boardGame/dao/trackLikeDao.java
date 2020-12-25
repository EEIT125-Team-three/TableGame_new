package boardGame.dao;

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
	
	public void selectAll() {
		
	}
}
