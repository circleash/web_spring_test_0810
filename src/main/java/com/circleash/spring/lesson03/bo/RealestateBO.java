package com.circleash.spring.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circleash.spring.lesson03.dao.RealestateDAO;
import com.circleash.spring.lesson03.model.Realestate;

@Service
public class RealestateBO {
	
	@Autowired
	private RealestateDAO realestateDAO;
	
	public Realestate getRealestate(int id) {
		return realestateDAO.selectRealestate(id);
	}

}
