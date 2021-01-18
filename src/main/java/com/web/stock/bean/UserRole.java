package com.web.stock.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel
public class UserRole {
    public UserRole() {
    }
    @TableId(type = IdType.AUTO)
	Integer id;              //编号
    String username;        //用户名
    Integer roleid;         //权限
}
