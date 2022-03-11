package com.paul9537.test.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson05")
public class StoreViewController {
	
	@GetMapping("/store")
	public String store() {
		return "/lesson05/test06/store";
	}
	
	
}
