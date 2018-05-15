package com.gdms.service.reply;

import com.gdms.model.ReplyGroupTeacher;
import com.gdms.model.TopicApply;
import com.gdms.service.common.BaseService;
import com.gdms.vo.ReplyGroupVo;
import com.gdms.vo.ReplyTeacherVo;

import java.util.List;

public interface ReplyGroupTeacherService extends BaseService<ReplyGroupTeacher> {
    List<ReplyTeacherVo> queryReplyTeacherVo();

    int queryCountReplyTeacherVo();

    int insertReplyGroupTeacher(ReplyGroupTeacher replyGroupTeacher);

    ReplyGroupTeacher queryReplyGroupTeacherByTid(String tid);

    List<ReplyTeacherVo> queryPageReplyTeacherVo(Integer gid,Integer page, Integer rows);

    List<ReplyTeacherVo> queryReplyTeacherVoByGid(Integer gid);

    int queryCountReplyTeacherVoByGid(Integer gid);

//    List<ReplyTeacherVo> queryPageReplyTeacherVo(Integer gid,Integer page, Integer rows);
}
