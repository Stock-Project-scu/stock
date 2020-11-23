package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.User;
/**
 * @author 代相廷
 * service接口
 */
public interface Userservice {
    User getUserByName(String username);
    List<User> getAlluser();
    User getUserByemail(String email);
    boolean insertUser(User user);//注册用户
    //Integer getIdbyName(String username); //直接获取id
    Integer setSexbyId(Integer id,String sex);//修改性别
    Integer setAddressbyId(Integer id,String address);//修改住址
    Integer setEmailbyId(Integer id,String email);                 //更改邮箱
    Integer setUsernamebyId(Integer id,String username);            //修改用户名（慎用）
    Integer findIdbyUserName(String username);//根据用户名返回id
    Integer setPassowrdbyId(Integer id,String password); //修改密码 
    Integer setAgebyId(Integer id,Integer age);//修改年龄
    Integer setIntroductionbyId(Integer id,String introduction);//修改简介
}
