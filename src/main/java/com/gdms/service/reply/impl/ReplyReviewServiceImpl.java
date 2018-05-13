package com.gdms.service.reply.impl;

import com.gdms.dao.ReplyGroupMapper;
import com.gdms.dao.ReplyGroupTeacherMapper;
import com.gdms.dao.ReplyReviewMapper;
import com.gdms.model.ReplyGroupTeacher;
import com.gdms.model.ReplyReview;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReplyGroupTeacherService;
import com.gdms.service.reply.ReplyReviewService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("replyReviewService")
@Transactional(rollbackFor = Exception.class)
public class ReplyReviewServiceImpl extends BaseServiceImpl<ReplyReview> implements ReplyReviewService {
    private Logger log = Logger.getLogger(ReplyReviewServiceImpl.class);
    @Resource
    private ReplyReviewMapper replyReviewMapper;
}
