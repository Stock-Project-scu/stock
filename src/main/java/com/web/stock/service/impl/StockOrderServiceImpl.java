package com.web.stock.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.stock.bean.StockOrder;
import com.web.stock.mapper.StockOrderMapper;
import com.web.stock.service.StockOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("StockOrderService")
@Slf4j
public class StockOrderServiceImpl implements StockOrderService {
    @Autowired
    StockOrderMapper StockOrdermapper;

    @Override
    public List<StockOrder> getUserStockOrderbyUsername(String username) {
        try {
            log.info("获取用户名下所有股票信息");
            log.info("username:{}",username);
            return StockOrdermapper.selectList(new QueryWrapper<StockOrder>().eq("username", username));
        } catch (Exception e) {
            log.error("出错：", e);
            return null;
        }
        //return null;
    }

    @Override
    //用于管理员查看所有订单
    public List<StockOrder> getAllStockOrder() {
        try {
            log.info("获取本系统所有订单");
            return StockOrdermapper.selectList(null);
        } catch (Exception e) {
            log.error("出错", e);
            return null;
        }
        //return null;
    }

    @Override
    public StockOrder getUserStockOrderbyId(String username, String stockid) {
        try {
            log.info("通过用户名和stockid获取单个订单");
            StockOrder StockOrder = StockOrdermapper.selectOne(new QueryWrapper<StockOrder>().eq("username", username).eq("stockid", stockid));
            log.info("订单:{}",StockOrder.toString());
            return StockOrder;
        } catch (Exception e) {
            log.error("出错", e);
            return null;
        }
        //return null;
    }

    @Override
    public Integer insertbyUsernameId(StockOrder StockOrder) {
        try {
            log.info("插入一条用户持有记录");
            log.info("StockOrder:{}",StockOrder.toString());
            return StockOrdermapper.insert(StockOrder);
        } catch (Exception e) {
            log.error("出错", e);
            return 0;
        }
        //return null;
    }

    @Override
    public Integer deletbyUsernameId(String username, String stockid) {
        try {
            log.info("删除一条用户记录");
            log.info("用户名:{}",username);
            log.info("stockid:{}",stockid);
            return StockOrdermapper.delete(new QueryWrapper<StockOrder>().eq("username", username).eq("stockid", stockid));
        } catch (Exception e) {
            log.error("出错", e);
            return 0;
        }
        //return null;
    }

}