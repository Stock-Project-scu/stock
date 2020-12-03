package com.web.stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
//import com.web.stock.mapper.UserPropertyMapper;
import com.web.stock.service.ChangeService;
import com.web.stock.service.EmailService;
import com.web.stock.service.GetDataService;
import com.web.stock.service.LoginService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.UserStockService;
import com.web.stock.service.Userservice;
import com.web.stock.service.myHttpClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;

@SpringBootTest
class StockApplicationTests {
	@Autowired 
	private Userservice userservice;//创建一个userservice
	@Autowired
	EmailService es;
	@Autowired
	LoginService loginservice;
	@Autowired 
	GetDataService gd;
	@Autowired
	UserStockService uss;
	@Autowired
	myHttpClient httpclient;
	@Test
	void test_client(){
		System.out.println("insert="+uss.insertUserStock("ddd", "sh65001"));
		System.out.println("select="+uss.getUserStockbyNameId("ddd", "sh65001"));
		System.out.println("select错误返回="+uss.getUserStockbyNameId("ddd", "sh65000"));
		
		System.out.println("update="+uss.updateUserStockbyNameId("ddd", "sh65001",4753));

		//System.out.println("update错误时="+uss.updateUserStockbyNameId("ddd", "sh65000",4753));

		System.out.println("delet错误时="+uss.deletUserStock("ddd1", "sh65001"));
		System.out.println("dele成功"+uss.deletUserStock("ddd", "sh65001"));
		
	}


}
