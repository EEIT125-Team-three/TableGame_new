package boardGame.service;

import java.util.List;

import org.springframework.ui.Model;

import boardGame.model.Cata2;
import boardGame.model.DiscussionBoard;
import boardGame.model.ReText;

public interface DiscussionService {
	public List<DiscussionBoard> getListOfArtical();

	public void editArtical(Integer DiscussionBoardID,Integer disLikeNo,Integer memId,Integer cata2,String disArticle,String distitle);

	public void deleteArtical(Integer DiscussionBoardID);
	
	public void addArtical(Integer id,String distitle, String disArtical ,Integer cata2);

	public void addReText(Integer memId,Integer mainArticleId ,String reTextTitle,String reText);
	
	public  void deleteReText(Integer retextId);
		
	public List<ReText> getReText(Integer mainArticleId);	
	
	public DiscussionBoard getDiscussionBoardID(Integer discussionBoardID);
	
	public Cata2 getCata2Name ( Integer cata2);
	//會員文章列表
	List <DiscussionBoard> getArtList(Integer cata2);
	
	//個人留言歷史查詢
	List<DiscussionBoard> getDisHistory(Integer id);
}
