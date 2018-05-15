package com.gdms.service.topic;

import com.gdms.model.TeacherTopic;
import com.gdms.model.TopicApply;
import com.gdms.service.common.BaseService;
import com.gdms.vo.StudentTopicVo;

import java.util.List;

public interface TeacherTopicService extends BaseService<TeacherTopic> {
    List<TeacherTopic> queryTeacherTopicByTid(String tid);

    List<TeacherTopic> queryPageTeacherTopic(String tid, Integer page, Integer rows);

    int queryCountTeacherTopic(String tid);

    int insertTeacherTopic(TeacherTopic teacherTopic);
}
