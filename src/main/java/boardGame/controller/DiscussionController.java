package boardGame.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boardGame.service.DiscussionService;

@Controller
public class DiscussionController {
	@Autowired
	public DiscussionService discussionService;

	@RequestMapping(value = "./postArticalajax", method = RequestMethod.POST)
	public @ResponseBody String addArtical(@RequestParam(required = true) int DiscussionBoardID,
			@RequestParam(required = true) String Distitle, @RequestParam(required = true) String DisArtical) {
		System.out.println("Check add customer ajax controller action");
		System.out.println(DiscussionBoardID + " ," + Distitle + " ," + DisArtical);
		try {
			discussionService.addArtical(DiscussionBoardID, Distitle, DisArtical);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
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
