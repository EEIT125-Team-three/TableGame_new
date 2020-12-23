package boardGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boardGame.model.dis;
import boardGame.service.disService;

@Controller
public class discontroller {

	@Autowired
	disService disService;

	@PostMapping("disservlet")
	public @ResponseBody List<dis> ShowAllComments(
			@RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "comment", required = false) String comment,
			@RequestParam(value = "user", required = false) String named,
			@RequestParam(value = "time", required = false) String time) {
		System.out.println(comment);
		System.out.println(action);
		
		return disService.getData(action, id, comment, named, time);
	}

}
