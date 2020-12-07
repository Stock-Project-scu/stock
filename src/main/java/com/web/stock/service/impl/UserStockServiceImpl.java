package com.web.stock.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.stock.bean.UserStock;
import com.web.stock.mapper.UserStockMapper;
import com.web.stock.service.UserStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("UserStockService")
@Slf4j
public class UserStockServiceImpl implements UserStockService {
    @Autowired
    UserStockMapper userstockmapper;

    @Override
    public List<UserStock> getUserAllStockbyName(String username) {
        try {
            log.info("获取用户全部持有股票数据");
            return userstockmapper.selectList(new QueryWrapper<UserStock>().eq("username", username));
        } catch (Exception e) {
            log.error("出错:", e);
            return null;
        }
        
    }

    @Override
    public UserStock getUserStockbyNameId(String username, String stockid) {
        try {
            log.info("获取用户名下指定股票数据");
            System.out.println("username:"+username+"   stockid:"+stockid);
            UserStock us1 = userstockmapper.selectOne(new QueryWrapper<UserStock>().eq("username", username).eq("stockid", stockid));
            log.info("查找到的userstock:{}", us1.toString());
            return us1;
        } catch (Exception e) {
            log.error("出错:", e);
            return null;
        }
        
    }

    @Override
    public Integer updateUserStock(UserStock userstock) {
        try {
            //需要提前做检查。
            log.info("更新信息，本次更新");
            log.info("原信息:{}",userstock.toString());
            //UserStock us1 = getUserStockbyNameId(userstock.getUsername(),userstock.getStockid());
            //log.info("原信息={}", us1.toString());
            return userstockmapper.update(userstock, new QueryWrapper<UserStock>().eq("id", userstock.getId()));
        } catch (Exception e) {
            log.error("错误:", e);
        }
        return 0;
    }

    @Override
    //插入一条新纪录，不含数值
    public Integer insertUserStock(String username, String stockid) {
        try {
            log.info("插入一条新纪录，不含数值");
            UserStock us1 = new UserStock();
            us1.setUsername(username);
            us1.setStockid(stockid);
            return userstockmapper.insert(us1);

        } catch (Exception e) {
            log.error("错误:", e);
            return 0;
        }
        
    }

    @Override
    public Integer deletUserStock(String username, String stockid) {
        try {
            log.info("删除一条记录,当number=0");
            
            return userstockmapper.delete(new QueryWrapper<UserStock>().eq("username", username).eq("stockid", stockid));
        } catch (Exception e) {
            log.error("错误:", e);
            return 0;
        }
        
    }

}