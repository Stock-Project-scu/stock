package com.web.stock.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.web.stock.bean.StockOrder;
import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
import com.web.stock.bean.UserStock;
import com.web.stock.service.GetDataService;
import com.web.stock.service.StockOrderService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.UserStockService;
import com.web.stock.service.Userservice;
import com.web.stock.service.myHttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("GetDataService")
@Slf4j
public class GetDataServiceImpl implements GetDataService {
    @Autowired
    private Userservice userservice;// 创建一个userservice

    @Autowired
    GetDataService getdataservice;
    @Autowired
    HttpSession session;
    @Autowired
    UserPropertyService userpropertyservice;

    // log log = logFactory.getlog(GetDataService.class);

    // 获取用户信息
    @Override
    public User getuserinfo(String username) {
        return userservice.getUserByName(username);
    }

    // 获取资产
    @Override
    public UserProperty getuserproperty(String username) {
        try {
            return userpropertyservice.getUserPropertyByName(username);
        } catch (Exception e) {

            log.info("获取失败");
            log.error("错误为=", e);
            return null;
        }
    }

    @Override
    public List<User> getuserinfoall() {
        log.info("全部用户信息获取");
        try {
            return userservice.getAlluser();
        } catch (Exception e) {
            log.error("获取出错了", e);
            return null;
        }

    }

    @Override
    public List<UserProperty> getuserpropertyall() {
        log.info("全部用户资产获取");
        try {
            return userpropertyservice.getUserPropertyAll();
        } catch (Exception e) {
            log.error("获取出错了", e);
            return null;
        }
    }

    @Autowired
    myHttpClient httpclient;

    @Override
    public Map<String, String> getstockcurrentprice(String StockId) {

        try {
            String url = "http://hq.sinajs.cn/list=";
            url = url + StockId;
            log.info("stockid={}", url);
            HttpMethod method = HttpMethod.GET;
            String data = httpclient.client(url, method);
            String[] res = data.split("=");
            String d1 = res[1];
            String[] res2 = d1.split("\"");
            String d2 = res2[1];
            String[] res3 = d2.split(",");
            Map<String, String> map = new LinkedHashMap<>();
            log.info("数组溢出？size res3={}", res3.length);
            map.put("stockName", res3[0]);
            map.put("openPrice", res3[1]);
            map.put("closePrice", res3[2]);
            map.put("currentPrice", res3[3]);
            map.put("maxPrice", res3[4]);
            map.put("minPrice", res3[5]);
            map.put("buyOnePrice", res3[6]);
            map.put("sellOnePrice", res3[7]);
            map.put("dealCount", res3[8]);
            map.put("dealValue", res3[9]);
            map.put("buyOneCount", res3[10]);
            map.put("sellOneCount", res3[20]);
            return map;
        } catch (Exception e) {
            log.error("错误信息", e);
            return null;
        }
    }
    @Autowired
    UserStockService userstockservice;

    @Override
    public List<UserStock> getuserstock(String username) {
        try {
            log.info("获取用户持有的股票");
            return userstockservice.getUserAllStockbyName(username);
        } catch (Exception e) {
            log.error("出错getdataservice", e);
            return null;
        }
    }
    @Autowired
    StockOrderService stockorderservice;

    @Override
    public List<StockOrder> getuserstockorder(String username) {
        try {
            log.info("获取用户订单记录");
            return stockorderservice.getUserStockOrderbyUsername(username);
        } catch (Exception e) {
            log.error("出错getdataservice", e);
            return null;
        }
    }

}