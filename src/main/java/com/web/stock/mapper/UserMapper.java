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
    Integer findIdbyUserName(String username);//根据用户名返回id 
    Integer setEmail(String email);//修改邮箱（慎用）
    Integer setUsername(String username);//修改用户名（慎用）
}
