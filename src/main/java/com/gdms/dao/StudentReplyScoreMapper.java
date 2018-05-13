package com.gdms.dao;

import com.gdms.model.StudentReplyScore;
import com.gdms.model.TopicApply;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface StudentReplyScoreMapper extends Mapper<StudentReplyScore> {
}