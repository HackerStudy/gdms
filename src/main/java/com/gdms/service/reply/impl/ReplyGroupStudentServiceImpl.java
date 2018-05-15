package com.gdms.service.reply.impl;

import com.gdms.dao.ReplyGroupMapper;
import com.gdms.dao.ReplyGroupStudentMapper;
import com.gdms.dao.ReplyGroupTeacherMapper;
import com.gdms.model.ReplyGroupStudent;
import com.gdms.model.ReplyGroupTeacher;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReplyGroupService;
import com.gdms.service.reply.ReplyGroupStudentService;
import com.gdms.service.reply.ReplyGroupTeacherService;
import com.gdms.vo.ReplyStudentVo;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("replyGroupStudentService")
@Transactional(rollbackFor = Exception.class)
public class ReplyGroupStudentServiceImpl extends BaseServiceImpl<ReplyGroupStudent> implements ReplyGroupStudentService {
    private Logger log = Logger.getLogger(ReplyGroupStudentServiceImpl.class);
    @Resource
    private ReplyGroupStudentMapper replyGroupStudentMapper;

    public List<ReplyStudentVo> queryReplyStudentVo() {
        return replyGroupStudentMapper.queryReplyStudentVo();
    }

    public ReplyGroupStudent queryReplyGroupStudentBySid(String sid) {
        return replyGroupStudentMapper.queryReplyGroupStudentBySid(sid);
    }

    public int insertReplyGroupStudent(ReplyGroupStudent replyGroupStudent) {
        return replyGroupStudentMapper.insertReplyGroupStudent(replyGroupStudent);
    }

    public List<ReplyStudentVo> queryPageReplyStudentVo(Integer gid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryReplyStudentVoByGid(gid);
    }

    public List<ReplyStudentVo> queryReplyStudentVoByGid(Integer gid) {
        return replyGroupStudentMapper.queryReplyStudentVoByGid(gid);
    }

    public int queryCountReplyStudentVoByGid(Integer gid) {
        return replyGroupStudentMapper.queryCountReplyStudentVoByGid(gid);
    }

    public List<ReplyGroupStudent> queryReplyGroupStudentByGid(Integer gid) {
        return replyGroupStudentMapper.queryReplyGroupStudentByGid(gid);
    }
}
