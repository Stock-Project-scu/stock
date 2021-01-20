package com.web.stock.service.impl;

import java.util.List;

import com.web.stock.bean.Notice;
import com.web.stock.mapper.NoticeMapper;
import com.web.stock.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("NoticeService")
@Slf4j
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticemapper;
    @Override
    public List<Notice> getNoticeAll() {
        try {
            return noticemapper.selectList(null);
        } catch (Exception e) {
            log.error("获取notice失败", e);
            return null;
        }
    }

    @Override
    public Notice getNoticeById(Integer id) {
        try {
            return noticemapper.selectById(id);
        } catch (Exception e) {
            log.error("获取notice失败", e);
            return null;
        }
    }

    @Override
    public Integer addNotcie(Notice notice) {
        try {
            return noticemapper.insert(notice);
        } catch (Exception e) {
            log.error("添加notice失败", e);
            return 0;
        }
    }

    @Override
    public Integer deletNoticebyId(Integer id) {
        try {
            return noticemapper.deleteById(id);
        } catch (Exception e) {
            log.error("删除notice失败", e);
            return 0;
        }
    }

    @Override
    public Integer updateNotice(Notice notice) {
        try {
            return noticemapper.updateById(notice);
        } catch (Exception e) {
            log.error("修改notice失败", e);
            return 0;
        }
    }
    
}