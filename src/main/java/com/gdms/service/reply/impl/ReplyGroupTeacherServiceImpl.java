package com.gdms.service.reply.impl;

import com.gdms.dao.ReplyGroupTeacherMapper;
import com.gdms.model.ReplyGroupTeacher;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReplyGroupTeacherService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("replyGroupTeacherService")
@Transactional(rollbackFor = Exception.class)
public class ReplyGroupTeacherServiceImpl extends BaseServiceImpl<ReplyGroupTeacher> implements ReplyGroupTeacherService {
    private Logger log = Logger.getLogger(ReplyGroupTeacherServiceImpl.class);
    @Resource
    private ReplyGroupTeacherMapper replyGroupTeacherMapper;
}
