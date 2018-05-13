package com.gdms.service.reply.impl;

import com.gdms.dao.ReplyGroupMapper;
import com.gdms.dao.ReviewStatusMapper;
import com.gdms.model.ReplyGroup;
import com.gdms.model.ReviewStatus;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReplyGroupService;
import com.gdms.service.reply.ReviewStatusService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

@Service("reviewStatusService")
@Transactional(rollbackFor = Exception.class)
public class ReviewStatusServiceImpl extends BaseServiceImpl<ReviewStatus> implements ReviewStatusService {
    private Logger log = Logger.getLogger(ReviewStatusServiceImpl.class);
    @Resource
    private ReviewStatusMapper reviewStatusMapper;
}
