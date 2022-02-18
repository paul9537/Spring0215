package com.paul9537.test.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paul9537.test.lesson03.dao.RealEstateDAO;
import com.paul9537.test.lesson03.model.RealEstate;

@Service
public class RealEstateBO {
	
	// 1.
	@Autowired
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstateId(int id) {
		return realEstateDAO.selectRealEstateId(id);
	}
	
	// 2.
	public List<RealEstate> getRealEstateRentPrice(int rentPrice) {
		return realEstateDAO.selectRealEstateRentPrice(rentPrice);
	}
	
	// 3.
	public List<RealEstate> getRealEstateAreaPrice(int area, int price) {
		return realEstateDAO.selectRealEstateAreaPrice(area, price);
	}
	
	// INSERT 다루기
	
	// 1.
	public int addRealEstateByObject(RealEstate realEstate) {
		return realEstateDAO.insertRealEstateByObject(realEstate);
	}
	
	// 2.
	public int addRealEstateByField(int realtorId, String address, int area, String type, int price, int rentPrice) {
		return realEstateDAO.insertRealEstateByField(realtorId, address, area, type, price, rentPrice);
	}
	
	// UPDATE 다루기
	
	// 1.
	public int adjustRealEstateById(int price) {
		return realEstateDAO.updateRealEstateById(price);
	}
	
	
	
}
