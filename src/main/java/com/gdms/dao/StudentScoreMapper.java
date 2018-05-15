package com.gdms.dao;

import com.gdms.model.Student;
import com.gdms.model.StudentScore;
import com.gdms.vo.StudentScoreVo;
import com.gdms.vo.ConfirmScore;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface StudentScoreMapper extends Mapper<StudentScore> {
    StudentScore queryStudentScoreBySid(String sid);

    List<StudentScoreVo> queryStudentScoreVoByTid(String tid);

    int queryCountStudentScoreVoByTid(String tid);

    List<StudentScoreVo> queryStudentScoreVoByGid(Integer gid);

    int queryCountStudentScoreVoByGid(Integer gid);

    List<StudentScoreVo> queryStudentScoreVo();

    int queryCountStudentScoreVo();

    List<ConfirmScore> queryFinalScoreVo();

    int insertStudentScore(StudentScore studentScore);

    int queryCountFinalScoreVo();
}