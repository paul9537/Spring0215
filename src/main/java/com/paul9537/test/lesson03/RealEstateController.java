package com.paul9537.test.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paul9537.test.lesson03.bo.RealEstateBO;
import com.paul9537.test.lesson03.model.RealEstate;

@Controller
@RequestMapping("/lesson03")
public class RealEstateController {
	
	// 1. id로 select 하기
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/test01/1")
	@ResponseBody
	public RealEstate realEstateId(@RequestParam("id") int id) {
		return realEstateBO.getRealEstateId(id);
	}
	
	// 2. 월세 조건 select
	@RequestMapping("/test01/2")
	@ResponseBody
	public List<RealEstate> realEstateRentPrice(@RequestParam("rentPrice") int rentPrice) {
		return realEstateBO.getRealEstateRentPrice(rentPrice);
	}
	
	// 3. 복합조건 select
	@RequestMapping("/test01/3")
	@ResponseBody
	public List<RealEstate> realEstateAreaPrice(
			@RequestParam("area") int area,
			@RequestParam("price") int price) {
		return realEstateBO.getRealEstateAreaPrice(area, price);
	}
	
	// INSERT 다루기
	
	// 1. 객체로 insert 하기
	@RequestMapping("/test02/1")
	@ResponseBody
	public String result() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateBO.addRealEstateByObject(realEstate);
		
		return "삽입 결과 : " + count;
	}
	
	// 2. field로 insert 하기
	@RequestMapping("/test02/2")
	@ResponseBody
	public String addRealEstateWithParameter(@RequestParam("id") int realtorId) {
		int count = realEstateBO.addRealEstateByField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "FIELD 삽입 결과 : " + count;
	}
	
	// UPDATE 다루기
	
	// 1. UPDATE
	@RequestMapping("/test03/1")
	@ResponseBody
	public String addRealEstateById() {
		int count = realEstateBO.adjustRealEstateById(27, "전세", 70000);
		return "UPDATE 결과 : " + count;
	}
	
	// DELETE 다루기
	
	// 1. DELETE
	@RequestMapping("/test04/1")
	@ResponseBody
	public String deleteRealEstateById(@RequestParam("id") int id) {
		int count = realEstateBO.deleteByRealEstate(id);
		return "DELETE 결과 : " + count;
	}
	
}
