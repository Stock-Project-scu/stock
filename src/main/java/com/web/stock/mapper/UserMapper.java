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
    User findbyUsername(String username);//根据用户名查找
    User findbyUseremail(String email);//根据email查找
    User signUser(User user);//注册用户
    
}
