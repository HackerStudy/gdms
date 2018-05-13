package com.gdms.service.topic.impl;

import com.gdms.dao.StudentMapper;
import com.gdms.dao.TopicApplyMapper;
import com.gdms.model.Student;
import com.gdms.model.TopicApply;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.topic.TopicApplyService;
import com.gdms.service.user.StudentService;
import com.gdms.service.user.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("topicApplyService")
@Transactional(rollbackFor = Exception.class)
public class TopicApplyServiceImpl extends BaseServiceImpl<TopicApply> implements TopicApplyService {
    private Logger log = Logger.getLogger(TopicApplyServiceImpl.class);
    @Resource
    private TopicApplyMapper topicApplyMapper;

}
