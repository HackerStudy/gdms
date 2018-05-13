package com.gdms.service.score.impl;

import com.gdms.dao.AdviserScoreMapper;
import com.gdms.dao.StudentReplyScoreMapper;
import com.gdms.model.AdviserScore;
import com.gdms.model.StudentReplyScore;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.StudentReplyScoreService;
import com.gdms.service.reply.impl.StudentReplyScoreServiceImpl;
import com.gdms.service.score.AdviserScoreService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("adviserScoreService")
@Transactional(rollbackFor = Exception.class)
public class AdviserScoreServiceImpl extends BaseServiceImpl<AdviserScore> implements AdviserScoreService {
    private Logger log = Logger.getLogger(AdviserScoreServiceImpl.class);
    @Resource
    private AdviserScoreMapper adviserScoreMapper;
}
