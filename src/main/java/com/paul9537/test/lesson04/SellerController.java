package com.paul9537.test.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("test01/input")
	public String sellerInput() {
		return "/lesson04/test01";
	}
	
	@PostMapping("test01/add_seller")
	@ResponseBody
	public String insertSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		int count = sellerBO.insertSeller(nickname, profileImageUrl, temperature);
		
		return "입력 결과 : " + count;
	}
	
	@GetMapping("/test01/seller_info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id,
			Model model) {
		// id라는 파라미터가 있으면 해당하는 정보 출력
		if(id != null) {
			Seller seller = sellerBO.getSeller(id);
			model.addAttribute("seller", seller);
		} else { // id 파라미터가 없으면 가장 최근 판매자 출력
			Seller seller = sellerBO.getLastSeller();
			model.addAttribute("seller", seller);
		}
		
		
		
		
		return "lesson04/test01_2";
	}
	
	
	
}
