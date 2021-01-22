package boardGame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boardGame.service.TableGameWebSocketService;

@Controller
@RequestMapping("/message")
public class WebSocketMessageController {
	
    //websocket服務層呼叫類
    @Autowired
    private TableGameWebSocketService tableGameWebSocketService;

  //請求入口
    @PostMapping("/sentToMember")
    @ResponseBody
    public Boolean TestWS(@RequestParam(value="userId",required=true) String userId,
        @RequestParam(value="message",required=true) String message){
    	return tableGameWebSocketService.sendToAllTerminal(userId, message);
    }
}
