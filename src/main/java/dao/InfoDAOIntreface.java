package dao;

import java.util.List;
import model.InfoBean;

public interface InfoDAOIntreface {
	//活動Id確認
	public boolean idExists(String activityiId);
	//新增活動
	public void insertInfo(InfoBean inf);
	
	public InfoBean getInfo(int activityId);
	//修改
	public void updateInfo(InfoBean inf);
	//刪除活動
	public void deleteInfo(int activityId);
	//
	public InfoBean loadInfo(InfoBean bean);
	//活動清單
	public List<InfoBean> getAllInfos();
	
	public void close();
}
