package com.web.stock.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.stock.bean.UserProperty;
import com.web.stock.bean.UserRole;
import com.web.stock.mapper.UserRoleMapper;
import com.web.stock.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public boolean insertUserRole(UserRole userRole) {
        try {
            UserRole userrole = new UserRole();
            userrole.setUsername(userRole.getUsername());
            userrole.setRoleid(userRole.getRoleid());
            userRoleMapper.insert(userrole);
            return true;
        } catch (Exception e) {
            System.err.println("注册roleid出错");
            return false;
        }
    }

    @Override
    public UserRole getUserRolebyName(String username) {
        try {
            return userRoleMapper.selectOne(new QueryWrapper<UserRole>().eq("username", username));
        } catch (Exception e) {
            System.err.println("查找role出错");
            return null;
        }
        
    }

    @Override
    public List<UserRole> getUserRoleAll() {
        
        return userRoleMapper.selectList(null);
    }

    @Override
    public Integer getUserRoleIdbyname(String username) {
        try {
            return userRoleMapper.selectOne(new QueryWrapper<UserRole>().eq("username", username)).getRoleid();
        } catch (Exception e) {
            System.err.println("查找roleid出错");
            return null;
        }
    }
}