package com.web.stock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 代相廷
 * 订单记录
 * 
 */
@Data
@AllArgsConstructor
public class StockOrder {
    public StockOrder() {
    }
    @TableId(type = IdType.AUTO)
    Integer id;//ID
    String username;//购买/卖出的用户名
    Integer stockcheck;//买入0/卖出1
    String stockid;//股票ID
    String stockname;//股票名
    double currentprice; //当时价格
    double totalprice; //订单总价
    Integer number; //购入/卖出 数量
    Long ordertime; //时间戳
}