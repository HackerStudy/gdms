package com.gdms.service.notice;

import com.gdms.model.Notice;
import com.gdms.service.common.BaseService;

import java.util.List;

public interface NoticeService extends BaseService<Notice> {
    int insertNotice(Notice notice);
    int updateNotice(Notice notice);
    List<Notice> queryAllNotice();
    int deleteNoticeByid(int id);
}
