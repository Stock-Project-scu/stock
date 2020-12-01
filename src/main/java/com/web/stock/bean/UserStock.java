package com.web.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * 用户持有股票
 */
public class UserStock {
    Integer id;
    String UserName;
    Integer stockId;
    String StockName;
    Integer number;
}