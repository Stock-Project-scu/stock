package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.Order;

public interface TradeService {
    public Integer buyOrder(String username,String stockid,String stockname,double currentprice,Integer number);//买入
    public Integer sellOrder(String username,String stockid,String stockname,double currentprice,Integer number);//卖出
    public List<Order> showOrderbyUsername(String username);//显示该用户订单
    public Order showOrderbyStockId(String username,String id);//显示用户特定编号订单
    public List<Order> showOrder();//显示所有订单
}