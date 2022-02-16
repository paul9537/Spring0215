package com.paul9537.test.lesson1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test02 {

	@RequestMapping("lesson01/test02")
	public String view() {
		return "lesson01/test02/test02";
	}
	
}
