package com.web.stock.mapper;

import java.util.List;

import com.web.stock.bean.User;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author 代相廷 mapper接口
 */
@Mapper
public interface UserMapper {
    List<User> findAll();//所有遍历
    User findbyUserName(String username);//根据用户名查找
    User findbyEmail(String email);//根据email查找
    Integer insertUser(User user);//注册用户
    //Integer getIdbyName(String username); //直接获取id
    Integer findIdbyUserName(String username);//根据用户名返回id 
    Integer setSexbyId(Integer id,String sex);                //修改性别
    Integer setAddressbyId(Integer id,String address);             //修改地址
    Integer setEmailbyId(Integer id,String email);                 //更改邮箱
    Integer setUsernamebyId(Integer id,String username);            //修改用户名（慎用）
    Integer setPassowrdbyId(Integer id,String password);            //修改密码（慎用
    Integer setAgebyId(Integer id,Integer age);//修改年龄
    Integer setIntroductionbyId(Integer id,String introduction);//修改简介
}
