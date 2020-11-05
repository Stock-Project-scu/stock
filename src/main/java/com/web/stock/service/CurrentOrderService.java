package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.CurrentOrder;
/**
 * @author 代相廷
 * 当前订单管理service接口
 */
//当前订单的增删查改
public interface CurrentOrderService {
    CurrentOrder getCurrentOrderById(String id);//通过订单编号单个查询
    List<CurrentOrder> getCurrentOderByUserName(String UserName);//通过username获取账户所有当前订单
    boolean addCurrentOrder(CurrentOrder currentOrder);//新增订单
    boolean deletCurrentOrder(String id);//通过id删除订单
    boolean renewCurrentOrder(Double currentPrice);//当前现价刷新
}