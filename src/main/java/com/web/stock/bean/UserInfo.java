package com.web.stock.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 代相廷
 * 用户的个人信息和资产
 */
@Data
@AllArgsConstructor
public class UserInfo {
    //String id;              //编号
    String username;        //用户名
    String sex;             //性别
    Integer age;            //年龄
    String address;         //所在地
    String introduction;    //个人简介
    
}