package boardGame.dao;

import java.util.List;

import boardGame.model.Cata2;
import boardGame.model.DiscussionBoard;
import boardGame.model.ReText;

public interface DiscussionDAO {

	public List<DiscussionBoard> getListOfArtical();

	public void addArtical(DiscussionBoard discussionBoard);

	public void editArtical(DiscussionBoard discussionBoard);

	public void deleteArtical(Integer DiscussionBoardID);
	
	public void addReText(ReText reText);
	
	public  void deleteReText(Integer retextId);
	
	public  void deleteAllReText(Integer mainArticleId);

	public List<ReText> getReText(Integer mainArticleId);

	public DiscussionBoard getDiscussionBoardID (Integer DiscussionBoardID);
	
	public Cata2 getCata2Name(Integer cata2);
	//文章列表
	public List<DiscussionBoard> getArtList(Integer cata2);
	
	//個人留言歷史查詢
	List<DiscussionBoard> getDisHistory(Integer id);
	
	List<Integer>getMainArticleReTextNum(List<Integer>list);
}
