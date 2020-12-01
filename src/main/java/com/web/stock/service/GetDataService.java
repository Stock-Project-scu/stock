package com.web.stock.service;

import java.util.List;
import java.util.Map;


import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;

public interface GetDataService {
    public User getuserinfo(String username);
    public UserProperty getuserproperty(String username);
    public List<User> getuserinfoall();
    public List<UserProperty> getuserpropertyall();
    public Map<String,String> getstockcurrentprice(String stockid);
}