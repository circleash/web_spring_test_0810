package com.circleash.spring.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.circleash.spring.lesson04.bo.SellerBO;
import com.circleash.spring.lesson04.model.Seller;

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
	
	@GetMapping("/test01/2")
	// jsp에 전달해야하기때문에 model 추가
	public String lastUser(
			//필수가 아닌형태
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		Seller seller = null;
		if(id == null) {
			seller = sellerBO.getLastUser();
		} else {
			seller = sellerBO.getSeller(id);
		}
		
		//2번문제 주석처리
//		Seller seller = sellerBO.getLastUser();
		model.addAttribute("result", seller);
		model.addAttribute("subject", "판매자 정보");
		return "lesson04/seller_info";
	}
}
