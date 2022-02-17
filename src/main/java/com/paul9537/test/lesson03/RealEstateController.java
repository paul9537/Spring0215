package com.paul9537.test.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paul9537.test.lesson03.bo.RealEstateBO;
import com.paul9537.test.lesson03.model.RealEstate;

@Controller
public class RealEstateController {
	
	// 1. id로 select 하기
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/lesson03/test01")
	@ResponseBody
	public RealEstate realEstateId(@RequestParam(value="id", defaultValue="1") int id) {
		return realEstateBO.getRealEstateId(id);
	}
	
	// 2. 월세 조건 select
	@ResponseBody
	public RealEstate realEstateRentPrice(@RequestParam(value="rentPrice", defaultValue="100") int rentPrice) {
		return realEstateBO.getRealEstateRentPrice(rentPrice);
	}
	
}
