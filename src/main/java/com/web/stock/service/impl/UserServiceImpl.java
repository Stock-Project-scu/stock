package com.web.stock.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.stock.bean.User;
import com.web.stock.mapper.UserMapper;
import com.web.stock.service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 代相廷 impl注入
 */
@Service("UserService")
@Slf4j
public class UserServiceImpl implements Userservice {
    @Autowired
    private UserMapper usermapper;

    @Override
    public User getUserByName(String username) {
        
        return usermapper.selectOne(new QueryWrapper<User>().eq("username",username));
    }

    @Override
    public List<User> getAlluser() {
        return usermapper.selectList(null) ;
    }

    @Override
    public User getUserByemail(String email) {
        
        return usermapper.selectOne(new QueryWrapper<User>().eq("email",email));
    }
    @Override
    public boolean insertUser(User user){
         try {
            usermapper.insert(user);
            return true;
         } catch (Exception e) {
             return false;
         }
    }

    @Override
    public Integer setSexbyId(Integer id, String sex) {
        try {
            User u1 = new User();
            u1.setId(id);
            u1.setSex(sex);
            usermapper.updateById(u1);
        } catch (Exception e) {
            System.err.println(e);
            return 2;
        }
        return 1;
    }

    @Override
    public Integer setAddressbyId(Integer id, String address) {
      
        try {
            User u1 = new User();
            u1.setId(id);
            u1.setAddress(address);
            usermapper.updateById(u1);
        } catch (Exception e) {
            System.err.println(e);
            return 2;
        }
        return 1;
    }

    @Override
    public Integer setEmailbyId(Integer id, String email) {
        
        try {
            User u1 = new User();
            u1.setId(id);
            u1.setEmail(email);
            usermapper.updateById(u1);
        } catch (Exception e) {
            System.err.println(e);
            return 2;
        }
        return 1;
    }

    @Override
    public Integer setUsernamebyId(Integer id, String username) {
        
        try {
            User u1 = new User();
            u1.setId(id);
            u1.setUsername(username);
            usermapper.updateById(u1);
        } catch (Exception e) {
            System.err.println(e);
            return 2;
        }
        return 1;
    }

    @Override
    public Integer findIdbyUserName(String username) {
        
        User u1 = usermapper.selectOne(new QueryWrapper<User>().eq("username",username));
        return u1.getId();
    }

    @Override
    public Integer setAgebyId(Integer id, Integer age) {
        
        try {
            User u1 = new User();
            u1.setId(id);
            u1.setAge(age);
            usermapper.updateById(u1);
        } catch (Exception e) {
            System.err.println(e);
            return 2;
        }
        return 1;
    }



	@Override
	public Integer setPassowrdbyId(Integer id, String password) {
		
		try {
            User u1 = new User();
            u1.setId(id);
            u1.setPassword(password);
            usermapper.updateById(u1);
        } catch (Exception e) {
            System.err.println(e);
            return 2;
        }
        return 1;
	}

    @Override
    public Integer setIntroductionbyId(Integer id, String introduction) {
        
        try {
            User u1 = new User();
            u1.setId(id);
            u1.setIntroduction(introduction);
            usermapper.updateById(u1);
        } catch (Exception e) {
            System.err.println(e);
            return 2;
        }
        return 1;
    }

    @Override
    public Integer deletUserById(Integer id) {
        try {
            log.info("删除用户byid");
            return usermapper.deleteById(id);
        } catch (Exception e) {
            log.error("出错", e);
            return 0;
        }
    }

    
}
