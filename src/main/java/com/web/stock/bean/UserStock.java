package com.web.stock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

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
    public UserStock(){}
    @TableId(type = IdType.AUTO)
    Integer id;//编号
    String username;//用户名
    String stockid;//股票id
    String stockname;//股票名
    Integer number;
}