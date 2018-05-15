package com.gdms.service.topic.impl;

import com.gdms.dao.TeacherTopicMapper;
import com.gdms.model.Teacher;
import com.gdms.model.TeacherTopic;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.topic.TeacherTopicService;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("teacherTopicService")
@Transactional(rollbackFor = Exception.class)
public class TeacherTopicServiceImpl extends BaseServiceImpl<TeacherTopic> implements TeacherTopicService {
    private Logger log = Logger.getLogger(TeacherTopicServiceImpl.class);
    @Resource
    private TeacherTopicMapper teacherTopicMapper;

    public List<TeacherTopic> queryTeacherTopicByTid(String tid) {
        return teacherTopicMapper.queryTeacherTopicByTid(tid);
    }

    public List<TeacherTopic> queryPageTeacherTopic(String tid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryTeacherTopicByTid(tid);
    }

    public int queryCountTeacherTopic(String tid) {
        return teacherTopicMapper.queryCountTeacherTopic(tid);
    }

    public int insertTeacherTopic(TeacherTopic teacherTopic) {
        return teacherTopicMapper.insertTeacherTopic(teacherTopic);
    }
}
