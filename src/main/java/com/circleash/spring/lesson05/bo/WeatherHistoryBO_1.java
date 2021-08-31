package com.circleash.spring.lesson05.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circleash.spring.lesson05.dao.WeatherHistoryDAO_1;
import com.circleash.spring.lesson05.model.Weather;


	@Service
	public class WeatherHistoryBO_1 {

		@Autowired
		private WeatherHistoryDAO_1 weatherHistoryDAO_1;
		
		public List<Weather> getWeatherHistory() {
			return weatherHistoryDAO_1.selectWeatherHistory_1();
		}
		public int addWeatherHistory_1(
				String date,
				String weather,
				double temperatures,
				double precipitation,
				String microDust,
				double windSpeed) {
			return weatherHistoryDAO_1.insertWeather_1(date, weather, temperatures, precipitation, microDust, windSpeed);
		}
	}
