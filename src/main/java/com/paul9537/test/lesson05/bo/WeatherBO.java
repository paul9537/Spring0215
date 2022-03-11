package com.paul9537.test.lesson05.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paul9537.test.lesson05.dao.WeatherDAO;
import com.paul9537.test.lesson05.model.WeatherHistory;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	public List<WeatherHistory> getWeather() {
		return weatherDAO.selectWeather();
	}
	
	public int addWeather(Date date,
			String weather,
			double temperatures,
			double precipitation,
			String microDust,
			double windSpeed) {
		
		return weatherDAO.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
