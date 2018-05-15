package com.gdms.service.topic;

import com.gdms.model.Advise;
import com.gdms.model.Student;
import com.gdms.model.TopicApply;
import com.gdms.service.common.BaseService;
import com.gdms.vo.StudentInfoVo;
import com.gdms.vo.StudentTopicVo;
import com.gdms.vo.StudentVo;

import java.util.List;

public interface TopicApplyService extends BaseService<TopicApply> {
    int insertTopicApply(TopicApply topicApply);

    TopicApply queryTopicApplyBySid(String sid);

    int deleteTopicApplyBySid(String sid);

    List<StudentTopicVo> queryPageStudentTopicVo(Integer id, Integer page, Integer rows);

    int queryCountStudentTopicVo(Integer id);

    List<StudentTopicVo> queryStudentTopicVoById(Integer id);

    List<StudentTopicVo> queryPageAllStudentTopicVo(Integer page, Integer rows);

    int queryCountAllStudentTopicVo();

    List<StudentTopicVo> queryAllStudentTopicVo();

    List<StudentTopicVo> queryPageStudentTopicVoByGid(Integer gid,Integer page, Integer rows);

    List<StudentTopicVo> queryStudentTopicVoByGid(Integer gid);

    int queryCountStudentTopicVoByGid(Integer gid);

    int updateTopicApplyById(TopicApply topicApply);
}
