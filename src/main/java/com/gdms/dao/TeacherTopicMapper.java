package com.gdms.dao;

import com.gdms.model.TeacherTopic;
import com.gdms.model.TopicApply;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface TeacherTopicMapper extends Mapper<TeacherTopic> {

}