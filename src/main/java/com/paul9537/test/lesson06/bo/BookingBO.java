package com.paul9537.test.lesson06.bo;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paul9537.test.lesson06.dao.BookingDAO;
import com.paul9537.test.lesson06.model.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingDAO bookingDAO;
	
	public List<Booking> getBooking() {
		return bookingDAO.selectBooking();
	}
	
	public int addBooking(String name, int headcount, int day, String date, String phoneNumber) {
		return bookingDAO.addBooking(name, headcount, day, date, phoneNumber, date);
	}
	
	public Booking getBookings(String name, String phoneNumber) {
		return bookingDAO.selectBookings(name, phoneNumber);
	}
	
	public int changeState(int id) {
		return bookingDAO.updateState(id);
	}
	
}
