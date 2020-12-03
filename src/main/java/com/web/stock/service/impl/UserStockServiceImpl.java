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
        //return null;
    }

    @Override
    public UserStock getUserStockbyNameId(String username, String stockid) {
        try {
            log.info("获取用户名下指定股票数据");
            return userstockmapper.selectOne(new QueryWrapper<UserStock>().eq("username", username).eq("stockid", stockid));
        } catch (Exception e) {
            log.error("出错:", e);
            return null;
        }
        //return null;
    }

    @Override
    public Integer updateUserStockbyNameId(String name, String stockid, Integer number) {
        try {
            //需要提前做检查。
            log.info("更新信息，本次更新");
            log.info("name:{}",name);
            log.info("stockid:{}",stockid);
            log.info("number:", number);
            UserStock us1 = getUserStockbyNameId(name,stockid);
            log.info("原信息={}", us1.toString());
            us1.setNumber(number);
            log.info("现信息:{}",us1.toString());
            return userstockmapper.update(us1, null);
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
        //return null;
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
        //return null;
    }

}