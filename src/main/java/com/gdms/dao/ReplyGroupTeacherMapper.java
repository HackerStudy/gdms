package com.gdms.dao;

import com.gdms.model.Admin;
import com.gdms.model.ReplyGroupTeacher;
import com.gdms.vo.ReplyTeacherVo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface ReplyGroupTeacherMapper extends Mapper<ReplyGroupTeacher> {
    List<ReplyTeacherVo> queryReplyTeacherVo();

    int queryCountReplyTeacherVo();

    int insertReplyGroupTeacher(ReplyGroupTeacher replyGroupTeacher);

    ReplyGroupTeacher queryReplyGroupTeacherByTid(String tid);

    List<ReplyTeacherVo> queryReplyTeacherVoByGid(Integer gid);

    int queryCountReplyTeacherVoByGid(Integer gid);
}