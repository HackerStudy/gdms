package com.gdms.service.reply.impl;

import com.gdms.dao.ReplyGroupMapper;
import com.gdms.dao.TopicApplyMapper;
import com.gdms.model.ReplyGroup;
import com.gdms.model.TopicApply;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReplyGroupService;
import com.gdms.service.topic.TopicApplyService;
import com.gdms.service.topic.impl.TopicApplyServiceImpl;
import com.gdms.vo.ReplyGroupVo;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("replyGroupService")
@Transactional(rollbackFor = Exception.class)
public class ReplyGroupServiceImpl extends BaseServiceImpl<ReplyGroup> implements ReplyGroupService {
    private Logger log = Logger.getLogger(ReplyGroupServiceImpl.class);
    @Resource
    private ReplyGroupMapper replyGroupMapper;

    public List<ReplyGroupVo> queryReplyGroupVo() {
        return replyGroupMapper.queryReplyGroupVo();
    }

    public List<ReplyGroupVo> queryPageReplyGroupVo(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryReplyGroupVo();
    }

    public int queryCountReplyGroupVo() {
        return replyGroupMapper.queryCountReplyGroupVo();
    }

    public int insertReplyGroup(ReplyGroup replyGroup) {
        return replyGroupMapper.insertReplyGroup(replyGroup);
    }

    public int updateReplyGroup(ReplyGroup replyGroup) {
        return replyGroupMapper.updateReplyGroup(replyGroup);
    }

    public ReplyGroup queryReplyGroupByGroupLeaderId(String groupLeaderId) {
        return replyGroupMapper.queryReplyGroupByGroupLeaderId(groupLeaderId);
    }

    public List<ReplyGroupVo> queryPageReplyGroupVoByGid(Integer gid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryReplyGroupVoByGid(gid);
    }

    public List<ReplyGroupVo> queryReplyGroupVoByGid(Integer gid) {
        return replyGroupMapper.queryReplyGroupVoByGid(gid);
    }

    public int queryCountReplyGroupVoByGid(Integer gid) {
        return replyGroupMapper.queryCountReplyGroupVoByGid(gid);
    }
}
