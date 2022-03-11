package com.paul9537.test.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paul9537.test.lesson06.bo.FavoritesBO;
import com.paul9537.test.lesson06.model.Favorites;

@Controller
@RequestMapping("/lesson06")
public class FavoritesController {
	
	@Autowired
	private FavoritesBO favoritesBO;
	
	@GetMapping("/add_favorites")
	public String add_favorites() {
		
		return "/lesson06/test01/addFavorites";
	}
	
	@PostMapping("/insert_favorites")
	@ResponseBody
	public Map<String, String> insert_favorites(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		int count = favoritesBO.addFavorites(name, url);
		
		// 성공시
		// {"result":"success"}
		
		// 실패시
		// {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/favorites_list")
	public String favorites_list(Model model) {
		
		List<Favorites> favorites = favoritesBO.getFavorites();
		
		model.addAttribute("favorites", favorites);
		
		return "/lesson06/test01/favoritesList";
	}
	
	@PostMapping("/is_duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicate(@RequestParam("url") String url) {
		boolean isDuplicate = favoritesBO.checkDuplicate(url);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		resultMap.put("is_duplicate", isDuplicate);
		
		return resultMap;
	}
	
	@GetMapping("/delete_favorites")
	@ResponseBody
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		int count = favoritesBO.deleteFavorite(id);
		
		// {"result":"success"}
		// {"result":"fail"}
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
}
