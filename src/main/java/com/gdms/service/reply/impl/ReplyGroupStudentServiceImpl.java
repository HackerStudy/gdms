package com.gdms.service.reply.impl;

import com.gdms.dao.ReplyGroupMapper;
import com.gdms.dao.ReplyGroupStudentMapper;
import com.gdms.dao.ReplyGroupTeacherMapper;
import com.gdms.model.ReplyGroupStudent;
import com.gdms.model.ReplyGroupTeacher;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReplyGroupService;
import com.gdms.service.reply.ReplyGroupStudentService;
import com.gdms.service.reply.ReplyGroupTeacherService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("replyGroupStudentService")
@Transactional(rollbackFor = Exception.class)
public class ReplyGroupStudentServiceImpl extends BaseServiceImpl<ReplyGroupStudent> implements ReplyGroupStudentService {
    private Logger log = Logger.getLogger(ReplyGroupStudentServiceImpl.class);
    @Resource
    private ReplyGroupStudentMapper replyGroupStudentMapper;
}
