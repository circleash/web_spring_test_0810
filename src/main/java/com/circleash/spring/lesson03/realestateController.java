package com.circleash.spring.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.circleash.spring.lesson03.bo.RealestateBO;
import com.circleash.spring.lesson03.model.Realestate;

@RequestMapping("/lesson03/test01")
@Controller
public class realestateController {
		//Controller에서 BO호출, SPRING에게 관리 위임 --> Autowired
		@Autowired
		private RealestateBO realestateBO;
		
		@RequestMapping("/1")
		@ResponseBody
		public Realestate test01(
				//해당하는 변수가 id에 저장
				@RequestParam("id") int id) {
			return realestateBO.getRealestate(id);
	}
		@RequestMapping("/2")
		@ResponseBody
		public List<Realestate> test01_2(@RequestParam("rent") int rent) {
			return realestateBO.getRealEstateByRentPrice(rent);
		}
		
//		아래 두 parameter를 받고 매매 매물 중 조건에 모두 부합하는 매물 정보를 아래와 같이 json으로 출력하세요.
//		넓이(area) - 매물의 넓이가 전달 받은 넓이 이상인 것
//		가격(price) - 매물의 매매금이 전달받은 매매금 보다 이하인 것
		@RequestMapping("/3")
		@ResponseBody
		public List<Realestate> test01_3(@RequestParam("area") int area, 
				@RequestParam("price") int price) {
			return realestateBO.getRealEstateByAreaPrice(area, price);
		}
}