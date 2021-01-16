package boardGame.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.ACTIVITY_COMPLETED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import boardGame.model.InfoBean;
import boardGame.model.MImerge;
import boardGame.model.Product;
import boardGame.service.InfoService;

@Controller
@SessionAttributes({ "id" })
public class InfoController {

	@Autowired
	private InfoService is;

	// 取得會員id
	@ModelAttribute("id")
	public String id() {
		return null;
	}

	// 課程頁面
	@GetMapping("/Course")
	public String getAllCourse() {
		return "NewInfo/Course";
	}

	// 活動頁面
	@GetMapping("/NewActivityPage")
	public String getAllActivity() {
		return "NewInfo/NewActivityPage";
	}

	// 新增空白活動資料
	@GetMapping("/NewInfoManager")
	public String getshowact(Model model) {
		if ((Integer) model.getAttribute("id") != null && (Integer) model.getAttribute("id") == 1) {
			model.addAttribute("actNum", is.getActTypeNum());
			System.out.println(model.getAttribute("actNum"));
			InfoBean info = new InfoBean();
			model.addAttribute("InfoBean", info);
			return "NewInfo/NewInfoManager";
		}
		return "redirect:/NewInfoPage";
	}

	// 新增活動資料
	@PostMapping("/NewInfoManager")
	public String processsaveInfo(@ModelAttribute("InfoBean") InfoBean info) {
		int result = is.saveInfo(info);
		if (result > 0) {
			return "NewInfo/UpdateInfoSuccess";
		}
		return "redirect:/NewInfoManager";
	}

	@GetMapping("/DeleteInfo")
	public String deleteInfo(Integer activityId) {
		is.deleteInfo(activityId);
		return "redirect:/AllInfos";
	}

	// 修改空白活動表單
	@GetMapping("/UpdateInfo")
	public String getupdateInfo(Model model, Integer activityId) {
		InfoBean info = is.getInfo(activityId);
		model.addAttribute("info", info);
		return "NewInfo/UpdateInfo";
	}

	// 修改活動資料
	@PostMapping("/UpdateInfo")
	public String processupdateInfo(@ModelAttribute InfoBean info, @RequestParam Integer activityId,
			HttpServletRequest request, RedirectAttributes redirect) {
		is.updateInfo(info);
		return "redirect:/AllInfos";
	}

	@RequestMapping("/AllInfos")
	public String list(Model model) {
		List<InfoBean> list = is.getAllInfos();
		model.addAttribute("AllInfos", list);
		return "NewInfo/AllInfos";
	}

	// 課程類型找研習
	@PostMapping("/showCourseAjax")
	public @ResponseBody List<InfoBean> showCourseByType(Model model,
			@RequestParam(value = "activity", required = false) String activity,
			@RequestParam(value = "actType", required = false) String actType) {
		List<InfoBean> list = is.showCourseByType(activity, actType);
		System.out.println(list);
		return list;
	}

	// 課程類型找桌遊營
	@PostMapping("/showCampAjax")
	public @ResponseBody List<InfoBean> showCourseByCamp(Model model,
			@RequestParam(value = "activity", required = false) String activity,
			@RequestParam(value = "actType", required = false) String actType) {
		List<InfoBean> list = is.showCourseByCamp(activity, actType);
		System.out.println(list);
		return list;
	}

	// 地區找活動
	@PostMapping("/showAreaAjax")
	public @ResponseBody List<InfoBean> showActByArea(Model model,
			@RequestParam(value = "actArea", required = false) String actArea,
			@RequestParam(value = "activity", required = false) String activity) {
		List<InfoBean> list = is.showActByArea(actArea, activity);
		return list;
	}

	@PostMapping("/showAllAreaAjax")
	public @ResponseBody List<InfoBean> showAllAct(Model model,
			@RequestParam(value = "activity", required = false) String activity) {
		List<InfoBean> list = is.showAllAct(activity);
		return list;
	}

	@PostMapping("/showTPICampAjax")
	public @ResponseBody List<InfoBean> showTPICamp(Model model,
			@RequestParam(value = "actArea", required = false) String actArea,
			@RequestParam(value = "actType", required = false) String actType) {
		List<InfoBean> list = is.showTPICamp(actArea, actType);
		return list;
	}

	@PostMapping("/showTCHCampAjax")
	public @ResponseBody List<InfoBean> showTCHCamp(Model model,
			@RequestParam(value = "actArea", required = false) String actArea,
			@RequestParam(value = "actType", required = false) String actType) {
		List<InfoBean> list = is.showTCHCamp(actArea, actType);
		return list;
	}

	@PostMapping("/showKOHCampAjax")
	public @ResponseBody List<InfoBean> showKOHCamp(Model model,
			@RequestParam(value = "actArea", required = false) String actArea,
			@RequestParam(value = "actType", required = false) String actType) {
		List<InfoBean> list = is.showKOHCamp(actArea, actType);
		return list;
	}

	@GetMapping("/InfoMenu")
	public String NewInfoPage() {
		return "NewInfo/InfoMenu";
	}

	// 新增活動報名
	@PostMapping("/signUp")
	public String signUp(Model model, @RequestParam(value = "active", required = false) Integer activityId) {
		InfoBean infoBean = is.searchActivity(activityId);
		if ((Integer) model.getAttribute("id") != null) {
			is.addMemberActivity((Integer) model.getAttribute("id"), infoBean);
		}
		return "redirect:/MyActivity";
	}

	// 個人會員活動歷史查詢
	@GetMapping("/MyActivity")
	public String infoHistory(Model model) {
		List<MImerge> list = is.getInfoHistory((Integer) model.getAttribute("id"));
		model.addAttribute("infoHistory", list);
		return "NewInfo/MyActivity";
	}

	// 會員活動取消參加
	@GetMapping("/DeletSignUp")
	public String delectSignUp(Integer miId) {
		is.deleteSignUp(miId);
		return "redirect:/MyActivity";
	}
}
