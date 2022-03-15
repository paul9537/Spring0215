package com.paul9537.test.lesson06;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paul9537.test.lesson06.bo.BookingBO;
import com.paul9537.test.lesson06.model.Booking;

@Controller
@RequestMapping("/lesson06")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/pension")
	public String viewMain() {
		return "/lesson06/test02/main";
	}
	
	@GetMapping("/booking_list")
	public String viewBooking(Model model) {
		List<Booking> booking = bookingBO.getBooking();
		
		model.addAttribute("booking", booking);
		
		return "/lesson06/test02/bookingList";
	}
	
	@GetMapping("/reservation")
	public String viewReservation() {
		return "/lesson06/test02/reservation";
	}
	
	@GetMapping("/add_booking")
	@ResponseBody
	public Map<String, String> addBooking(
			@RequestParam("name") String name,
			@RequestParam("headcount") int headcount,
			@RequestParam("day") int day,
			@RequestParam("date") String date,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingBO.addBooking(name, headcount, day, date, phoneNumber);
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@GetMapping("/get_booking")
	@ResponseBody
	public Map<String, Object> getBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.getBookings(name, phoneNumber);
		// {"result":"success", 
		// {"booking": {"name":"장나라", "phoneNumber":"010-2222-0000", "date":"2022-03-10", "day":4}}
		// {"name":"장나라", "phoneNumber":"010-2222-0000", "date":"2022-03-10", "day":4}
		
		Map<String, Object> result = new HashMap<>();
		if(booking != null) {
			result.put("result", "success");
			result.put("booking", booking);
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@GetMapping("/change_state")
	@ResponseBody
	public Map<String, String> changeState(@RequestParam("id") int id) {
		
		int count = bookingBO.changeState(id);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
	
}
