package com.web.stock.service.impl;

import com.web.stock.service.myHttpClient;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("myHttpClient")
public class myHttpClientImpl implements myHttpClient{
    @Override
    public String client(String url,HttpMethod method){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response1 = restTemplate.getForEntity(url, String.class);
        return response1.getBody();
    }
}