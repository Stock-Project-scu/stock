package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.StockOrder;

public interface TradeService {
    public Integer buyStockOrder(String username,String stockid,String stockname,double currentprice,double totalprice,Integer number);//买入
    public Integer sellStockOrder(String username,String stockid,String stockname,double currentprice,double totalprice,Integer number);//卖出
    public List<StockOrder> showStockOrderbyUsername(String username);//显示该用户订单
    public StockOrder showStockOrderbyStockId(String username,String stockid);//显示用户特定编号订单
    public List<StockOrder> showStockOrder();//显示所有订单
}