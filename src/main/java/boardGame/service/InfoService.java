package boardGame.service;

import java.util.List;

import boardGame.model.InfoBean;

public interface InfoService {
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
	//依類型尋找地點
	public List<InfoBean> showAllLocationByType(String type);


	public void close();

}
