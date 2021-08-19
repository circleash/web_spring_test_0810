package com.circleash.spring.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.circleash.spring.lesson04.bo.SellerBO;

@RequestMapping("/lesson04")
@Controller
public class SellerController {
	
	@Autowired
	private SellerBO sellerBO;
	
	@RequestMapping("/test01/1")
	public String addSellerView() {
		//JSP경로
		return "lesson04/addSeller";
	}

	@PostMapping("/test01/add_seller")
	@ResponseBody
	public String addSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImageUrl") String profileImageUrl
			, @RequestParam("temperature") double temperature
			) {
		int count = sellerBO.addSeller(nickname, profileImageUrl, temperature);
		return "입력성공: " + count;
	}
}
