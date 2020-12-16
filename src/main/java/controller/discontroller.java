package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.dis;
import service.disService;

@Controller
public class discontroller {
	
	@Autowired
	private disService disService;

	@GetMapping("List")
	public String ShowAllComment(Model theModel) {
		List<dis> CommentsDis = disService.ShowAllComments();
		theModel.addAttribute(CommentsDis);
		return "ShowAllComment";
	}
	
	@GetMapping("insert")
	public String insert (@ModelAttribute("dis") dis dis) {
		disService.insert(dis);
		return "ShowAllComment";
	}
	
	@GetMapping("update")
	public String update(@RequestParam ("id") String id,String comment, Model theModel) {
		disService.update(id, comment);
		theModel.addAttribute(id,comment);
		return "ShowAllComment";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam ("id") String id,String comment ) {
		disService.delete(id, comment);
		return "ShowAllComment";
	}
	
	

}
