package com.circleash.spring.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.circleash.spring.lesson03.bo.RealestateBO;
import com.circleash.spring.lesson03.model.Realestate;

@Controller
public class realestateController {
		
		@Autowired
		private RealestateBO realestateBO;
		
		@RequestMapping("/lesson03/test01")
		@ResponseBody
		public Realestate test01(
				@RequestParam("id") int id) {
			return realestateBO.getRealestate(id);
	}

}
