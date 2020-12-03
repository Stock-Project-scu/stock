package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.Order;

/**
 * @author 代相廷 用户订单服务
 */

public interface OrderService {
    public List<Order> getUserOrderbyUsername(String username);
    public List<Order> getAllOrder();
    public Order getUserOrderbyId(String username,String stockid);
    //public Integer updateOrderbyUsernameId();
    public Integer insertbyUsernameId(Order order);
    
    public Integer deletbyUsernameId(String username,String stockid);
}