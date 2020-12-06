package com.web.stock.service.impl;

import java.util.List;
import java.util.Date;
import com.web.stock.bean.StockOrder;
import com.web.stock.bean.UserProperty;
import com.web.stock.bean.UserStock;
import com.web.stock.service.StockOrderService;
import com.web.stock.service.TradeService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.UserStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("TradeService")
@Slf4j
public class TrandserviceImpl implements TradeService {
    @Autowired
    StockOrderService stockorderservice;
    @Autowired
    UserStockService userstockservice;
    @Autowired
    UserPropertyService userpropertyservice;


    @Override
    public List<StockOrder> showStockOrderbyUsername(String username) {
        try {
            log.info("获取该用户订单");
            return stockorderservice.getUserStockOrderbyUsername(username);
        } catch (Exception e) {
            log.error("出错tradeservice:{}",e);
            return null;
        }
    }

    @Override
    public StockOrder showStockOrderbyStockId(String username, String stockid) {
        try {
            log.info("根据股票id获取该用户订单");
            return stockorderservice.getUserStockOrderbyId(username, stockid);
        } catch (Exception e) {
            log.error("出错tradeservice:{}",e);
            return null;
        }
    }

    @Override
    public List<StockOrder> showStockOrder() {
        try {
            log.info("获取所有订单记录");
            return stockorderservice.getAllStockOrder();
        } catch (Exception e) {
            log.error("出错tradeservice:{}", e);
            return null;
        }
    }

    @Override
    public Integer buyStockOrder(String username, String stockid, String stockname, double currentprice,
            double totalprice, Integer number) {
                try {
                    UserProperty userproperty = userpropertyservice.getUserPropertyByName(username);
                    double property = userproperty.getProperty();
                    log.info("用户资产={}",String.valueOf(property));
                    if(property<totalprice){
                        log.info("对不起余额不足");
                        return 2;
                    }
                    //开始购买
                    userproperty.setProperty(property-totalprice);
                    //先创建这个订单
                    Date d = new Date();
                    log.info("订单时间：{}", d.toString());
                    StockOrder order = new StockOrder();
                    order.setOrdertime(d.toString());
                    order.setNumber(number);
                    order.setUsername(username);
                    order.setStockid(stockid);
                    order.setStockname(stockname);
                    order.setCurrentprice(currentprice);
                    order.setTotalprice(totalprice);
                    order.setStockcheck(1);// 买入是1
                    log.info("买入操作:{}", order.toString());
                    UserStock us1 = userstockservice.getUserStockbyNameId(username, stockid);
                    if(us1==null){
                        
                        userstockservice.insertUserStock(username, stockid);
                        us1 = userstockservice.getUserStockbyNameId(username, stockid);
                        us1.setStockname(stockname);
                        us1.setNumber(number);
                        log.info("新建用户资产:{}", us1.toString());
                        userstockservice.updateUserStock(us1);//更新用户资产
                    }
                    else{
                        //如果已经有了该股票资产
                        Integer newnumber=us1.getNumber();
                        newnumber=newnumber+number;
                        log.info("新number={}", newnumber);
                        us1.setNumber(newnumber);
                        userstockservice.updateUserStock(us1);
                        //return stockorderservice.insertbyUsernameId(order);
                    }
                    log.info("更新财产");
                    userpropertyservice.updateUserPropertyById(userproperty.getId(), userproperty.getProperty());
                    //最后返回创建订单
                    return stockorderservice.insertbyUsernameId(order);
                } catch (Exception e) {
                    log.error("出错tradeservice:{}", e);
                    return 0;
                }
    }

    @Override
    public Integer sellStockOrder(String username, String stockid, String stockname, double currentprice,
            double totalprice, Integer number) {
                try {
                    UserProperty userproperty = userpropertyservice.getUserPropertyByName(username);
                    double property = userproperty.getProperty();
                    log.info("用户资产={}",String.valueOf(property));
                    
                    //开始卖出
                    userproperty.setProperty(property+totalprice);
                    //先创建这个订单
                    StockOrder order = new StockOrder();
                    order.setUsername(username);
                    order.setStockid(stockid);
                    order.setStockname(stockname);
                    order.setCurrentprice(currentprice);
                    order.setTotalprice(totalprice);
                    order.setStockcheck(0);// 卖出是0
                    log.info("卖出操作:{}", order.toString());
                    UserStock us1 = userstockservice.getUserStockbyNameId(username, stockid);
                    if(us1==null){
                        log.info("物资无不行");
                        //如果还没有这个股票的资产，先创建
                        return 2; //没有资产
                        
                    }
                    else if(us1.getNumber()<number){
                        log.info("资产不够");
                        //资产不够，也返回2
                        return 2;
                    }
                    else if(us1.getNumber()==number){
                        //恰好卖完
                        //删除资产记录
                        log.info("恰好卖完,删除资产记录");
                        userstockservice.deletUserStock(username, stockid);
                    }
                    else{
                        //如果已经有了该股票资产,并且>=时候
                        Integer newnumber=us1.getNumber();
                        newnumber=newnumber-number;
                        log.info("新number={}", newnumber);
                        us1.setNumber(newnumber);
                        userstockservice.updateUserStock(us1);//更新用户资产
                    }
                    //最后返回创建订单
                    return stockorderservice.insertbyUsernameId(order);
                } catch (Exception e) {
                    log.error("出错tradeservice:{}", e);
                    return 0;
                }
    }

}