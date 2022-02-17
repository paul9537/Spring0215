package com.paul9537.test.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paul9537.test.lesson02.model.Store;

@Repository
public interface StoreDAO {
	
	public List<Store> selectStoreList();
}
