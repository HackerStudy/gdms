package com.gdms.service.score;

import com.gdms.model.StudentScore;
import com.gdms.service.common.BaseService;
import com.gdms.vo.StudentScoreVo;
import com.gdms.vo.ConfirmScore;

import java.util.List;

public interface StudentScoreService extends BaseService<StudentScore> {
    StudentScore queryStudentScoreBySid(String sid);

    List<StudentScoreVo> queryPageStudentScoreVoByTid(String tid, Integer page, Integer rows);

    List<StudentScoreVo> queryStudentScoreVoByTid(String tid);

    int queryCountStudentScoreVoByTid(String tid);

    List<StudentScoreVo> queryPageStudentScoreVoByGid(Integer gid, Integer page, Integer rows);

    List<StudentScoreVo> queryStudentScoreVoByGid(Integer gid);

    int queryCountStudentScoreVoByGid(Integer gid);

    List<StudentScoreVo> queryPageStudentScoreVo( Integer page, Integer rows);

    List<StudentScoreVo> queryStudentScoreVo();

    int queryCountStudentScoreVo();

    List<ConfirmScore> queryPageFinalScoreVo(Integer page, Integer rows);

    List<ConfirmScore> queryFinalScoreVo();

    int queryCountFinalScoreVo();

    int insertStudentScore(StudentScore studentScore);

}
