package com.paul9537.test.lesson1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paul9537.test.lesson1.model.UserInfo;

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
	
	@RequestMapping("/3")
	public List<Map<String, Object>> printList() {
		List<Map<String, Object>> movieList = new ArrayList<>();
		Map<String, Object> movie1 = new HashMap<>();
		movie1.put("rate", 15);
		movie1.put("director", "봉준호");
		movie1.put("time", 131);
		movie1.put("title", "기생충");
		movieList.add(movie1);
		
		Map<String, Object> movie2 = new HashMap<>();
		movie2.put("rate", 0);
		movie2.put("director", "로베르토 베니니");
		movie2.put("time", 166);
		movie2.put("title", "인생은 아름다워");
		movieList.add(movie2);
		
		Map<String, Object> movie3 = new HashMap<>();
		movie3.put("rate", 12);
		movie3.put("director", "크리스토퍼 놀란");
		movie3.put("time", 147);
		movie3.put("title", "인셉션");
		movieList.add(movie3);
		
		Map<String, Object> movie4 = new HashMap<>();
		movie4.put("rate", 19);
		movie4.put("director", "윤종빈");
		movie4.put("time", 133);
		movie4.put("title", "범죄와의 전쟁 : 나쁜놈들의 전성시대");
		movieList.add(movie4);
		
		Map<String, Object> movie5 = new HashMap<>();
		movie5.put("rate", 15);
		movie5.put("director", "프란시스 로렌스");
		movie5.put("time", 137);
		movie5.put("title", "헝거게임");
		movieList.add(movie5);
		
		return movieList;
	}
	
	@RequestMapping("/4")
	public List<UserInfo> printListObject() {
		
		List<UserInfo> list = new ArrayList<>();
		
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setTitle("안녕하세요 가입인사 드립니다.");
		userInfo1.setUser("hagulu");
		userInfo1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		list.add(userInfo1);
		
		UserInfo userInfo2 = new UserInfo();
		userInfo2.setTitle("헐 대박");
		userInfo2.setUser("bada");
		userInfo2.setContent("오늘 목요일이 었어... 금요일인줄");
		list.add(userInfo2);
		
		UserInfo userInfo3 = new UserInfo();
		userInfo3.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		userInfo3.setUser("dulumary");
		userInfo3.setContent("....");
		list.add(userInfo3);
		
		return list;
	}
	
	@RequestMapping("/5")
	public ResponseEntity<UserInfo> entity() {
		
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setTitle("안녕하세요 가입인사 드립니다.");
		userInfo1.setUser("hagulu");
		userInfo1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		
		ResponseEntity<UserInfo> entity = new ResponseEntity<>(userInfo1, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
