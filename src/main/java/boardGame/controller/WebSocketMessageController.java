package boardGame.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import boardGame.service.TableGameWebSocketService;

@Controller
@SessionAttributes({ "id", "name" })
public class WebSocketMessageController {

	// websocket服務層呼叫類
	@Autowired
	private TableGameWebSocketService tableGameWebSocketService;

	// 請求入口
	@PostMapping("/message/sentToMember")
	@ResponseBody
	public Boolean sentMessage(@RequestParam(required = true) String userId, @RequestParam(required = true) String message, Model model) {
		return tableGameWebSocketService.sendToAllTerminal(userId, message, (Integer)model.getAttribute("id"));
	}

	@PostMapping("/message/getAllMember")
	public @ResponseBody Set<String> getAllMember(Model model) {
		if ((Integer) model.getAttribute("id") == 1) {
			return tableGameWebSocketService.allMember();
		}
		return new HashSet<String>();
	}

	@PostMapping("/message/getMemberMessage")
	public @ResponseBody List<String> getMemberMessage(Integer memberId, Model model) {
		return tableGameWebSocketService.getMemberMessage(memberId, (Integer)model.getAttribute("id"));
	}
	@GetMapping("/getWebSocketPage")
	public String getWebSocketPage(Model model) {
		if ((Integer) model.getAttribute("id") == 1) {
			return "webSocketManagerPage";
		}
		return "webSocketPage";
	}
	
}
