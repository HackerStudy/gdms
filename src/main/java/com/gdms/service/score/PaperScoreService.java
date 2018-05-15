package com.gdms.service.score;

import com.gdms.model.PaperScore;
import com.gdms.model.TopicApply;
import com.gdms.service.common.BaseService;
import com.gdms.vo.EntryAdviserScore;
import com.gdms.vo.EntryPaperScore;

import java.util.List;

public interface PaperScoreService extends BaseService<PaperScore> {
    List<PaperScore> queryPaperScoreByGid(Integer gid);

    int insertPaperScore(PaperScore paperScore);

    List<EntryPaperScore> queryPageEntryPaperScoreByGid(Integer gid, Integer page, Integer rows);

    List<EntryPaperScore> queryEntryPaperScoreByGid(Integer gid);

    int queryCountEntryPaperScoreByGid(Integer gid);

    int updatePaperScoreBySid(PaperScore paperScore);
}
