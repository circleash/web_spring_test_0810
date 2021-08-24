package com.circleash.spring.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circleash.spring.lesson04.dao.SellerDAO;
import com.circleash.spring.lesson04.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	public int addSeller(String nickname, String profileImageUrl, double temperature) {
		return sellerDAO.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	public Seller getLastUser() {
		return sellerDAO.selectLastUser();
	}
	
	public Seller getSeller(int id) {
		return sellerDAO.selectSeller(id);
	}

}
