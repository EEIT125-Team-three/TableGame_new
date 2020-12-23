package boardGame.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import boardGame.model.DiscussionBoard;
import boardGame.service.DiscussionService;

@Controller
@RequestMapping(value = "/ajax")
public class DiscussionController {
	@Autowired

	public DiscussionService discussionService;

	@RequestMapping(value = "/postArticalajax", method = RequestMethod.GET)
	public ModelAndView test() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/ArticalList", method = RequestMethod.GET)
	public ModelAndView listofArtical() {
		List<DiscussionBoard> articalsList = discussionService.getListOfArtical();
		System.out.println(articalsList.toString());
		ModelAndView view = new ModelAndView("listofArtical");
		view.addObject("artList", articalsList);
		return view;
	}

	// add
	@RequestMapping(value = "/addArtical", method = RequestMethod.GET)
	public ModelAndView addArtical() {
		System.out.println("adding Arrtical page....");
		ModelAndView view = new ModelAndView("addArtical");
		return view;
	}

	@RequestMapping(value = "/addArtical", method = RequestMethod.POST)
	public ModelAndView addArtical(DiscussionBoard discussionBoard) {
		boolean flag = discussionService.addArtical(discussionBoard);
		System.out.println("Flag:" + flag);
		ModelAndView view = new ModelAndView("addArtical");
		if (flag) {
			view.addObject("Title" + discussionBoard.getDistitle() + "Artical Added sucessfully");
		} else {
			view.addObject("Error, try again");
		}
		return view;
	}

	// edit
	@RequestMapping(value = "/editArtical", method = RequestMethod.GET)
	public ModelAndView editAtrical() {
		System.out.println("Loading....");
		ModelAndView view = new ModelAndView("editArtical");
		view.addObject("artList", discussionService.getListOfArtical());
		return view;
	}

	@RequestMapping(value = "/editArtical", method = RequestMethod.POST)
	public String ediitArtical(DiscussionBoard discussionBoard) {
		System.out.println(discussionBoard.getDisArtical());
		String message = "Error Edit Artical, please try again";
		try {
			if (discussionBoard != null) {
				boolean flag = discussionService.editArtical(discussionBoard);
				if (flag) {
					message = "Artical Edited";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	// delete
	@RequestMapping(value = "/deleteArtical", method = RequestMethod.GET)
	public ModelAndView deleteArtical() {
		System.out.println("Loading....");
		ModelAndView view = new ModelAndView("deleteArtical");
		view.addObject("artList", discussionService.getListOfArtical());
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteArtical", method = RequestMethod.POST)
	public String deleteArtical(String distitle) {
		System.out.println("inside delete");
		String message = "Error deleting";
		try {
			if (distitle != null) {
				boolean flag = discussionService.deleteArtical(distitle);
				if (flag) {
					message = "sucess";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
}
