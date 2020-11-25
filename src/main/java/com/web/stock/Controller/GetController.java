package com.web.stock.Controller;

import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
import com.web.stock.service.ChangeService;
import com.web.stock.service.GetDataService;
import com.web.stock.service.Userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/getdata")
public class GetController {
    @Autowired
    GetDataService getdataservice;
    
    @RequestMapping("/userinfo")
    @ResponseBody
    public User getUserInfo(@RequestParam(value = "username", required = true) String username){
        return getdataservice.getuserinfo(username);
    }

    @RequestMapping("/property")
    @ResponseBody
    public double getUserProperty(@RequestParam(value = "username", required = true) String username){
        return getdataservice.getuserproperty(username).getProperty();
    }
}