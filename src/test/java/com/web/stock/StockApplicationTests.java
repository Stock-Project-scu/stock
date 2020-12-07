package com.web.stock;

import java.util.Date;

import java.util.List;


import com.web.stock.bean.StockOrder;
import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
import com.web.stock.mapper.StockOrderMapper;
//import com.web.stock.mapper.UserPropertyMapper;
import com.web.stock.service.ChangeService;
import com.web.stock.service.EmailService;
import com.web.stock.service.GetDataService;
import com.web.stock.service.LoginService;
import com.web.stock.service.StockOrderService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.UserStockService;
import com.web.stock.service.Userservice;
import com.web.stock.service.myHttpClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
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
	@Autowired
	StockOrderService orderservice;
	// @Test
	// void test_client(){
	// 	System.out.println("insert="+uss.insertUserStock("ddd", "sh65001"));
	// 	System.out.println("select="+uss.getUserStockbyNameId("ddd", "sh65001"));
	// 	System.out.println("select错误返回="+uss.getUserStockbyNameId("ddd", "sh65000"));
		
	// 	//System.out.println("update="+uss.updateUserStock("ddd", "sh65001",4753));

	// 	//System.out.println("update错误时="+uss.updateUserStockbyNameId("ddd", "sh65000",4753));

	// 	System.out.println("delet错误时="+uss.deletUserStock("ddd1", "sh65001"));
	// 	System.out.println("dele成功"+uss.deletUserStock("ddd", "sh65001"));
		
	// }
	// @Autowired
	// StockOrderMapper om;
	// @Test
	
	// void test_order(){
	// 	StockOrder order = new StockOrder();
	// 	order.setStockcheck(1);
	// 	order.setCurrentprice(256.00);
	// 	order.setNumber(50);
	// 	order.setStockid("sh60051");
	// 	order.setStockname("茅台");
	// 	order.setUsername("ddd");
	// 	Date d = new Date();
	// 	log.info("time:{}",d.toString());
	// 	order.setOrdertime(d.toString());
	// 	log.info("insert:{}",order.toString());
	// 	orderservice.insertbyUsernameId(order);
	// 	List<StockOrder>solist=orderservice.getAllStockOrder();
	// 	solist.forEach( value -> {System.out.println(value.toString());});
	// 	System.out.println("插入成功:");
	// }


}
