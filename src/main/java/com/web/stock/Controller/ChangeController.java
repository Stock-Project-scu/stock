package com.web.stock.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.stock.bean.User;
import com.web.stock.service.Userservice;

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
    private Userservice userservice;// 创建一个userservice
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
        try {
            User u1 = userservice.getUserByName(username);
            Integer id = u1.getId();
            userservice.setSexbyId(id, sex);
            logger.info("修改sex={}", sex);
            userservice.setAddressbyId(id, address);
            logger.info("修改address={}", address);
            userservice.setAgebyId(id, age);
            logger.info("修改age={}", age);
            userservice.setIntroductionbyId(id, introduction);
            logger.info("修改introduction={}",introduction);

        } catch (Exception e) {
            // TODO: handle exception
            logger.error("出现错误", e);
            return 0;
        }
        return 1;
    }

    // 修改密码
    @RequestMapping("/password")
    @ResponseBody
    public Integer changePassord(@RequestParam(value = "repwd", required = true) String password,HttpServletResponse response) {
        try {
            logger.info("用户 {} 进入密码修改", session.getAttribute("username"));
            logger.info("开始密码修改");
            // User u1 =
            // userservice.getUserByName(session.getAttribute("username").toString());
            logger.info("用户密码要修改的{}", password);
            Integer id = userservice.findIdbyUserName(session.getAttribute("username").toString());

            logger.info("用户ID={}", id.toString());
            userservice.setPassowrdbyId(id, password);
            //修改成功之后注销
            logger.info("修改成功，关闭session和cookie");
            Cookie cookie = new Cookie("username", null);
            // 将`Max-Age`设置为0
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            session.removeAttribute("username");// 删除session
            return 1;
        } catch (Exception e) {
            logger.error("有错误", e);
            // TODO: handle exception
            return 3;
        }
    }
}