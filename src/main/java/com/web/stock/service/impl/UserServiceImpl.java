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
    public User getUserByName(String username) {
        
        return usermapper.findbyUserName(username) ;
    }

    @Override
    public List<User> getAlluser() {
        
        return usermapper.findAll() ;
    }

    @Override
    public User getUserByemail(String email) {
        
        return usermapper.findbyEmail(email);
    }
    @Override
    public boolean insertUser(User user){
         try {
            usermapper.insertUser(user);
            return true;
         } catch (Exception e) {
             
             return false;
         }
    }

    @Override
    public Integer setSexbyId(Integer id, String sex) {
        
        return usermapper.setSexbyId(id, sex);
    }

    @Override
    public Integer setAddressbyId(Integer id, String address) {
        // TODO Auto-generated method stub
        return usermapper.setAddressbyId(id, address);
    }

    @Override
    public Integer setEmailbyId(Integer id, String email) {
        // TODO Auto-generated method stub
        return usermapper.setEmailbyId(id, email);
    }

    @Override
    public Integer setUsernamebyId(Integer id, String username) {
        // TODO Auto-generated method stub
        return usermapper.setUsernamebyId(id, username);
    }

    @Override
    public Integer findIdbyUserName(String username) {
        // TODO Auto-generated method stub
        return findIdbyUserName(username);
    }

    @Override
    public Integer setAgebyId(Integer id, Integer age) {
        // TODO Auto-generated method stub
        return usermapper.setAgebyId(id, age);
    }

    
}
