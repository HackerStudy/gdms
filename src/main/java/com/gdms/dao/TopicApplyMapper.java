package com.gdms.dao;

import com.gdms.model.TopicApply;
import com.gdms.vo.StudentTopicVo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface TopicApplyMapper extends Mapper<TopicApply> {
    int insertTopicApply(TopicApply topicApply);

    TopicApply queryTopicApplyBySid(String sid);

    int deleteTopicApplyBySid(String sid);

    List<StudentTopicVo> queryStudentTopicVoById(Integer id);

    List<StudentTopicVo> queryAllStudentTopicVo();

    int queryCountStudentTopicVoById(Integer id);

    int queryCountAllStudentTopicVo();

    List<StudentTopicVo> queryStudentTopicVoByGid(Integer gid);

    int queryCountStudentTopicVoByGid(Integer gid);

    int updateTopicApplyById(TopicApply topicApply);

    TopicApply queryTopicApplyByTopicName(String topicName);

}