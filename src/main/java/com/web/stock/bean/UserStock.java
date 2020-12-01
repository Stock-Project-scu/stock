package com.web.stock.bean;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel
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