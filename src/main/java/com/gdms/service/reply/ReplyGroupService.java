package com.gdms.service.reply;

import com.gdms.model.ReplyGroup;
import com.gdms.model.TopicApply;
import com.gdms.service.common.BaseService;
import com.gdms.vo.ReplyGroupVo;
import com.gdms.vo.StudentTopicVo;

import java.util.List;

public interface ReplyGroupService extends BaseService<ReplyGroup> {
    List<ReplyGroupVo> queryReplyGroupVo();

    List<ReplyGroupVo> queryPageReplyGroupVo(Integer page, Integer rows);

    int queryCountReplyGroupVo();

    int insertReplyGroup(ReplyGroup replyGroup);

    int updateReplyGroup(ReplyGroup replyGroup);

    ReplyGroup queryReplyGroupByGroupLeaderId(String groupLeaderId);

    List<ReplyGroupVo> queryPageReplyGroupVoByGid(Integer gid,Integer page, Integer rows);

    List<ReplyGroupVo> queryReplyGroupVoByGid(Integer gid);

    int queryCountReplyGroupVoByGid(Integer gid);
}
