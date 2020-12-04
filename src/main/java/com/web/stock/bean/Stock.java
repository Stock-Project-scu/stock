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
	Integer stockid;
    String stockname;
    double currentprice;
}