package com.web.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistoryOrder {
    String id;          //编号
    String data;        //日期
    String time;        //时间
    String stockId;     //股票id
    String stockName;   //股票名
    String BSFlag;      //标志
    Double doneCost;    //卖出价格
    Integer doneCount;   //卖出数量
    Double donePrice;   //卖出价格
}