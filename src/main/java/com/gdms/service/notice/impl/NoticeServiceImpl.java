package com.gdms.service.notice.impl;

import com.gdms.dao.NoticeMapper;
import com.gdms.dao.TeacherMapper;
import com.gdms.model.Notice;
import com.gdms.model.Teacher;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.notice.NoticeService;
import com.gdms.service.user.TeacherService;
import com.gdms.service.user.impl.TeacherServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Service("noticeService")
@Transactional(rollbackFor = Exception.class)
public class NoticeServiceImpl extends BaseServiceImpl<Notice> implements NoticeService {
    private Logger log = Logger.getLogger(TeacherServiceImpl.class);
    @Resource
    private NoticeMapper noticeMapper;

    public int insertNotice(Notice notice) {
        return noticeMapper.insertNotice(notice);
    }

    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    public List<Notice> queryAllNotice() {
        return noticeMapper.queryAllNotice();
    }

    public int deleteNoticeByid(int id) {
        return noticeMapper.deleteNoticeByid(id);
    }
}
