package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.InfoBean;
import service.InfoService;

@Controller
public class InfoController {

	@Autowired
	private InfoService is;

	@GetMapping("/InfoManager")
	public String getsaveInfo(Model model) {
		InfoBean info = new InfoBean();
		model.addAttribute("InfoBean", info);
	
		return "NewInfo/InfoManager";
	}

	@PostMapping("/InfoManager")
	public String processsaveInfo(@ModelAttribute("InfoBean") InfoBean info 
			)
			 {
		System.out.println(info);
		is.saveInfo(info);
		return "NewInfo/showAllInfos";
	}

	@GetMapping("/DeleteInfo")
	public String deleteInfo(Integer activityId) {
		is.deleteInfo(activityId);
		return "NewInfo/showAllInfos";
	}

	@GetMapping("/UpdateInfo")
	public String getupdateInfo(Model model, Integer activityId) {
		InfoBean info = is.getInfo(activityId);
		model.addAttribute("info", info);
		return "NewInfo/updateInfo";
	}

	@PostMapping("/UpdateInfo")
	public String processupdateInfo(@ModelAttribute InfoBean info) {
		is.updateInfo(info);
		return "showAllInfo";
	}

}