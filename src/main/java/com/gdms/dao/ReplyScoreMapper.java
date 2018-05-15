package com.gdms.dao;

import com.gdms.model.ReplyScore;
import com.gdms.model.TopicApply;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface ReplyScoreMapper extends Mapper<ReplyScore> {
    int insertReplyScore(ReplyScore replyScore);
}