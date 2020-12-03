package com.web.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.stock.bean.Order;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}