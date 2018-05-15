package com.gdms.service.score.impl;

import com.gdms.dao.AdviserScoreMapper;
import com.gdms.dao.PaperScoreMapper;
import com.gdms.model.AdviserScore;
import com.gdms.model.PaperScore;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.score.AdviserScoreService;
import com.gdms.service.score.PaperScoreService;
import com.gdms.vo.EntryPaperScore;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Service("paperScoreService")
@Transactional(rollbackFor = Exception.class)
public class PaperScoreServiceImpl extends BaseServiceImpl<PaperScore> implements PaperScoreService {
    private Logger log = Logger.getLogger(PaperScoreServiceImpl.class);
    @Resource
    private PaperScoreMapper paperScoreMapper;

    public List<PaperScore> queryPaperScoreByGid(Integer gid) {
        return paperScoreMapper.queryPaperScoreByGid(gid);
    }

    public int insertPaperScore(PaperScore paperScore) {
        return paperScoreMapper.insertPaperScore(paperScore);
    }

    public List<EntryPaperScore> queryPageEntryPaperScoreByGid(Integer gid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryEntryPaperScoreByGid(gid);
    }

    public List<EntryPaperScore> queryEntryPaperScoreByGid(Integer gid) {
        return paperScoreMapper.queryEntryPaperScoreByGid(gid);
    }

    public int queryCountEntryPaperScoreByGid(Integer gid) {
        return paperScoreMapper.queryCountEntryPaperScoreByGid(gid);
    }

    public int updatePaperScoreBySid(PaperScore paperScore) {
        return paperScoreMapper.updatePaperScoreBySid(paperScore);
    }
}
