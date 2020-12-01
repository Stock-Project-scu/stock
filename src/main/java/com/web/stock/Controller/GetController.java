package com.web.stock.Controller;

import java.util.List;
import java.util.Map;

import com.web.stock.bean.Stock;
import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;

import com.web.stock.service.GetDataService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    
    @PostMapping("/userinfo")
    @ResponseBody
    public User getUserInfo(@RequestParam(value = "username", required = true) String username){
        return getdataservice.getuserinfo(username);
    }

    @PostMapping("/property")
    @ResponseBody
    public double getUserProperty(@RequestParam(value = "username", required = true) String username){
        return getdataservice.getuserproperty(username).getProperty();
    }
    @PostMapping("/userinfoall")
    @ResponseBody
    public List<User> getUserInfoAll(){
        return getdataservice.getuserinfoall();
    }
    @PostMapping("/propertyall")
    @ResponseBody
    public List<UserProperty> getUserPropertyAll(){
        return getdataservice.getuserpropertyall();
    }

    @PostMapping("/stockInfo")
    @ResponseBody
    public Map<String,String> getStockCurrentPrice(@RequestParam(value = "stockid", required = true) String stockid){
        return getdataservice.getstockcurrentprice(stockid);
    }

}