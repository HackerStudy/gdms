package com.gdms.dao;

import com.gdms.model.StudentScore;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface StudentScoreMapper extends Mapper<StudentScore> {
}