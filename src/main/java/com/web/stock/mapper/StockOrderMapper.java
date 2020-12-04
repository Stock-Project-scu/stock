package com.web.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.stock.bean.StockOrder;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockOrderMapper extends BaseMapper<StockOrder> {

}