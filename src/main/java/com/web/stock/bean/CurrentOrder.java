package com.web.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentOrder {
    String id;
    String userName;        //用户名
    String stockId;            //股票编码
    String stockName;       //股票名
    Integer count;          //持仓数量
    Integer countCansell;   //可卖数量
    Double primeCost;       //成本价
    Double currentPrice;    //现价
    Integer todayBuy;       //今日买入
    Integer todaySell;      //今日卖出
    Double profitLoss;      //浮动盈亏
}