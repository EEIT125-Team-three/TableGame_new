package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class shopCarController {
	@GetMapping("/test")
	public @ResponseBody Map<String, Object> test(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("jsondata", "123");
        result.put("responseMsg", "456");
		return result;
	}
}
