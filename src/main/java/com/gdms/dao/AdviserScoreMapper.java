package com.gdms.dao;

import com.gdms.model.AdviserScore;
import com.gdms.vo.EntryAdviserScore;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface AdviserScoreMapper extends Mapper<AdviserScore> {
    List<EntryAdviserScore> queryEntryAdviserScoreByTid(String tid);

    int queryCountEntryAdviserScoreByTid(String tid);

    List<AdviserScore> queryAdviserScoreByTid(String tid);

    int insertAdviseScore(AdviserScore adviserScore);

    int updateAdviseScoreBySid(AdviserScore adviserScore);
}