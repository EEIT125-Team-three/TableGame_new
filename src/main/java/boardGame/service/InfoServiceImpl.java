package boardGame.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardGame.dao.InfoDAOInterface;
import boardGame.dao.MemberDAO;
import boardGame.dao.MemberDAOInterface;
import boardGame.model.InfoBean;
import boardGame.model.MImerge;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;

@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	InfoDAOInterface dao;

	@Autowired
	MemberDAOInterface memDao;

	@Transactional
	@Override
	public boolean idExists(String activityId) {
		boolean exist = false;
		exist = dao.idExists(activityId);
		return exist;
	}

	@Transactional
	@Override
	public int updateInfo(InfoBean inf) {
		int count = 0;
		dao.updateInfo(inf);
		count++;
		return count;
	}

	@Transactional
	@Override
	public int saveInfo(InfoBean inf) {
		int count = 0;
		dao.saveInfo(inf);
		count++;
		return count;
	}

	@Transactional
	@Override
	public InfoBean getInfo(Integer activityId) {
		InfoBean info = null;
		info = dao.getInfo(activityId);
		return info;
	}

	@Transactional
	@Override
	public List<InfoBean> getAllInfos() {
		return dao.getAllInfos();
	}

	@Transactional
	@Override
	public int deleteInfo(int activity_id) {
		int count = 0;
		dao.deleteInfo(activity_id);
		count++;
		return count;
	}

	@Transactional
	@Override
	public List<InfoBean> showActByArea(String actArea, String activity) {

		return dao.showActivityByArea(actArea, activity);
	}

	@Transactional
	@Override
	public List<InfoBean> showAllAct(String activity) {

		return dao.showAllActivity(activity);
	}

	@Override
	public void close() {
		dao.close();

	}

	@Transactional
	@Override
	public void addMemberActivity(Integer memId, InfoBean infoIdBean) {
		MemberBean memBean = memDao.getMember(memId);
		MImerge mImerge = dao.getSignUp(memBean, infoIdBean);
		if (mImerge == null) {
			dao.AddMemberActivity(memBean, infoIdBean);
		} else {
			dao.updateMemberActivity(mImerge);
		}
	}
	
	@Override
	public InfoBean searchActivity(Integer activityId) {
		InfoBean info = dao.SearchActivity(activityId);
		System.out.println(info);
		return info;
	}
}