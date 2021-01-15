package boardGame.service;

import java.util.List;

import boardGame.model.InfoBean;
import boardGame.model.MImerge;

public interface InfoService {
	// 活動Id確認
	public boolean idExists(String activityiId);

	// 新增活動
	int saveInfo(InfoBean inf);

	// 取得ID
	InfoBean getInfo(Integer activityId);

	// 修改
	int updateInfo(InfoBean inf);

	// 刪除活動
	int deleteInfo(int activityId);

	// 活動清單
	public List<InfoBean> getAllInfos();

	// 依類型尋找地點
	List<InfoBean> showActByArea(String actArea, String activity);

	// 依類型尋找所有活動
	List<InfoBean> showAllAct(String activity);

	// 課程類型查課程
	List<InfoBean> showCourseByType(String activity, String actType);

	// 課程類型查桌遊營
	List<InfoBean> showCourseByCamp(String activity, String actType);

	// 以id查詢活動
	public InfoBean searchActivity(Integer activityId);

	public void addMemberActivity(Integer memId, InfoBean infoIdBean);
	// 個人會員活動歷史查詢
	List<MImerge> getInfoHistory(Integer id);
	//會員活動取消
	int deleteSignUp(int miId);
	public void close();




}
