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
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;
import boardGame.service.DiscussionService;
import boardGame.service.HomeService;
import boardGame.service.MemberService;
import boardGame.service.MemberServiceInterface;

@Controller
@SessionAttributes({ "id", "name" })
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

	@GetMapping(value = "/Post_Article")
	public String Post_Article() {
		return "DiscussionBoard/Post_Article";
	}

//編輯文章
	@GetMapping(value = "/editArtical")
	public String editArtical(Model model, Integer DiscussionBoardID) {
		DiscussionBoard discussionBoard = discussionService.getDiscussionBoardID(DiscussionBoardID);
		System.out.println("AAAAAAAAAAAA");
		System.out.println(DiscussionBoardID);
		model.addAttribute("discussionBoard", discussionBoard);
		model.addAttribute("member", discussionBoard.getMember());
		return "DiscussionBoard/editArtical";
	}

	@PostMapping(value = "/editArtical")
	public String editArtical(Model model, @ModelAttribute DiscussionBoard discussionBoard, Integer mId,
			@RequestParam(value = "distitle", required = false) String distitle,
			@RequestParam(value = "disArtical", required = false) String disArtical, HttpServletResponse response,
			RedirectAttributes attr) throws Exception {
		discussionBoard.setMember(ms.getMember(mId));
		discussionService.editArtical(discussionBoard);
		return "DiscussionBoard/Discussion-Brain";
	}

	@GetMapping(value = "/deleteArtical")
	public String deleteArtical(Model model,
			@RequestParam(value = "DiscussionBoardID", required = false) Integer DiscussionBoardID) {
		discussionService.deleteArtical(DiscussionBoardID);
		return "DiscussionBoard/Discussion-Brain";

	}

	@GetMapping(value = "/ArticalList")
	public String listofArtical(Model model) {
		List<DiscussionBoard> listofArtical = discussionService.getListOfArtical();
		model.addAttribute("listofArtical", listofArtical);
		return "DiscussionBoard/Discussion-Brain";
	}
		
// 列出個別文章，從標題點進去進入文章-->看夏哥 mainpage(jsp) to search Product by ID

	@GetMapping(value = "/GetArticalbyDisID")
	public String GetArticalbyDisID(Model model,
			@RequestParam(value = "DiscussionBoardID", required = false) Integer discussionBoardID) {
		System.out.println("AAAAAAAA");
	List<DiscussionBoard> GetArticalbyDisID =  	discussionService.getArtList(discussionBoardID);
	model.addAttribute("GetArticalbyDisID", GetArticalbyDisID);
		return "DiscussionBoard/Discussion-Brain-EveryBody";
	}
	                                                                                                                                                          
	@PostMapping(value = "/submitForm")
	public String addArtical(Model model, @RequestParam(value = "distitle", required = false) String distitle,
			@RequestParam(value = "disArtical", required = false) String disArtical, HttpServletResponse response,
			HttpServletRequest request) {
		System.out.println(// DiscussionBoardID +
				distitle + " ," + disArtical);
		try {
			discussionService.addArtical((Integer) model.getAttribute("id"), distitle, disArtical);
			return "DiscussionBoard/Discussion-Brain";
		} catch (Exception e) {
			e.printStackTrace();
			return "DiscussionBoard/Post_Artical";
		}
	}


	// 個人文章查詢歷史
	@GetMapping(value = "/disHistory")
	public String DisHistory(Model model) {
		List<DiscussionBoard> list = discussionService.getDisHistory((Integer) model.getAttribute("id"));
		model.addAttribute("disHistory", list);
		return "Member/disHistory";
	}
}
