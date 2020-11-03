package com.web.stock.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@CrossOrigin
public class MainController {
    @Autowired
    HttpSession session;

    @RequestMapping("/test")
    public String test(){
        return "/pages/login";
    }
    @RequestMapping("/gotoregister")
    public String gotoregister(){
        
        return "/pages/register";
    }
    @RequestMapping("/index")
    public String gotoindex(){
        return "/index";
    }
}
