package com.gdms.service.reply;

import com.gdms.model.ReplyReview;
import com.gdms.model.TopicApply;
import com.gdms.service.common.BaseService;
import com.gdms.vo.ReplyTeacherVo;
import com.gdms.vo.ReviewVo;

import java.util.List;

public interface ReplyReviewService extends BaseService<ReplyReview> {

    int insertReplyReview(ReplyReview replyReview);

    List<ReviewVo> queryPageReviewVoByGid(Integer gid, Integer page, Integer rows);

    List<ReviewVo> queryReviewVoByGid(Integer gid);

    int queryCountReviewVoByGid(Integer gid);
}
