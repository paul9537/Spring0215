package com.paul9537.test.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paul9537.test.lesson02.bo.StoreBO;
import com.paul9537.test.lesson02.model.Store;

@Controller
public class StoreController {
	
	@Autowired
	private StoreBO storeBO;
	
	@RequestMapping("/lesson02/test01")
	@ResponseBody
	public List<Store> storeView() {
		List<Store> storeList = storeBO.getStoreList();
		return storeList;
	}
	
	
}
