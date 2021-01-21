package com.web.stock.service;

import javax.servlet.http.HttpServletResponse;

public interface ChangeService {
    public Integer changeUserInfoService(String username,String sex,String address,Integer age,String introduction);//修改用户信息
    public Integer changePassordService(String password,String oldpassword,HttpServletResponse response);//修改密码 
    public Integer addUserPropertyService(String username,double property);//添加用户资产
    public Integer subUserPropertyService(String username,double property);//减少用户资产
    public Integer resetUserPassword(String username,String password);//重置密码
    public Integer deletuser(String username);//根据用户名删除用户
    public Integer changeroleid(String username,Integer roleid);//修改权限
}