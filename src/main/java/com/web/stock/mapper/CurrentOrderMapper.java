package com.web.stock.mapper;

import java.util.List;

import com.web.stock.bean.CurrentOrder;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author 代相廷
 * 当前的订单的DAO的mapper
 */

@Mapper
public interface CurrentOrderMapper {
    CurrentOrder getCurrentOrderById(String id);//通过订单编号单个查询
    List<CurrentOrder> getCurrentOderByUserName(String UserName);//通过username获取账户所有当前订单
    boolean addCurrentOrder(CurrentOrder currentOrder);//新增订单
    boolean deletCurrentOrder(String id);//通过id删除
    boolean renewCurrentOrder(Double currentPrice);//当前现价刷新
}