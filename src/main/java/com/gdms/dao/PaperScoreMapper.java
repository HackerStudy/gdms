package com.gdms.dao;

import com.gdms.model.AdviserScore;
import com.gdms.model.PaperScore;
import com.gdms.model.ReplyGroup;
import com.gdms.vo.EntryAdviserScore;
import com.gdms.vo.EntryPaperScore;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface PaperScoreMapper extends Mapper<PaperScore> {

    List<PaperScore> queryPaperScoreByGid(Integer gid);

    int insertPaperScore(PaperScore paperScore);

    List<EntryPaperScore> queryEntryPaperScoreByGid(Integer gid);

    int queryCountEntryPaperScoreByGid(Integer gid);

    int updatePaperScoreBySid(PaperScore paperScore);

}