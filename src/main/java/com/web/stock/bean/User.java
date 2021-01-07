package com.web.stock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel
public class User {
    public User() {
    }
    @TableId(type = IdType.AUTO)
	Integer id;              //编号
    String username;        //用户名
    String password;        //密码
    String email;           //邮箱
    String sex;             //性别
    Integer age;            //年龄
    String address;         //所在地
    String introduction;    //个人简介
}
