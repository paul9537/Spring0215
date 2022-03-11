package com.paul9537.test.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.paul9537.test.lesson06.model.Favorites;

@Repository
public interface FavoritesDAO {
	
	public int insertFavorites(
			@Param("name") String name,
			@Param("url") String url);
	
	public List<Favorites> selectFavorites();
	
	public int selectUrlCount(@Param("url") String url);
	
	public int deleteFavorite(@Param("id") int id);
}
