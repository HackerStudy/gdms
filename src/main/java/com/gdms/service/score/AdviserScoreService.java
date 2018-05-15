package com.gdms.service.score;

import com.gdms.model.AdviserScore;
import com.gdms.model.TopicApply;
import com.gdms.service.common.BaseService;
import com.gdms.vo.EntryAdviserScore;
import com.gdms.vo.StudentScoreVo;

import java.util.List;

public interface AdviserScoreService extends BaseService<AdviserScore> {

    List<EntryAdviserScore> queryPageEntryAdviserScoreByTid(String tid, Integer page, Integer rows);

    List<EntryAdviserScore> queryEntryAdviserScoreByTid(String tid);

    int queryCountEntryAdviserScoreByTid(String tid);

    List<AdviserScore> queryAdviserScoreByTid(String tid);

    int insertAdviseScore(AdviserScore adviserScore);

    int updateAdviseScoreBySid(AdviserScore adviserScore);
}
