package com.web.stock.service;


import org.springframework.http.HttpMethod;

public interface myHttpClient {
    public String client(String url,HttpMethod method);
}