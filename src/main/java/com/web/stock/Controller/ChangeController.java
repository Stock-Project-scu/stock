package com.web.stock.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.stock.service.ChangeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 代相廷 个人信息修改控制器
 */
@Controller
@RequestMapping("/change")
public class ChangeController {
    @Autowired
    ChangeService changeservice;//引入修改服务
    @Autowired
    HttpSession session;
    Logger logger = LoggerFactory.getLogger(ChangeController.class);
    // 修改用户信息
    @RequestMapping("/userinfo")
    @ResponseBody
    public Integer changeUserInfo(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "sex", required = true) String sex,
            @RequestParam(value = "address", required = true) String address,
            @RequestParam(value = "age", required = true) Integer age,
            @RequestParam(value = "introduction", required = true) String introduction) {
        return changeservice.changeUserInfoService(username, sex, address, age, introduction);
    }

    // 修改密码
    @RequestMapping("/password")
    @ResponseBody
    public Integer changePassord(@RequestParam(value = "repwd", required = true) String password,
    @RequestParam(value = "oldpwd", required = true) String oldpassword,HttpServletResponse response) {
        return changeservice.changePassordService(password, oldpassword, response);
    }
    //添加资产
    @RequestMapping("/addMoney")
    @ResponseBody
    public Integer addMoney(
    @RequestParam(value = "money", required = true) double money){
        logger.info("进入修改资产,增加金额={}",money);
        String username = session.getAttribute("username").toString();
        return changeservice.addUserPropertyService(username, money);
    }
    @RequestMapping("/withdrawMoney")
    @ResponseBody
    public Integer withdrawMoney(
    @RequestParam(value = "money", required = true) double money){
        logger.info("进入修改资产,减少金额={}",money);
        String username = session.getAttribute("username").toString();
        return changeservice.subUserPropertyService(username, money);
    }
}