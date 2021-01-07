package boardGame.dao;

import java.util.List;

import boardGame.model.InfoBean;
import boardGame.model.MImerge;
import boardGame.model.MemberBean;

public interface InfoDAOInterface {
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

	// 依課程地點查詢
	List<InfoBean> showActivityByArea(String actArea, String activity);

	// 依類型查所有地點
	public List<InfoBean> showAllActivity(String activity);

	// 依課程查類型
	public List<InfoBean> showCourseByType(String activity, String actType);

	// 依課程查桌遊營
	public List<InfoBean> showCourseByCamp(String activity, String actType);

	// 參加活動狀態
	public MImerge getSignUp(MemberBean memBean, InfoBean activityId);

	public void AddMemberActivity(MemberBean memBean, InfoBean activityId);

	public void updateMemberActivity(MImerge mImerge);

	public InfoBean SearchActivity(Integer activityId);

	// 個人會員活動歷史查詢
	List<MImerge> getInfoHistory(Integer id);

	public void close();
}
