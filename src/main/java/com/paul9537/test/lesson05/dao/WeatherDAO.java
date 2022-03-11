package com.paul9537.test.lesson05.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.paul9537.test.lesson05.model.WeatherHistory;

@Repository
public interface WeatherDAO {
	
	public List<WeatherHistory> selectWeather();
	
	public int insertWeather(
			@Param("date") Date date,
			@Param("weather") String weather,
			@Param("temperatures") double temperatures,
			@Param("precipitation") double precipitation,
			@Param("microDust") String microDust,
			@Param("windSpeed") double windSpeed);
}
