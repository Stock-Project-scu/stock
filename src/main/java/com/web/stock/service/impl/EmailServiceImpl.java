package com.web.stock.service.impl;

import com.web.stock.service.EmailService;

import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service("EmailService")
public class EmailServiceImpl implements EmailService{
     // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    private String myEmailAccount = "stockbuy123@126.com";
    private String myEmailPassword = "QXQDFDUXFPRQSLGH";
    // 网易126邮箱的 SMTP 服务器地址为: smtp.126.com
    private String myEmailSMTPHost = "smtp.126.com";
    // 收件人邮箱（替换为自己知道的有效邮箱）

    public boolean sendEmail(String myMessage, String receiveMailAccount) throws Exception {
        
            Properties props = new Properties();                    // 参数配置
            props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
            props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
            props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
            Session session = Session.getInstance(props);

            // 1. 创建一封邮件
            MimeMessage message = new MimeMessage(session);

            // 2. From: 发件人
            message.setFrom(new InternetAddress(myEmailAccount, "昵称", "UTF-8"));

            // 3. To: 收件人（可以增加多个收件人、抄送、密送）
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount, "XX用户", "UTF-8"));

            // 4. Subject: 邮件主题
            message.setSubject("主题", "UTF-8");
            // 5. Content: 邮件正文（可以使用html标签）
            message.setContent(myMessage, "text/html;charset=UTF-8");
            // 6. 设置发件时间
            message.setSentDate(new Date());
            // 7. 保存设置
            message.saveChanges();
            Transport transport = session.getTransport();
            transport.connect(myEmailAccount, myEmailPassword);
            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
            // 7. 关闭连接
            transport.close();
        
        return true;
    }
}