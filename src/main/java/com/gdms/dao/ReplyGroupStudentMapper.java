package com.gdms.dao;

import com.gdms.model.ReplyGroupStudent;
import com.gdms.model.ReplyGroupTeacher;
import com.gdms.model.TopicApply;
import com.gdms.vo.ReplyStudentVo;
import com.gdms.vo.ReplyTeacherVo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface ReplyGroupStudentMapper extends Mapper<ReplyGroupStudent> {
    List<ReplyStudentVo> queryReplyStudentVo();

    ReplyGroupStudent queryReplyGroupStudentBySid(String sid);

    int insertReplyGroupStudent(ReplyGroupStudent replyGroupStudent);

    List<ReplyStudentVo> queryReplyStudentVoByGid(Integer gid);

    int queryCountReplyStudentVoByGid(Integer gid);

    List<ReplyGroupStudent> queryReplyGroupStudentByGid(Integer gid);

}