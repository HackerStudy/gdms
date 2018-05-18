package com.gdms.dao;

import com.gdms.model.Student;
import com.gdms.model.StudentReplyScore;
import com.gdms.model.TopicApply;
import com.gdms.vo.StudentReplyScoreVo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface StudentReplyScoreMapper extends Mapper<StudentReplyScore> {
    StudentReplyScore queryStudentReplyScoreBySid(String sid);

    int insertStudentReplyScore(StudentReplyScore studentReplyScore);

    List<StudentReplyScoreVo> queryStuentReplyScoreVoByTid(String tid);

    int queryCountStuentReplyScoreVoByTid(String tid);

    List<StudentReplyScoreVo> queryStuentReplyScoreVoByGid(Integer gid);

    int queryCountStuentReplyScoreVoByGid(Integer gid);

    int updateStudentReplyScore(StudentReplyScore studentReplyScore);
}