package com.gdms.service.score.impl;

import com.gdms.dao.AdviserScoreMapper;
import com.gdms.dao.StudentReplyScoreMapper;
import com.gdms.model.AdviserScore;
import com.gdms.model.StudentReplyScore;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.StudentReplyScoreService;
import com.gdms.service.reply.impl.StudentReplyScoreServiceImpl;
import com.gdms.service.score.AdviserScoreService;
import com.gdms.vo.EntryAdviserScore;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("adviserScoreService")
@Transactional(rollbackFor = Exception.class)
public class AdviserScoreServiceImpl extends BaseServiceImpl<AdviserScore> implements AdviserScoreService {
    private Logger log = Logger.getLogger(AdviserScoreServiceImpl.class);
    @Resource
    private AdviserScoreMapper adviserScoreMapper;

    public List<EntryAdviserScore> queryPageEntryAdviserScoreByTid(String tid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryEntryAdviserScoreByTid(tid);
    }

    public List<EntryAdviserScore> queryEntryAdviserScoreByTid(String tid) {
        return adviserScoreMapper.queryEntryAdviserScoreByTid(tid);
    }

    public int queryCountEntryAdviserScoreByTid(String tid) {
        return adviserScoreMapper.queryCountEntryAdviserScoreByTid(tid);
    }

    public List<AdviserScore> queryAdviserScoreByTid(String tid) {
        return adviserScoreMapper.queryAdviserScoreByTid(tid);
    }

    public int insertAdviseScore(AdviserScore adviserScore) {
        return adviserScoreMapper.insertAdviseScore(adviserScore);
    }

    public int updateAdviseScoreBySid(AdviserScore adviserScore) {
        return adviserScoreMapper.updateAdviseScoreBySid(adviserScore);
    }
}
