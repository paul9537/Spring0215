package com.paul9537.test.lesson1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson1/test01")
public class Test01 {
	@RequestMapping("/1")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@RequestMapping("/2")
	public Map<String, Integer> printMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어", 85);
		
		return map;
	}
	
}
