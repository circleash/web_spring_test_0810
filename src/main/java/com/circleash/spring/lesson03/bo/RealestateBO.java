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

	public int addRealestateAsObject(Realestate realestate) {
		return realestateDAO.insertRealestateAsObject(realestate);
	}
	
	//Method생성
	public int addRealestate(int realtorId, String address, int area, String type, int price, int rentPrice) {
		return realestateDAO.insertRealestate(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstateById(int id, String type, int price) {
		return realestateDAO.updatedRealEstateById(id, type, price);
	}
	
	public int deleteRealEstateById(int id) {
		return realestateDAO.deleteRealEstateById(id);
	}

	
}
