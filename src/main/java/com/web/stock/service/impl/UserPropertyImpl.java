package com.web.stock.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.stock.bean.UserProperty;
import com.web.stock.mapper.UserPropertyMapper;
import com.web.stock.service.UserPropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserPropertyService")
public class UserPropertyImpl implements UserPropertyService {
    @Autowired
    UserPropertyMapper userpropertymapper;

    @Override
    public UserProperty getUserPropertyById(Integer id) {
        return userpropertymapper.selectById(id);
    }

    @Override
    public UserProperty getUserPropertyByName(String username) {
        return userpropertymapper.selectOne(new QueryWrapper<UserProperty>().eq("username", username));
    }

    @Override
    public List<UserProperty> getUserPropertyAll() {
        return userpropertymapper.selectList(null);
    }

    @Override
    public Integer insertUserProperty(String username) {
        UserProperty up1 = new UserProperty();
        up1.setUsername(username);
        up1.setProperty(0);
        return userpropertymapper.insert(up1);
    }

    @Override
    public Integer updateUserPropertyById(Integer id, double property) {
        try {
            UserProperty up1 = userpropertymapper.selectById(id);
            System.out.println("要修改的内容为");
            System.out.println(up1.toString());
            up1.setProperty(property);
            userpropertymapper.updateById(up1);
            return 1;
        } catch (Exception e) {
            System.err.println(e);
            return 2;
        }
    }

    @Override
    public Integer deletUserPropertyById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

}