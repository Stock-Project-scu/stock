package com.web.stock.Controller;

import com.web.stock.bean.Notice;
import com.web.stock.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/noptice")
@Slf4j
public class NoticeController {
    @Autowired
    NoticeService noticeservice;

    @PostMapping("/new")
    @ResponseBody
    public Integer releasenotice(Notice notice){
        try {
            log.info("发布公告={}",notice.toString());
            return noticeservice.addNotcie(notice);
        } catch (Exception e) {
            log.error("发布失败", e);
            return 0;
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public Integer deletNotice(Integer id){
        try {
            return noticeservice.deletNoticebyId(id);
        } catch (Exception e) {
            log.error("删除失败", e);
            return 0;
        }
    }
    @PostMapping("/update")
    @ResponseBody
    public Integer updateNotice(Notice notice){
        try {
            return noticeservice.updateNotice(notice);
        } catch (Exception e) {
            log.error("删除失败", e);
            return 0;
        }
    }
}