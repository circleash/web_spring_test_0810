package com.circleash.spring.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.circleash.spring.lesson03.bo.RealestateBO;
import com.circleash.spring.lesson03.model.Realestate;

@RequestMapping("/lesson03")
@Controller
public class realestateController {
		//Controller에서 BO호출, SPRING에게 관리 위임 --> Autowired
		@Autowired
		private RealestateBO realestateBO;
		
		@RequestMapping("/test01/1")
		@ResponseBody
		public Realestate test01(
				//해당하는 변수가 id에 저장
				@RequestParam("id") int id) {
			return realestateBO.getRealestate(id);
	}
		@RequestMapping("/test01/2")
		@ResponseBody
		public List<Realestate> test01_2(@RequestParam("rent") int rent) {
			return realestateBO.getRealEstateByRentPrice(rent);
		}
		
//		아래 두 parameter를 받고 매매 매물 중 조건에 모두 부합하는 매물 정보를 아래와 같이 json으로 출력하세요.
//		넓이(area) - 매물의 넓이가 전달 받은 넓이 이상인 것
//		가격(price) - 매물의 매매금이 전달받은 매매금 보다 이하인 것
		@RequestMapping("/test01/3")
		@ResponseBody
		public List<Realestate> test01_3(@RequestParam("area") int area, 
				@RequestParam("price") int price) {
			return realestateBO.getRealEstateByAreaPrice(area, price);
		}
//		객체로 insert 하기
		@RequestMapping("/test02/1")
		@ResponseBody
		public String test02_1() {
			Realestate realestate = new Realestate();
			realestate.setRealtorId(3);
			realestate.setAddress("푸르지용 리버 303동 1104호");
			realestate.setArea(89);
			realestate.setType("매매");
			realestate.setPrice(100000);
			int count = realestateBO.addRealestateAsObject(realestate);
			return "입력 결과 : " + count;
		}
		
		@RequestMapping("/test02/2")
		@ResponseBody
		public String test02_2(
				@RequestParam("realtorId") int realtorId
				) {
//			address : 썅떼빌리버 오피스텔 814호
//			area : 45
//			type : 월세
//			price : 100000
//			rentPrice : 120
			
			int count = realestateBO.addRealestate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
			return "입력 결과 : " + count;
			
		}
		
		@RequestMapping("/test03")
		@ResponseBody
		public String test03(
				@RequestParam("id") int id
				, @RequestParam("type") String type
				, @RequestParam("price") int price
				) {
				int count = realestateBO.updateRealEstateById(id, type, price);
				return "업데이트 성공 : " + count;
	}
		@RequestMapping("/test04")
		@ResponseBody
		public String test04(
				@RequestParam("id") int id) {
				int count = realestateBO.deleteRealEstateById(id);
				return "삭제 개수 : " + count;
			
		}
}