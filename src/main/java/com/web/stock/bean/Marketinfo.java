package com.web.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 代相廷
 * 大盘信息
 */
@Data
@AllArgsConstructor
public class Marketinfo{
    public Marketinfo(){}
    String name;//大盘信息
    double price;//数值
    double upDown;//
    double uoDownPercent;
    Integer value1;
    Integer value2;
}