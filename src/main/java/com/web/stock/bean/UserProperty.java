package com.web.stock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProperty {
    public UserProperty() {
    }
    @TableId(type = IdType.AUTO)
	Integer id;//id号
    String username;//用户名
    double property;//资产
}