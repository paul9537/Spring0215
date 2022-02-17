package com.paul9537.test.lesson03.bo;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paul9537.test.lesson03.dao.RealEstateDAO;
import com.paul9537.test.lesson03.model.RealEstate;

@Service
public class RealEstateBO {
	
	// 1.
	@Autowired
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstateId(@Param("id") int id) {
		return realEstateDAO.selectRealEstateId(id);
	}
	
	// 2.
	public RealEstate getRealEstateRentPrice(@Param("rentPrice") int rentPrice) {
		return realEstateDAO.selectRealEstateRentPrice(rentPrice);
	}
	
	
}
