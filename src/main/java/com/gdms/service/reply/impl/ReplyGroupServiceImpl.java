package com.gdms.service.reply.impl;

import com.gdms.dao.ReplyGroupMapper;
import com.gdms.dao.TopicApplyMapper;
import com.gdms.model.ReplyGroup;
import com.gdms.model.TopicApply;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReplyGroupService;
import com.gdms.service.topic.TopicApplyService;
import com.gdms.service.topic.impl.TopicApplyServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("replyGroupService")
@Transactional(rollbackFor = Exception.class)
public class ReplyGroupServiceImpl extends BaseServiceImpl<ReplyGroup> implements ReplyGroupService {
    private Logger log = Logger.getLogger(ReplyGroupServiceImpl.class);
    @Resource
    private ReplyGroupMapper replyGroupMapper;
}
