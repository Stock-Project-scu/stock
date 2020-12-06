package com.web.stock.Controller;

import com.web.stock.bean.StockOrder;
import com.web.stock.bean.UserProperty;
import com.web.stock.bean.UserStock;
import com.web.stock.service.StockOrderService;
import com.web.stock.service.TradeService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.UserStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    TradeService tradeservice;

    @PostMapping("/buy")
    @ResponseBody
    public Integer BuyStock(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "stockId", required = true) String stockid,
            @RequestParam(value = "stockName", required = true) String stockname,
            @RequestParam(value = "currentPrice", required = true) double currentprice,
            @RequestParam(value = "buyCount", required = true) Integer number,
            @RequestParam(value = "totalPrice", required = true) double totalprice) {
        log.info("买股票");
        return tradeservice.buyStockOrder(username, stockid, stockname, currentprice, totalprice, number);
    }
    

}