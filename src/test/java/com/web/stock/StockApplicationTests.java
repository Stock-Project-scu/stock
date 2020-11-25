package com.web.stock;

import java.util.List;
import com.web.stock.bean.User;
import com.web.stock.service.Userservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockApplicationTests {
	@Autowired 
	private Userservice userservice;//创建一个userservice


	@Test
	void test_mybatis_mapper(){
		List<User> lu1 = userservice.getAlluser();
		System.out.println(lu1.size());
		
	}


}
