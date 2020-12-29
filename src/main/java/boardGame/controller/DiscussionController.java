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
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import boardGame.model.DiscussionBoard;
import boardGame.model.MemberBean;
import boardGame.service.DiscussionService;
import boardGame.service.HomeService;
import boardGame.service.MemberService;
import boardGame.service.MemberServiceInterface;
@Controller
@SessionAttributes({"id","name"})
//@RequestMapping("/DiscussionBoard")
public class DiscussionController {
	@Autowired
	public DiscussionService discussionService;
	@Autowired
	private HomeService hs;
	@Autowired
	private MemberServiceInterface ms;
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
	
//編輯文章
	@GetMapping(value="/editArtical")
	public String editArtical(Model model, Integer DiscussionBoardID) {
		DiscussionBoard discussionBoard = discussionService.getDiscussionBoardID(DiscussionBoardID);
		System.out.println("AAAAAAAAAAAA");
		System.out.println(DiscussionBoardID);
		model.addAttribute("discussionBoard",discussionBoard);
		model.addAttribute("member", discussionBoard.getMember());
		return"DiscussionBoard/editArtical";
	}

	@PostMapping(value="/editArtical")
	public String editArtical(Model model, 
			@ModelAttribute DiscussionBoard discussionBoard,
			Integer mId,
			@RequestParam (value="distitle", required= false) String distitle,
			@RequestParam (value="disArtical", required= false) String disArtical,
			HttpServletResponse response,
			RedirectAttributes attr)throws Exception {
		discussionBoard.setMember(ms.getMember(mId));
		discussionService.editArtical(discussionBoard);
		return "DiscussionBoard/Discussion-Brain";
	}
	
	@GetMapping(value="/deleteArtical")
	public String deleteArtical() {
		return"DiscussionBoard/Discussion-Brain";
	}

	@GetMapping(value = "/ArticalList")
	public String listofArtical(Model model) {		
		List<DiscussionBoard> listofArtical = discussionService.getListOfArtical();
		model.addAttribute("listofArtical",listofArtical);
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
