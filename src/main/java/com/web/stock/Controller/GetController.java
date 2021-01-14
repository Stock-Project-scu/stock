package com.web.stock.Controller;

import java.util.List;
import java.util.Map;

import com.web.stock.bean.Marketinfo;
import com.web.stock.bean.Stock;
import com.web.stock.bean.StockOrder;
import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
import com.web.stock.bean.UserStock;
import com.web.stock.service.GetDataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/getdata")
public class GetController {
    @Autowired
    GetDataService getdataservice;

    Logger logger = LoggerFactory.getLogger(GetController.class);
    
    //获取用户信息
    @PostMapping("/userinfo")
    @ResponseBody
    public User getUserInfo(@RequestParam(value = "username", required = true) String username){
        return getdataservice.getuserinfo(username);
    }

    //获取用户资产
    @PostMapping("/property")
    @ResponseBody
    public double getUserProperty(@RequestParam(value = "username", required = true) String username){
        return getdataservice.getuserproperty(username).getProperty();
    }

    //获取用户持有的股票
    @GetMapping("/userstock")
    @ResponseBody
    public List<UserStock> getUserStock(@RequestParam(value = "username", required = true) String username){
        return getdataservice.getuserstock(username);
    }

    //获取用户订单记录
    @GetMapping("/userstockorder")
    @ResponseBody
    public List<StockOrder> getuserstockorder(@RequestParam(value = "username", required = true) String username){
        return getdataservice.getuserstockorder(username);
    }

    //获取所有用户信息
    @PostMapping("/userinfoall")
    @ResponseBody
    public List<User> getUserInfoAll(){
        return getdataservice.getuserinfoall();
    }
    //获取所有用户的资产 //无用
    @PostMapping("/propertyall")
    @ResponseBody
    public List<UserProperty> getUserPropertyAll(){
        return getdataservice.getuserpropertyall();
    }
    //获取股票信息
    @PostMapping("/stockInfo")
    @ResponseBody
    public Map<String,String> getStockCurrentPrice(@RequestParam(value = "stockid", required = true) String stockid){
        return getdataservice.getstockcurrentprice(stockid);
    }
    @GetMapping("/news")
    @ResponseBody
    public String getNewsbyPage(@RequestParam(value = "page", required = true )Integer page){
        return getdataservice.getnews(page);
    }
    @GetMapping("/marketInfo")
    @ResponseBody
    public Marketinfo getMarketInfo(@RequestParam(value = "stockid", required = true) String stockid){
        return getdataservice.getmarketinfo(stockid);
    }
    
}