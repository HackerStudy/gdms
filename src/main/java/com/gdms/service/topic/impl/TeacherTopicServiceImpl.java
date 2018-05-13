package com.gdms.service.topic.impl;

import com.gdms.dao.TeacherTopicMapper;
import com.gdms.model.TeacherTopic;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.topic.TeacherTopicService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("teacherTopicService")
@Transactional(rollbackFor = Exception.class)
public class TeacherTopicServiceImpl extends BaseServiceImpl<TeacherTopic> implements TeacherTopicService {
    private Logger log = Logger.getLogger(TeacherTopicServiceImpl.class);
    @Resource
    private TeacherTopicMapper teacherTopicMapper;
}
