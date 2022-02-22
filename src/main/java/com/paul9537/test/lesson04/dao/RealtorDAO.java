package com.paul9537.test.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.paul9537.test.lesson04.model.Realtor;

@Repository
public interface RealtorDAO {
	
	public int insertRealtor(Realtor realtor);
}
