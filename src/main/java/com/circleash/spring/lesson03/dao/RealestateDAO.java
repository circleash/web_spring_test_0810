package com.circleash.spring.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.circleash.spring.lesson03.model.Realestate;

@Repository
public interface RealestateDAO {
	
	public Realestate selectRealestate(@Param("id") int id);

}

