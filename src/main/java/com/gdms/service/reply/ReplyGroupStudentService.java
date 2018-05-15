package com.gdms.service.reply;

import com.gdms.model.ReplyGroupStudent;
import com.gdms.model.TopicApply;
import com.gdms.service.common.BaseService;
import com.gdms.vo.ReplyStudentVo;
import com.gdms.vo.ReplyTeacherVo;

import java.util.List;

public interface ReplyGroupStudentService extends BaseService<ReplyGroupStudent> {
    List<ReplyStudentVo> queryReplyStudentVo();

    ReplyGroupStudent queryReplyGroupStudentBySid(String sid);

    int insertReplyGroupStudent(ReplyGroupStudent replyGroupStudent);

    List<ReplyStudentVo> queryPageReplyStudentVo(Integer gid, Integer page, Integer rows);

    List<ReplyStudentVo> queryReplyStudentVoByGid(Integer gid);

    int queryCountReplyStudentVoByGid(Integer gid);

    List<ReplyGroupStudent> queryReplyGroupStudentByGid(Integer gid);
}
