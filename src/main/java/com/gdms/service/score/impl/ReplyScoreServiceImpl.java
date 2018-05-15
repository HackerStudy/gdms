package com.gdms.service.score.impl;

import com.gdms.dao.PaperScoreMapper;
import com.gdms.dao.ReplyScoreMapper;
import com.gdms.model.PaperScore;
import com.gdms.model.ReplyScore;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.score.PaperScoreService;
import com.gdms.service.score.ReplyScoreService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

@Service("replyScoreService")
@Transactional(rollbackFor = Exception.class)
public class ReplyScoreServiceImpl extends BaseServiceImpl<ReplyScore> implements ReplyScoreService {
    private Logger log = Logger.getLogger(ReplyScoreServiceImpl.class);
    @Resource
    private ReplyScoreMapper replyScoreMapper;

    public int insertReplyScore(ReplyScore replyScore) {
        return replyScoreMapper.insertReplyScore(replyScore);
    }
}
