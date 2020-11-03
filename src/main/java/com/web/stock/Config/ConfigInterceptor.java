package com.web.stock.Config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 定义拦截器
 */
@Component
//@Log4j
public class ConfigInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        // 从session中获取用户信息
        //session暂时没有设置其他两项
        
        String username = (String)session.getAttribute("username");
        Logger logger =LoggerFactory.getLogger(ConfigInterceptor.class);
        //session过期
        if (username == null) {
            logger.info(">>>session过期, 跳至登录页");
            response.sendRedirect("/gotologin"); // 通过接口跳转登录页面, 注:重定向后下边的代码还会执行 ; /outToLogin是跳至登录页的后台接口
            return false;
        }else{
        	return true;
        }
        
    }
}
