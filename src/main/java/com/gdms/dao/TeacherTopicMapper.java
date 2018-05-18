package com.gdms.dao;

import com.gdms.model.TeacherTopic;
import com.gdms.model.TopicApply;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface TeacherTopicMapper extends Mapper<TeacherTopic> {
    List<TeacherTopic> queryTeacherTopicByTid(String tid);

    int insertTeacherTopic(TeacherTopic teacherTopic);

    int queryCountTeacherTopic(String tid);

    TeacherTopic queryTeacherTopicByTopicName(String topicName);

}