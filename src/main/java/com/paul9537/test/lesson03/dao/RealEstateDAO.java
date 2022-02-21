package com.paul9537.test.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.paul9537.test.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	// 1.
	public RealEstate selectRealEstateId(@Param("id") int id);
	
	// 2.
	public List<RealEstate> selectRealEstateRentPrice(@Param("rentPrice") int rentPrice);
	
	// INSERT 다루기
	
	// 1.
	public List<RealEstate> selectRealEstateAreaPrice(
			@Param("area") int area, 
			@Param("price") int price);
	
	public int insertRealEstateByObject(RealEstate realEstate);
	
	// 2.
	public int insertRealEstateByField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") int rentPrice);
	
	// UPDATE 다루기
	
	// 1.
	public int updateRealEstateById(
		@Param("id") int id,
		@Param("type") String type,
		@Param("price") int price);
	// DELETE 다루기
	
	// 1.
	public int deleteRealEstateById(@Param("id") int id);
		
}
