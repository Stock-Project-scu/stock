package com.web.stock.bean;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User {
//     //** email: "1097249217@qq.com"
// password: "123456"
// repassword: "123456"
// username: "436543"*/
    // private String id;//编号
    // private String email;
    
    // private String username;
    
    String id;              //编号
    String username;        //用户名
    String password;
    String sex;             //性别
    Integer age;            //年龄
    String address;         //所在地
    String introduction;    //个人简介

}
