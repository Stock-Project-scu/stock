package com.web.stock.bean;

import io.swagger.annotations.ApiModel;
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
	Integer StockId;
    String StockName;
    double CurrentPrice;
}