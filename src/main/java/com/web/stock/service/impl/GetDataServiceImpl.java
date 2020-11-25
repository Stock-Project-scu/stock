package com.web.stock.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
import com.web.stock.service.GetDataService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.Userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GetDataService")
public class GetDataServiceImpl implements GetDataService {
    @Autowired
    private Userservice userservice;// 创建一个userservice

    @Autowired
    GetDataService getdataservice;
    @Autowired
    HttpSession session;
    @Autowired
    UserPropertyService userpropertyservice;

    Logger logger = LoggerFactory.getLogger(GetDataService.class);

    // 获取用户信息
    @Override
    public User getuserinfo(String username) {
        return userservice.getUserByName(username);
    }

    // 获取资产
    @Override
    public UserProperty getuserproperty(String username) {
        try {
            return userpropertyservice.getUserPropertyByName(username);
        } catch (Exception e) {
            logger.info("获取失败");
            logger.error("错误为={}", e);
            return null;
        }
    }

    @Override
    public List<User> getuserinfoall() {
        logger.info("全部用户信息获取");
        try {
            return userservice.getAlluser();
        } catch (Exception e) {
            logger.error("获取出错了", e);
            return null;
        }
        
    }

    @Override
    public List<UserProperty> getuserpropertyall() {
        logger.info("全部用户资产获取");
        try {
            return userpropertyservice.getUserPropertyAll();
        } catch (Exception e) {
            logger.error("获取出错了", e);
            return null;
        }
        //return null;
    }

}