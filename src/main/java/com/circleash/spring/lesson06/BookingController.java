package com.circleash.spring.lesson06;

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

import com.circleash.spring.lesson06.bo.BookingBO;
import com.circleash.spring.lesson06.model.Booking;

@Controller
@RequestMapping("/lesson06")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking_list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		
		return "lesson06/bookingList";
	}
	
	@GetMapping("/booking_delete")
	@ResponseBody
	public Map<String, String> delete(
			@RequestParam("id") int id) {
		int count = bookingBO.deleteBooking(id);

		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
		}
	
	@GetMapping("/add_booking")
	@ResponseBody
	public Map<String, String> addBooking(
			@RequestParam("name") String name
			, @RequestParam("date") String date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> result = new HashMap<>();
	
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
	
	@GetMapping("/bookinglistview")
	public String bookingListView() {
		return "lesson06/bookingList";
	}
	
	@GetMapping("/add_booking_view")
	public String addBookingView() {
		return "lesson06/addBooking";
	}
	
	@GetMapping("/check_booking_view")
	public String checkBookingView() {
		return "lesson06/checkBooking";
	}
}
