package com.web.stock.Controller;

import com.web.stock.bean.User;
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
    private Userservice userservice;// 创建一个userservice
    Logger logger =LoggerFactory.getLogger(GetController.class);

    @RequestMapping("/userinfo")
    @ResponseBody
    public User getuserinfo(@RequestParam(value = "username", required = true) String username){
        logger.info("进入信息获取");
        try {
            User u1 = userservice.getUserByName(username);
            logger.info("用户信息={}", u1.toString());
            return u1;
        } catch (Exception e) {
            //TODO: handle exception
            logger.error("获取错误={}",e);
            return null;
        }
        
    }
}