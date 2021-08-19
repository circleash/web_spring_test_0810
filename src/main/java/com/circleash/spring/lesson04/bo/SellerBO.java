package com.circleash.spring.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circleash.spring.lesson04.dao.SellerDAO;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	public int addSeller(String nickname, String profileImageUrl, double temperature) {
		return sellerDAO.insertSeller(nickname, profileImageUrl, temperature);
	}

}
