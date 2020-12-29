package boardGame.dao;

import java.util.List;

import boardGame.model.InfoBean;

public interface InfoDAOInterface {
	//活動Id確認
	public boolean idExists(String activityiId);
	//新增活動
	int saveInfo(InfoBean inf);
	//取得ID
	InfoBean getInfo(Integer activityId);
	//修改
	int updateInfo(InfoBean inf);
	//刪除活動
	int deleteInfo(int activityId);
	//活動清單
	public List<InfoBean> getAllInfos();
	//依課程地點查詢	
	List<InfoBean> showActivityByArea(String actArea, String activity);
	//依類型查所有地點
	public List<InfoBean> showAllActivity(String activity);
	public void close();

}
