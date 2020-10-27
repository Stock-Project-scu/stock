package com.web.stock;

import java.util.List;

import com.web.stock.bean.User;
import com.web.stock.service.Userservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockApplicationTests {
	@Autowired 
    private Userservice userservice;//创建一个userservice
	@Test
	void mytest() throws Exception{
		List<User> userList=userservice.getAlluser();
		assert userList.size()==0;
		for (User iUser : userList) {
			System.out.println(iUser.toString());
		}
	}

	// @Autowired 
    // private Userservice userservice;//创建一个userservice
	// @Test
	// void mytest(User user = new User("13543265@qq.com","sf","123456"))throws Exception{
		
	// 	userservice.signUser(user);
	// }
}
