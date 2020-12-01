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
		// Map m1 = new HashMap<>();
		// m1.put("名字", "贵州茅台");
		// m1.put("编号", 650001);
		// System.out.println(m1.get("名字"));
		// System.out.println(m1.get("编号"));
		Map<String,String> m1 = gd.getstockcurrentprice(601006);
		m1.forEach((key,value)->{
			System.out.println(key+":"+value);
		});
		
	}


}
