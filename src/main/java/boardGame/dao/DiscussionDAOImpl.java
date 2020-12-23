package boardGame.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.DiscussionBoard;

@Repository
public class DiscussionDAOImpl implements DiscussionDAO {
	
	@Autowired
	public List<DiscussionBoard> getListOfArtical(){
		List <DiscussionBoard> articalsList = new ArrayList<DiscussionBoard>();
		return articalsList;
	}

	@Override
	public boolean addArtical(DiscussionBoard discussionBoard) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editArtical(DiscussionBoard discussionBoard) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteArtical(String distitle) {
		// TODO Auto-generated method stub
		return false;
	}
}
