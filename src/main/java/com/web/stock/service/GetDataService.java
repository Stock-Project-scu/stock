package com.web.stock.service;

import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;

public interface GetDataService {
    public User getuserinfo(String username);
    public UserProperty getuserproperty(String username);
}