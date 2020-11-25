package com.web.stock.service;

import javax.servlet.http.HttpServletResponse;

import com.web.stock.bean.User;

public interface LoginService {
    public String signservice(User user);
    public Integer loginservice(HttpServletResponse response, String username, String passowrd);
    public Integer logoffservice(HttpServletResponse response);
}