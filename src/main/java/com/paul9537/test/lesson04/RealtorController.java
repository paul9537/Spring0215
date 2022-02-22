package com.paul9537.test.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paul9537.test.lesson04.bo.RealtorBO;
import com.paul9537.test.lesson04.model.Realtor;

@Controller
@RequestMapping("/lesson04")
public class RealtorController {
	
	@Autowired
	private RealtorBO realtorBO;
	
	@RequestMapping("/test02/add_realtor")
	public String addRealtor() {
		return "/lesson04/test02";
	}
	
	@RequestMapping("/test02/insert")
	public String insertRealtor(@ModelAttribute Realtor realtor, Model model) {
		realtorBO.addRealtor(realtor);
		
		model.addAttribute("realtor", realtor);
		
		return "/lesson04/test02Info";
	}
	
	// test02info
	@RequestMapping("test02/info")
	public String realtorInfo() {
		return "lesson04/test02Info";
	}
	
}
