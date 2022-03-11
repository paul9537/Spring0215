package com.paul9537.test.lesson06.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.paul9537.test.lesson06.model.Booking;

@Repository
public interface BookingDAO {
	
	public List<Booking> selectBooking();
	
	public int addBooking(
			@Param("name") String name,
			@Param("headcount") int headcount,
			@Param("day") int day,
			@Param("date") String date,
			@Param("phoneNumber") String phoneNumber,
			@Param("state") String state);
	
	public Booking selectBookings(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
	
	public int updateState(@Param("id") int id);
	
	
	
}
