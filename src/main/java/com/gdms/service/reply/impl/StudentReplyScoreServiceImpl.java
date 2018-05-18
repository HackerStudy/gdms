package com.gdms.service.reply.impl;

import com.gdms.dao.ReviewStatusMapper;
import com.gdms.dao.StudentReplyScoreMapper;
import com.gdms.model.ReviewStatus;
import com.gdms.model.StudentReplyScore;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.reply.ReviewStatusService;
import com.gdms.service.reply.StudentReplyScoreService;
import com.gdms.service.score.ReplyScoreService;
import com.gdms.vo.StudentReplyScoreVo;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("studentReplyScoreService")
@Transactional(rollbackFor = Exception.class)
public class StudentReplyScoreServiceImpl extends BaseServiceImpl<StudentReplyScore> implements StudentReplyScoreService {
    private Logger log = Logger.getLogger(StudentReplyScoreServiceImpl.class);
    @Resource
    private StudentReplyScoreMapper studentReplyScoreMapper;

    public StudentReplyScore queryStudentReplyScoreBySid(String sid) {
        return studentReplyScoreMapper.queryStudentReplyScoreBySid(sid);
    }

    public int insertStudentReplyScore(StudentReplyScore studentReplyScore) {
        return studentReplyScoreMapper.insertStudentReplyScore(studentReplyScore);
    }

    public List<StudentReplyScoreVo> queryPageStuentReplyScoreVoByTid(String tid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryStuentReplyScoreVoByTid(tid);
    }

    public List<StudentReplyScoreVo> queryStuentReplyScoreVoByTid(String tid) {
        return studentReplyScoreMapper.queryStuentReplyScoreVoByTid(tid);
    }

    public int queryCountStuentReplyScoreVoByTid(String tid) {
        return studentReplyScoreMapper.queryCountStuentReplyScoreVoByTid(tid);
    }

    public List<StudentReplyScoreVo> queryPageStuentReplyScoreVoByGid(Integer gid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryStuentReplyScoreVoByGid(gid);
    }

    public List<StudentReplyScoreVo> queryStuentReplyScoreVoByGid(Integer gid) {
        return studentReplyScoreMapper.queryStuentReplyScoreVoByGid(gid);
    }

    public int queryCountStuentReplyScoreVoByGid(Integer gid) {
        return studentReplyScoreMapper.queryCountStuentReplyScoreVoByGid(gid);
    }

    public int updateStudentReplyScore(StudentReplyScore studentReplyScore) {
        return studentReplyScoreMapper.updateStudentReplyScore(studentReplyScore);
    }
}
