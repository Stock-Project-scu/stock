package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.User;
/**
 * @author 代相廷
 * service接口
 */
public interface Userservice {
    User getUserByname(String username);
    List<User> getAlluser();
    User getUserByemail(String email);
    boolean insertUser(User user);//注册用户
}
