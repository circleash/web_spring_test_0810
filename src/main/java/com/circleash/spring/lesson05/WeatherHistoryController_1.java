package com.circleash.spring.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.circleash.spring.lesson05.bo.WeatherHistoryBO_1;
import com.circleash.spring.lesson05.model.Weather;

@RequestMapping("/lesson05/test05")
@Controller
public class WeatherHistoryController_1 {
	
	@Autowired
	private WeatherHistoryBO_1 weatherHistoryBO_1;
	
	@GetMapping("/weather_history_1")
	public String test05_1(Model model) {
		
		List<Weather> weather = weatherHistoryBO_1.getWeatherHistory();
		
		model.addAttribute("weather", weather);
		return "lesson05/weatherhistory_1";
	}
	
	@GetMapping("/add_weather_view_1")
	public String addWeatherView_1() {
		return "lesson05/addWeather_1";
	}
	
	@PostMapping("/addWeather_1")
	public String addWeather_1(
			@RequestParam("date") String date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed) {
		weatherHistoryBO_1.addWeatherHistory_1(date, weather, temperatures, precipitation, microDust, windSpeed);
		return "redirect:/lesson05/test05/weather_history_1";
	}


}
