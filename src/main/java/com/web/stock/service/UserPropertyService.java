package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.UserProperty;

public interface UserPropertyService {
    UserProperty getUserPropertyById(Integer id);
    UserProperty getUserPropertyByName(String username);//通过用户名查找
    List<UserProperty> getUserPropertyAll();
    Integer insertUserProperty(String username);//新增账户，用于账号创建时调用
    Integer updateUserPropertyById(Integer id,double property);//修改值
    Integer deletUserPropertyById(Integer id);//根据id删除用户

}