package com.gdms.service.reply.impl;

import com.gdms.dao.ReplyGroupTeacherMapper;
import com.gdms.model.ReplyGroupTeacher;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReplyGroupTeacherService;
import com.gdms.vo.ReplyTeacherVo;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("replyGroupTeacherService")
@Transactional(rollbackFor = Exception.class)
public class ReplyGroupTeacherServiceImpl extends BaseServiceImpl<ReplyGroupTeacher> implements ReplyGroupTeacherService {
    private Logger log = Logger.getLogger(ReplyGroupTeacherServiceImpl.class);
    @Resource
    private ReplyGroupTeacherMapper replyGroupTeacherMapper;

    public List<ReplyTeacherVo> queryReplyTeacherVo() {
        return replyGroupTeacherMapper.queryReplyTeacherVo();
    }

    public int queryCountReplyTeacherVo() {
        return replyGroupTeacherMapper.queryCountReplyTeacherVo();
    }

    public int insertReplyGroupTeacher(ReplyGroupTeacher replyGroupTeacher) {
        return replyGroupTeacherMapper.insertReplyGroupTeacher(replyGroupTeacher);
    }

    public ReplyGroupTeacher queryReplyGroupTeacherByTid(String tid) {
        return replyGroupTeacherMapper.queryReplyGroupTeacherByTid(tid);
    }

    public List<ReplyTeacherVo> queryPageReplyTeacherVo(Integer gid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryReplyTeacherVoByGid(gid);
    }

    public List<ReplyTeacherVo> queryReplyTeacherVoByGid(Integer gid) {
        return replyGroupTeacherMapper.queryReplyTeacherVoByGid(gid);
    }

    public int queryCountReplyTeacherVoByGid(Integer gid) {
        return replyGroupTeacherMapper.queryCountReplyTeacherVoByGid(gid);
    }

//    public List<ReplyTeacherVo> queryPageReplyTeacherVo(Integer gid, Integer page, Integer rows) {
//        PageHelper.startPage(page, rows);
//        return queryReplyTeacherVo(gid);
//    }
}
