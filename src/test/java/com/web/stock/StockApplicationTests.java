package com.web.stock;

import java.util.List;
import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
//import com.web.stock.mapper.UserPropertyMapper;
import com.web.stock.service.ChangeService;
import com.web.stock.service.EmailService;
import com.web.stock.service.GetDataService;
import com.web.stock.service.LoginService;
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
	EmailService es;
	@Autowired
	LoginService loginservice;
	@Autowired 
	GetDataService gd;
	@Test
	void test_mybatis_mapper() throws Exception {
		User user = new User();
		user.setEmail("1196154768@qq.com");
		user.setPassword("123456");
		user.setUsername("zdy");
		loginservice.signservice(user);
		//es.sendEmail("<br>换行<br>测试", "1097249217@qq.com");
	}


}
