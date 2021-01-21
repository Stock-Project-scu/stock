package com.web.stock.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.stock.bean.UserProperty;
import com.web.stock.bean.UserRole;
import com.web.stock.service.ChangeService;
import com.web.stock.service.StockOrderService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.UserRoleService;
import com.web.stock.service.UserStockService;
import com.web.stock.service.Userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 代相廷 个人信息修改控制器
 */
@Controller
@RequestMapping("/change")
public class ChangeController {
    @Autowired
    ChangeService changeservice;// 引入修改服务
    @Autowired
    UserRoleService userroleservice;
    @Autowired
    HttpSession session;
    Logger logger = LoggerFactory.getLogger(ChangeController.class);

    // 修改用户信息
    @PostMapping("/userinfo")
    @ResponseBody
    public Integer changeUserInfo(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "sex", required = true) String sex,
            @RequestParam(value = "address", required = true) String address,
            @RequestParam(value = "age", required = true) Integer age,
            @RequestParam(value = "introduction", required = true) String introduction) {
        return changeservice.changeUserInfoService(username, sex, address, age, introduction);
    }

    // 修改密码
    @PostMapping("/password")
    @ResponseBody
    public Integer changePassord(@RequestParam(value = "repwd", required = true) String password,
            @RequestParam(value = "oldpwd", required = true) String oldpassword, HttpServletResponse response) {
        return changeservice.changePassordService(password, oldpassword, response);
    }

    // 添加资产
    @PostMapping("/addMoney")
    @ResponseBody
    public Integer addMoney(@RequestParam(value = "money", required = true) double money) {
        logger.info("进入修改资产,增加金额={}", money);
        String username = session.getAttribute("username").toString();
        return changeservice.addUserPropertyService(username, money);
    }

    @PostMapping("/withdrawMoney")
    @ResponseBody
    public Integer withdrawMoney(@RequestParam(value = "money", required = true) double money) {
        logger.info("进入修改资产,减少金额={}", money);
        String username = session.getAttribute("username").toString();
        return changeservice.subUserPropertyService(username, money);
    }

    @PostMapping("/resetPwd")
    @ResponseBody
    public Integer resetPwd(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password) {
        String usernamenow = session.getAttribute("username").toString();
        if (userroleservice.getUserRoleIdbyname(usernamenow) == 0) {
            logger.info("管理员重置密码");
            return changeservice.resetUserPassword(username, password);
        }
        else{
            logger.info("权限不够");
            return 0;
        }
    }

    @PostMapping("/deletuser")
    @ResponseBody
    public Integer deletUser(@RequestParam(value = "username", required = true) String username) {
        logger.info("删除用户={}", username);
        try {
            return changeservice.deletuser(username);
        } catch (Exception e) {
            logger.error("删除失败", e);
            return 0;
        }
    }
    @PostMapping("/roleid")
    @ResponseBody
    public Integer changeroleid(@RequestParam(value = "username", required = true) String username,
    @RequestParam(value = "roleid", required = true) Integer roleid){
        try {
            return changeservice.changeroleid(username, roleid);
        } catch (Exception e) {
           return 0;
        }

    }
    
    

}