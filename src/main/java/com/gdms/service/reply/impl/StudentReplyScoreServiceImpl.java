package com.gdms.service.reply.impl;

import com.gdms.dao.ReviewStatusMapper;
import com.gdms.dao.StudentReplyScoreMapper;
import com.gdms.model.ReviewStatus;
import com.gdms.model.StudentReplyScore;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReviewStatusService;
import com.gdms.service.reply.StudentReplyScoreService;
import com.gdms.service.score.ReplyScoreService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("studentReplyScoreService")
@Transactional(rollbackFor = Exception.class)
public class StudentReplyScoreServiceImpl extends BaseServiceImpl<StudentReplyScore> implements StudentReplyScoreService {
    private Logger log = Logger.getLogger(StudentReplyScoreServiceImpl.class);
    @Resource
    private StudentReplyScoreMapper studentReplyScoreMapper;
}
