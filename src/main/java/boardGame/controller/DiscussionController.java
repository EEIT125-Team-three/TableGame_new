package boardGame.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import boardGame.model.DiscussionBoard;
import boardGame.service.DiscussionService;
import boardGame.service.HomeService;
@Controller
@SessionAttributes({"id","name"})
//@RequestMapping("/DiscussionBoard")
public class DiscussionController {
	@Autowired
	private HomeService hs;
	@ModelAttribute("name")
	public String name() {
	return null;
	}
	@ModelAttribute("id")
	public String id() {
	return null;
	}
	
	@GetMapping(value="/Post_Article")
	public String Post_Article() {
		return "DiscussionBoard/Post_Article";
	}
	@GetMapping(value="/editArtical")
	public String editArtical() {
		return"DiscussionBoard/editArtical";
	}
	
	@GetMapping(value="/deleteArtical")
	public String deleteArtical() {
		return"DiscussionBoard/deleteArtical";
	}
	
	
	
	@Autowired
	public DiscussionService discussionService;

	@GetMapping(value = "/ArticalList")
	public String listofArtical(Model model) {
		System.out.println("AAAAAAAAAAAAAAA");
		List<DiscussionBoard> listofArtical = discussionService.getListOfArtical();
		model.addAttribute("listofArtical",listofArtical);
		System.out.println(listofArtical);
		return "DiscussionBoard/Discussion-Brain";
	}
	
	
	@PostMapping(value = "/submitForm")
	public String addArtical(
			Model model,
			@RequestParam(value="distitle", required = false) String distitle,
			@RequestParam(value="disArtical",required = false) String disArtical, 
			HttpServletResponse response,
			HttpServletRequest request) {
		System.out.println(// DiscussionBoardID +
			distitle + " ," + disArtical);
		try {
			discussionService.addArtical(
				(Integer)model.getAttribute("id"),
					distitle, disArtical );
			return "DiscussionBoard/Discussion-Brain" ;
		} catch (Exception e) {
			e.printStackTrace();
			return "DiscussionBoard/Post_Artical";
		}


//	// delete
//	@RequestMapping(value = "/deleteArtical", method = RequestMethod.GET)
//	public ModelAndView deleteArtical() {
//		System.out.println("Loading....");
//		ModelAndView view = new ModelAndView("deleteArtical");
//		view.addObject("artList", discussionService.getListOfArtical());
//		return view;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/deleteArtical", method = RequestMethod.POST)
//	public String deleteArtical(String distitle) {
//		System.out.println("inside delete");
//		String message = "Error deleting";
//		try {
//			if (distitle != null) {
//				boolean flag = discussionService.deleteArtical(distitle);
//				if (flag) {
//					message = "sucess";
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return message;
//	}
	}
}
