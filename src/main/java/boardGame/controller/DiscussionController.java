package boardGame.controller;

import java.util.ArrayList;
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

import boardGame.model.Cata2;
import boardGame.model.DiscussionBoard;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;
import boardGame.model.ReText;
import boardGame.service.DiscussionService;
import boardGame.service.HomeService;
import boardGame.service.MemberService;
import boardGame.service.MemberServiceInterface;

@Controller
@SessionAttributes({ "id", "name" })
@RequestMapping("/DiscussionBoard")
public class DiscussionController {
	@Autowired
	public DiscussionService discussionService;

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
		return "editArtical";
	}

	@PostMapping(value = "/editArtical")
	public String editArtical(Model model,
			@RequestParam(value="discussionBoardID") Integer DiscussionBoardID,
			@RequestParam(value="disLikesNo")Integer disLikeNo,
			@RequestParam(value="memId")Integer memId,
			@RequestParam(value="cata2")Integer cata2,
			@RequestParam(value="disArticle")String disArticle,
			@RequestParam(value="distitle")String distitle
			)
			throws Exception {
		System.out.println("++++++++++++++++");
		System.out.println(cata2);
		discussionService.editArtical(DiscussionBoardID,disLikeNo,memId,cata2,disArticle,distitle);
		model.addAttribute("cata2", cata2);
		return "redirect:/DiscussionBoard/SearchCata2";
	}

	@GetMapping(value = "/deleteArtical")
	public String deleteArtical(Model model,
			@RequestParam(value = "DiscussionBoardID") Integer DiscussionBoardID,
			@RequestParam(value = "cata2") Integer cata2
			) {
		discussionService.deleteArtical(DiscussionBoardID);
		model.addAttribute("cata2", cata2);
		return "redirect:/DiscussionBoard/SearchCata2";

	}

	@GetMapping(value = "/ArticalList")
	public String listofArtical(Model model) {
		List<DiscussionBoard> listofArtical = discussionService.getListOfArtical();
		model.addAttribute("listofArtical", listofArtical);
		return "DiscussionBoard/Discussion-Brain";
	}
		
	
	@GetMapping(value = "/SearchArticalbyDisID")
	public String ListonlyArt(Model model,
			@RequestParam(value="DiscussionBoardID")Integer discussionBoardID
			) {
		System.out.println("SearchArticalbyDisID");
		System.out.println(discussionBoardID);
		DiscussionBoard GetArticalbyDisID =  	discussionService.getDiscussionBoardID(discussionBoardID);
		List<ReText>reList = discussionService.getReText(discussionBoardID); 
		//		MemberBean member = ms.getMember((Integer) model.getAttribute("id"));
		model.addAttribute("GetArticalbyDisID", GetArticalbyDisID);
		model.addAttribute("memId", (Integer) model.getAttribute("id"));
		model.addAttribute("articleId", discussionBoardID);
		model.addAttribute("reList", reList);
		return "showArticle";
	}
	                                                                                                                                                          
	@PostMapping(value = "/submitForm")
	public String addArtical(Model model,
			@RequestParam(value = "distitle") String distitle,
			@RequestParam(value = "disArtical") String disArtical, 
			@RequestParam(value="cata2") Integer cata2,
			HttpServletResponse response,
			HttpServletRequest request) {
		System.out.println(distitle + " ," + disArtical);
		System.out.println(model.getAttribute("id"));
		System.out.println(cata2);
			discussionService.addArtical((Integer) model.getAttribute("id"), distitle, disArtical,cata2);
			model.addAttribute("cata2", cata2);
			return "redirect:/DiscussionBoard/SearchCata2";
	}


	// 個人文章查詢歷史
	@GetMapping(value = "/disHistory")
	public String DisHistory(Model model) {
		List<DiscussionBoard> list = discussionService.getDisHistory((Integer) model.getAttribute("id"));
		List<Integer>DSlist = new ArrayList<Integer>();
		for(DiscussionBoard ds:list) {
			DSlist.add(ds.getDiscussionBoardID());
		}
		List<Integer>retextNum = discussionService.getMainArticleReTextNum(DSlist);
		if(DSlist.size()==retextNum.size()) {
			model.addAttribute("disHistory", list);
			model.addAttribute("retextNum",retextNum);
		}
		return "../Member/disHistory";
	}
	
	//取得該科目之文章列表及科目名稱
	@GetMapping("SearchCata2")
	public String SearchCata2(Model model, Integer cata2) {
		System.out.println("%%%%%%%");
		System.out.println(cata2);
		Cata2 thisCata2= discussionService.getCata2Name(cata2);
		List<DiscussionBoard>list = discussionService.getArtList(cata2);
		model.addAttribute("cata2",thisCata2.getCata2());
		model.addAttribute("artList",list);
		model.addAttribute("cata2Keys",thisCata2.getKeys());
		model.addAttribute("memberId",(Integer) model.getAttribute("id"));
		return "Discussion-memberPage";
	}
	//發表文章
	@GetMapping("ToPostArticle")
	public String ToPostArtical(Model model, Integer cata2) {
		if(model.getAttribute("id")!=null) {
			Cata2 thisCata2= discussionService.getCata2Name(cata2);
			model.addAttribute("cata2Keys",thisCata2.getKeys());
			model.addAttribute("cata2",thisCata2.getCata2());
			return "Post_Article";			
		}
		return "../Member/loginPage";
	}
	//對文章發表回覆
	@GetMapping("AddReText")
	public String AddReText(Model model,
			@RequestParam(value="memId")Integer memId,
			@RequestParam(value="mainArticleId")Integer mainarticleId,
			@RequestParam(value="re_textTitle")String re_textTitle,
			@RequestParam(value="re_text")String re_text
			) {
		discussionService.addReText(memId, mainarticleId, re_textTitle, re_text);
		model.addAttribute("DiscussionBoardID", mainarticleId);
		return "redirect:/DiscussionBoard/SearchArticalbyDisID";
	}
	//刪除回覆
	@GetMapping("DeleteReText")
	public String DeleteReText(Model model,
			@RequestParam(value="retextId")Integer retextId,
			@RequestParam(value="mainArticleId")Integer mainarticleId
			) {
		discussionService.deleteReText(retextId);
		model.addAttribute("DiscussionBoardID", mainarticleId);
		return "redirect:/DiscussionBoard/SearchArticalbyDisID";

	}
}

