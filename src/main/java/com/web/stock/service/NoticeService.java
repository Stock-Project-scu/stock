package com.web.stock.service;
/**
 * @author 代相廷
 * 消息发布
 */

import java.util.List;

import com.web.stock.bean.Notice;

public interface NoticeService {
    public List<Notice> getNoticeAll();
    public Notice getNoticeById(Integer id);
    public Integer addNotcie(Notice notice);
    public Integer deletNoticebyId(Integer id);//根据id删除
    public Integer updateNotice(Notice notice);//修改
}