package com.paul9537.test.lesson05;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paul9537.test.lesson05.bo.WeatherBO;
import com.paul9537.test.lesson05.model.WeatherHistory;

@Controller
@RequestMapping("/lesson05")
public class WeatherController {
	
	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/test05")
	public String test05(Model model) {
		
		List<WeatherHistory> weather = weatherBO.getWeather();
		
		model.addAttribute("weather", weather);
		
		return "lesson05/test05/test05";
	}
	
	
	@GetMapping("/test05_input")
	public String test05_input() {
		
		
		return "lesson05/test05/test05_input";
	}
	
	@GetMapping("/add_weather")
	public String addWeather(
			@DateTimeFormat(pattern="yyyy-MM-dd")
			@RequestParam("date") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
		
		int count = weatherBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		// redirect
		return "redirect:/lesson05/test05";
	}
	

	
	
}
