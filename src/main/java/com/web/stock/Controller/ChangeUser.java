package com.web.stock.Controller;

import com.web.stock.bean.User;
import com.web.stock.service.Userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 代相廷
 * 个人信息修改控制器
 */
@Controller
@RequestMapping("/change")
public class ChangeUser {
    @Autowired
    private Userservice userservice;// 创建一个userservice
    Logger logger =LoggerFactory.getLogger(LoginController.class);

    //修改用户信息
    @RequestMapping("/userinfo")
    public Integer changeUserInfo(@RequestParam(value = "username", required = true) String username,
                            @RequestParam(value = "sex", required = true) String sex,
                            @RequestParam(value = "address", required = true) String address,
                            @RequestParam(value = "age", required = true) Integer age)
    {
        try {
            User u1 = userservice.getUserByName(username);
            Integer id = u1.getId();
            userservice.setSexbyId(id, sex);
            logger.info("修改sex={}",sex);
            userservice.setAddressbyId(id, address);
            logger.info("修改address={}", address);
            userservice.setAgebyId(id, age);
            logger.info("修改age={}",age);
            
        } catch (Exception e) {
            //TODO: handle exception
            logger.error("出现错误", e);
            return 0;
        }
        
        
        
        return 1;
    }
}