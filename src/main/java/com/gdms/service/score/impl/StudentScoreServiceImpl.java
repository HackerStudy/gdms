package com.gdms.service.score.impl;

import com.gdms.dao.StudentScoreMapper;
import com.gdms.model.StudentScore;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.score.StudentScoreService;
import com.gdms.vo.StudentScoreVo;
import com.gdms.vo.ConfirmScore;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("StudentScoreService")
@Transactional(rollbackFor = Exception.class)
public class StudentScoreServiceImpl extends BaseServiceImpl<StudentScore> implements StudentScoreService {
    private Logger log = Logger.getLogger(StudentScoreServiceImpl.class);
    @Resource
    private StudentScoreMapper studentScoreMapper;

    public StudentScore queryStudentScoreBySid(String sid) {
        return studentScoreMapper.queryStudentScoreBySid(sid);
    }

    public List<StudentScoreVo> queryPageStudentScoreVoByTid(String tid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryStudentScoreVoByTid(tid);
    }

    public List<StudentScoreVo> queryStudentScoreVoByTid(String tid) {
        return studentScoreMapper.queryStudentScoreVoByTid(tid);
    }

    public int queryCountStudentScoreVoByTid(String tid) {
        return studentScoreMapper.queryCountStudentScoreVoByTid(tid);
    }

    public List<StudentScoreVo> queryPageStudentScoreVoByGid(Integer gid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryStudentScoreVoByGid(gid);
    }

    public List<StudentScoreVo> queryStudentScoreVoByGid(Integer gid) {
        return studentScoreMapper.queryStudentScoreVoByGid(gid);
    }

    public int queryCountStudentScoreVoByGid(Integer gid) {
        return studentScoreMapper.queryCountStudentScoreVoByGid(gid);
    }

    public List<StudentScoreVo> queryPageStudentScoreVo(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryStudentScoreVo();
    }

    public List<StudentScoreVo> queryStudentScoreVo() {
        return studentScoreMapper.queryStudentScoreVo();
    }

    public int queryCountStudentScoreVo() {
        return studentScoreMapper.queryCountStudentScoreVo();
    }

    public List<ConfirmScore> queryPageFinalScoreVo(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryFinalScoreVo();
    }

    public List<ConfirmScore> queryFinalScoreVo() {
        return studentScoreMapper.queryFinalScoreVo();
    }

    public int queryCountFinalScoreVo() {
        return studentScoreMapper.queryCountFinalScoreVo();
    }

    public int insertStudentScore(StudentScore studentScore) {
        return studentScoreMapper.insertStudentScore(studentScore);
    }
}
