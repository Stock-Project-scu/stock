package com.web.stock.service;

public interface EmailService {
    boolean sendEmail(String myMessage,String receiveMailAccount) throws Exception;

}