package com.web.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

/**
 * 股票类
 */
public class Stock {
    public Stock() {
	}
	Integer stockid;//股票ID
    String stockname;//股票名
    double currentprice;//当前价格
}