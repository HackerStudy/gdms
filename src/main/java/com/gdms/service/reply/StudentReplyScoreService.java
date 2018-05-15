package com.gdms.service.reply;

import com.gdms.model.StudentReplyScore;
import com.gdms.model.TopicApply;
import com.gdms.service.common.BaseService;
import com.gdms.vo.ReplyStudentVo;
import com.gdms.vo.StudentReplyScoreVo;

import java.util.List;

public interface StudentReplyScoreService extends BaseService<StudentReplyScore> {
    StudentReplyScore queryStudentReplyScoreBySid(String sid);

    int insertStudentReplyScore(StudentReplyScore studentReplyScore);

    List<StudentReplyScoreVo> queryPageStuentReplyScoreVoByTid(String tid, Integer page, Integer rows);

    List<StudentReplyScoreVo> queryStuentReplyScoreVoByTid(String tid);

    int queryCountStuentReplyScoreVoByTid(String tid);

    List<StudentReplyScoreVo> queryPageStuentReplyScoreVoByGid(Integer gid, Integer page, Integer rows);

    List<StudentReplyScoreVo> queryStuentReplyScoreVoByGid(Integer gid);

    int queryCountStuentReplyScoreVoByGid(Integer gid);
}
