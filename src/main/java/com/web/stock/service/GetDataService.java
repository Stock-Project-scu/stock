package com.web.stock.service;

import java.util.List;
import java.util.Map;

import com.web.stock.bean.Marketinfo;
import com.web.stock.bean.StockOrder;
import com.web.stock.bean.User;
import com.web.stock.bean.UserProperty;
import com.web.stock.bean.UserStock;

public interface GetDataService {
    public User getuserinfo(String username);
    public UserProperty getuserproperty(String username);
    public List<User> getuserinfoall();
    public List<UserProperty> getuserpropertyall();
    public Map<String,String> getstockcurrentprice(String stockid);
    public List<UserStock> getuserstock(String username);//获取用户持有的股票信息
    public List<StockOrder> getuserstockorder(String username);//获取用户订单记录
    public String getnews(Integer page);//获取资讯，分页数
    public Marketinfo getmarketinfo(String stockid);//获取单个大盘信息
}