package com.paul9537.test.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paul9537.test.lesson06.dao.FavoritesDAO;
import com.paul9537.test.lesson06.model.Favorites;

@Service
public class FavoritesBO {
	
	@Autowired
	private FavoritesDAO favoritesDAO;
	
	public int addFavorites(String name, String url) {
		return favoritesDAO.insertFavorites(name, url);
	}
	
	public List<Favorites> getFavorites() {
		return favoritesDAO.selectFavorites();
	}
	
	public boolean checkDuplicate(String url) {
		int count = favoritesDAO.selectUrlCount(url);
		
		return (count != 0);
	}
	
	public int deleteFavorite(int id) {
		return favoritesDAO.deleteFavorite(id);
	}
}
