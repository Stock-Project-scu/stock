package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.StockOrder;

/**
 * @author 代相廷 用户订单服务
 */

public interface StockOrderService {
    public List<StockOrder> getUserStockOrderbyUsername(String username);
    public List<StockOrder> getAllStockOrder();
    public StockOrder getUserStockOrderbyId(String username,String stockid);
    //public Integer updateStockOrderbyUsernameId();
    public Integer insertbyUsernameId(StockOrder StockOrder);
    public Integer deletbyUsernameId(String username,String stockid);
    public Integer deletUser(String username);//删除用户时候的操作
}