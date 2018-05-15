package com.gdms.dao;

import com.gdms.model.ReplyGroup;
import com.gdms.model.TopicApply;
import com.gdms.vo.ReplyGroupVo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface ReplyGroupMapper extends Mapper<ReplyGroup> {
    List<ReplyGroupVo> queryReplyGroupVo();

    int queryCountReplyGroupVo();

    int insertReplyGroup(ReplyGroup replyGroup);

    int updateReplyGroup(ReplyGroup replyGroup);

    ReplyGroup queryReplyGroupByGroupLeaderId(String groupLeaderId);

    List<ReplyGroupVo> queryReplyGroupVoByGid(Integer gid);

    int queryCountReplyGroupVoByGid(Integer gid);
}