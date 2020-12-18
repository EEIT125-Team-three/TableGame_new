package dao;

import java.util.List;
import model.InfoBean;

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
	
	public void close();
}
