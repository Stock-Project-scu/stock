package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.User;
/**
 * @author 代相廷
 * service接口
 */
import com.web.stock.bean.UserRole;
public interface UserRoleService {
   

    boolean insertUserRole(UserRole userRole);//注册
    UserRole getUserRolebyName(String username);//
    List<UserRole> getUserRoleAll();
    Integer getUserRoleIdbyname(String username);//获取roleid
}