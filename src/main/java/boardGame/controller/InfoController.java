package boardGame.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import boardGame.model.InfoBean;
import boardGame.model.Product;
import boardGame.service.InfoService;

@Controller
public class InfoController {

	@Autowired
	private InfoService is;

	// 新增空白活動資料
	@GetMapping("/NewInfoManager")
	public String getsaveInfo(Model model) {
		InfoBean info = new InfoBean();
		model.addAttribute("InfoBean", info);
		return "NewInfo/NewInfoManager";
	}

	// 新增活動資料
	@PostMapping("/NewInfoManager")
	public String processsaveInfo(@ModelAttribute("InfoBean") InfoBean info) {
		is.saveInfo(info);
		return "NewInfo/UpdateInfoSuccess";
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

	@PostMapping("NewInfo/showAllLocationAjax")
	public @ResponseBody String showLocationByType(Model model,
			@RequestParam(value = "Type", required = false) String Type) {
		List<InfoBean> list = is.showAllLocationByType(Type);
		model.addAttribute("result", list);
		return "Searchresult";

	}

}
