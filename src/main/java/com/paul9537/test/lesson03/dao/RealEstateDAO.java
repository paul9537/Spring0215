package com.paul9537.test.lesson03.dao;

import org.springframework.stereotype.Repository;

import com.paul9537.test.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	// 1.
	public RealEstate selectRealEstateId(int id);
	
	// 2.
	public RealEstate selectRealEstateRentPrice(int rentPrice);
}
