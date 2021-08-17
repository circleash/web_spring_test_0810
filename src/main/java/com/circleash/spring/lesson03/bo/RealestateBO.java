package com.circleash.spring.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circleash.spring.lesson03.dao.RealestateDAO;
import com.circleash.spring.lesson03.model.Realestate;

@Service
public class RealestateBO {
	//BO 에서 DAO를 호출하기위해 Autowired사용
	@Autowired
	private RealestateDAO realestateDAO;
	//id를 같이 넘겨줌
	public Realestate getRealestate(int id) {
		//Spring이 알아서 객체관리
		return realestateDAO.selectRealestate(id);
	}
	
	public List<Realestate> getRealEstateByRentPrice(int rent) {
		return realestateDAO.selectRealEstateByRentPrice(rent);
		
	}
	
	public List<Realestate> getRealEstateByAreaPrice(int area, int price) {
		return realestateDAO.selectRealEstateByAreaPrice(area, price);
	}

}
