package boardGame.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.City;
import boardGame.model.District;
import boardGame.model.MemberRequestHistory;
import boardGame.model.Region;
import boardGame.model.Road;

@Repository
public class WebSocketDao {
	@Autowired
	SessionFactory factory;
	
	public void save(MemberRequestHistory memberRequestHistory) {
		factory.getCurrentSession().save(memberRequestHistory);
	}
}
