package boardGame.controller;

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

import boardGame.service.DiscussionService;
import boardGame.service.HomeService;
@Controller
@SessionAttributes({"name"})
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
	
	@Autowired
	public DiscussionService discussionService;

	@PostMapping(value = "/submitForm")
	public String addArtical(
			Model model,
			// @RequestParam(required = true) int DiscussionBoardID,
			@RequestParam(value="distitle", required = false) String distitle,
			@RequestParam(value="disArtical",required = false) String disArtical, 
			HttpServletResponse response,
			HttpServletRequest request) {
		System.out.println(// DiscussionBoardID +
			distitle + " ," + disArtical);
		try {
			discussionService.addArtical(
					// DiscussionBoardID,
					distitle, disArtical, model);
			return "DiscussionBoard/Discussion-Bran" ;
		} catch (Exception e) {
			e.printStackTrace();
			return "DiscussionBoard/Post_Artical";
		}

//	@RequestMapping(value = "/ArticalList", method = RequestMethod.GET)
//	public ModelAndView listofArtical() {
//		List<DiscussionBoard> articalsList = discussionService.getListOfArtical();
//		System.out.println(articalsList.toString());
//		ModelAndView view = new ModelAndView("listofArtical");
//		view.addObject("artList", articalsList);
//		return view;
//	}
//
//	// edit
//	@RequestMapping(value = "/editArtical", method = RequestMethod.GET)
//	public ModelAndView editAtrical() {
//		System.out.println("Loading....");
//		ModelAndView view = new ModelAndView("editArtical");
//		view.addObject("artList", discussionService.getListOfArtical());
//		return view;
//	}
//
//	@RequestMapping(value = "/editArtical", method = RequestMethod.POST)
//	public String ediitArtical(DiscussionBoard discussionBoard) {
//		System.out.println(discussionBoard.getDisArtical());
//		String message = "Error Edit Artical, please try again";
//		try {
//			if (discussionBoard != null) {
//				boolean flag = discussionService.editArtical(discussionBoard);
//				if (flag) {
//					message = "Artical Edited";
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return message;
//	}
//
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
