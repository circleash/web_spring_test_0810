package com.circleash.spring.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.circleash.spring.lesson03.model.Realestate;

@Repository
public interface RealestateDAO {
	//method에 대한 정의를 해줌. 얘가 받은 파라미터를 xml에서 사용할 수 있도록 해줌.
	public Realestate selectRealestate(@Param("id") int id);
	
	public List<Realestate> selectRealEstateByRentPrice(@Param("rent") int rent);
	
	public List<Realestate> selectRealEstateByAreaPrice(@Param("area") int area, @Param("price") int price);
	
	public int insertRealestateAsObject(Realestate realestate);
	
	public int insertRealestate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice
			);
	
	public int updatedRealEstateById(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price
			);
	
	public int deleteRealEstateById(@Param("id") int id);
	

}

