package com.web.stock.service.impl;

import java.util.List;

import com.web.stock.bean.User;
import com.web.stock.mapper.UserMapper;
import com.web.stock.service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 代相廷 impl注入
 */
@Service("UserService")
public class UserServiceImpl implements Userservice {
    @Autowired
    private UserMapper usermapper;

    @Override
    public User getUserByname(String username) {
        
        return usermapper.findbyUsername(username) ;
    }

    @Override
    public List<User> getAlluser() {
        
        return usermapper.findAll() ;
    }

    @Override
    public User getUserByemail(String email) {
        
        return usermapper.findbyUseremail(email);
    }
    @Override
    public User signUser(User user){
        return usermapper.signUser(user);
    }

    
}
