package com.paul9537.test.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paul9537.test.lesson04.bo.SellerBO;
import com.paul9537.test.lesson04.model.Seller;

@Controller
@RequestMapping("/lesson04")
public class SellerController {

	@Autowired
	private SellerBO sellerBO;
	
	@RequestMapping("test01/1")
	public String getUserInfo(Model model) {
		Seller seller = sellerBO.getSellerInfo();
		model.addAttribute("seller", seller);
		return "lesson04/test01";
	}
	
	@RequestMapping("test01_insert")
	public String addView() {
		return "/lesson04/test_2";
	}
	
	@RequestMapping("test01/add_user")
	@ResponseBody
	public String insertSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("temperatrue") double temperature) {
		int count = sellerBO.insertSeller(nickname, profileImageUrl, temperature);
		
		return "입력 결과 : " + count;
	}
}
