package com.web.stock.service;

import java.util.List;

import com.web.stock.bean.UserStock;

public interface UserStockService  {
    public List<UserStock> getUserAllStockbyName(String username);
    public UserStock getUserStockbyNameId(String username,String stockid);
    public Integer updateUserStockbyNameId(String name,String stockid,Integer number);
    public Integer insertUserStock(String username,String stockid);
    public Integer deletUserStock(String username,String stockid);

}