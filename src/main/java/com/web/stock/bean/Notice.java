package com.web.stock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 代相廷
 * 发布消息
 */
@Data
@AllArgsConstructor
public class Notice {
    public Notice(){}
    @TableId(type = IdType.AUTO)
    Integer id;//ID
    String title;
    String comment;
    String time;//字符串形式内容

}