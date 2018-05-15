package com.gdms.dao;

import com.gdms.model.ReplyReview;
import com.gdms.vo.ReviewVo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface ReplyReviewMapper extends Mapper<ReplyReview> {

    int insertReplyReview(ReplyReview replyReview);

    List<ReviewVo> queryReviewVoByGid(Integer gid);

    int queryCountReviewVoByGid(Integer gid);
}