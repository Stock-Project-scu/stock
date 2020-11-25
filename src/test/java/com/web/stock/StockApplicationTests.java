package com.web.stock;

import java.util.List;
import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
import com.web.stock.mapper.UserPropertyMapper;
import com.web.stock.service.ChangeService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.Userservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockApplicationTests {
	@Autowired 
	private Userservice userservice;//创建一个userservice
	@Autowired
	UserPropertyService us;
	@Autowired
	ChangeService cs;
	@Autowired 
	UserPropertyMapper um;
	@Test
	void test_mybatis_mapper(){
		// List<User> lu1 = userservice.getAlluser();
		// System.out.println(lu1.size());
		// UserProperty up = us.getUserPropertyById(1);
		// System.out.println(up.toString());
		// //up.setProperty(10000);
		// us.updateUserPropertyById(1, 10000);
		// UserProperty up1 = us.getUserPropertyById(1);
		// System.out.println(up1.toString());
		// System.out.println(us.insertUserProperty("xxx"));
		//System.out.println(um.update(entity, updateWrapper));
		
		
	}


}
