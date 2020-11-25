package com.web.stock.service;

import javax.servlet.http.HttpServletResponse;

public interface ChangeService {
    public Integer changeUserInfoService(String username,String sex,String address,Integer age,String introduction);//修改用户信息
    public Integer changePassordService(String password,String oldpassword,HttpServletResponse response);//修改密码 
    public Integer addUserPropertyService(String username,double property);
}