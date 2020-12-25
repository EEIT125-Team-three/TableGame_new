package boardGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boardGame.model.InfoBean;
import boardGame.model.MemberBean;
import boardGame.service.InfoService;

@Controller
public class InfoController {

	@Autowired
	private InfoService is;

	@GetMapping("/NewInfoManager")
	public String getsaveInfo(Model model) {
		InfoBean info = new InfoBean();
		model.addAttribute("InfoBean", info);
		return "NewInfo/NewInfoManager";
	}

	@PostMapping("/NewInfoManager")
	public String processsaveInfo(@ModelAttribute("InfoBean") InfoBean info) {		
		is.saveInfo(info);
		return "NewInfo/UpdateInfoSuccess";
	}

	@GetMapping("/DeleteInfo")
	public String deleteInfo(Integer activityId) {
		is.deleteInfo(activityId);
		return "NewInfo/AllInfos";
	}

	@GetMapping("/UpdateInfo")
	public String getupdateInfo(Model model, Integer activityId) {
		InfoBean info = is.getInfo(activityId);
		model.addAttribute("info", info);
		return "NewInfo/UpdateInfo";
	}
	//修改活動資料
	@PostMapping("/UpdateInfo")
	public String processupdateInfo(
			@ModelAttribute InfoBean info,
			@RequestParam Integer activityId
			) {
		is.updateInfo(info);
		return "NewInfo/AllInfos";
	}
	@RequestMapping("/AllInfos")
	public String list(Model model) {
		List<InfoBean> list = is.getAllInfos();
		System.out.println(list);
		model.addAttribute("AllInfos",list);
	return "NewInfo/AllInfos";
	}
}