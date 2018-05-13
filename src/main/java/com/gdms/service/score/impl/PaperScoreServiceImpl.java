package com.gdms.service.score.impl;

import com.gdms.dao.AdviserScoreMapper;
import com.gdms.dao.PaperScoreMapper;
import com.gdms.model.AdviserScore;
import com.gdms.model.PaperScore;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.score.AdviserScoreService;
import com.gdms.service.score.PaperScoreService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

@Service("paperScoreService")
@Transactional(rollbackFor = Exception.class)
public class PaperScoreServiceImpl extends BaseServiceImpl<PaperScore> implements PaperScoreService {
    private Logger log = Logger.getLogger(PaperScoreServiceImpl.class);
    @Resource
    private PaperScoreMapper paperScoreMapper;
}
