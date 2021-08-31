package com.circleash.spring.lesson05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.circleash.spring.lesson05.model.Weather;

@Repository
public interface WeatherHistoryDAO_1 {
	
	public List<Weather> selectWeatherHistory_1();
	public int insertWeather_1(
			@Param("date") String date,
			@Param("weather") String weather,
			@Param("temperatures") double temperatures,
			@Param("precipitation") double precipitation,
			@Param("microDust") String microDust,
			@Param("windSpeed") double windSpeed);
}

