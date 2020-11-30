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
	// @Test
	// void test_mybatis_mapper() throws Exception {
	// 	User user = new User();
	// 	user.setEmail("1196154768@qq.com");
	// 	user.setPassword("123456");
	// 	user.setUsername("zdy");
	// 	loginservice.signservice(user);
	// 	//es.sendEmail("<br>换行<br>测试", "1097249217@qq.com");
	// }
	@Autowired
	myHttpClient httpclient;
	@Test
	void test_client(){
		String url = "http://hq.sinajs.cn/list=sh601006";
		HttpMethod method = HttpMethod.GET;
		String data = httpclient.client(url, method);
		String [] res = data.split("=");
		String d1 = res[1];
		String []res2=d1.split("\"");
		String d2 = res2[1];
		String []res3 = d2.split(",");
		String d3 = res3[3];
		System.out.println(d3);
	}


}
