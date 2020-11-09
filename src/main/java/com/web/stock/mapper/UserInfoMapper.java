package com.web.stock.mapper;

import java.util.List;

import com.web.stock.bean.User;
import com.web.stock.bean.UserInfo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    UserInfo findByUserName(String username);       //通过用户名获取到userinfo
    List<UserInfo> findAll();                       //获取到所有用户信息；一般是管理员用
    Integer insertUserinfo(UserInfo userInfo);      // 插入用户信息
    Integer insertUserinfobyUser(User user);         //初始化的时候插入信息 
    Integer setSexbyId(Integer id,String sex);                //修改性别
    Integer setAddressbyId(Integer id,String address);             //修改地址
    Integer setEmailbyId(Integer id,String email);                 //更改邮箱
    Integer setUsernamebyId(Integer id,String username);            //修改用户名（慎用）
}