package com.gdms.service.topic.impl;

import com.gdms.dao.StudentMapper;
import com.gdms.dao.TopicApplyMapper;
import com.gdms.model.Advise;
import com.gdms.model.Student;
import com.gdms.model.TopicApply;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.topic.TopicApplyService;
import com.gdms.service.user.StudentService;
import com.gdms.service.user.impl.UserServiceImpl;
import com.gdms.vo.StudentTopicVo;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("topicApplyService")
@Transactional(rollbackFor = Exception.class)
public class TopicApplyServiceImpl extends BaseServiceImpl<TopicApply> implements TopicApplyService {
    private Logger log = Logger.getLogger(TopicApplyServiceImpl.class);
    @Resource
    private TopicApplyMapper topicApplyMapper;

    public int insertTopicApply(TopicApply topicApply) {
        return topicApplyMapper.insertTopicApply(topicApply);
    }

    public TopicApply queryTopicApplyBySid(String sid) {
        return topicApplyMapper.queryTopicApplyBySid(sid);
    }

    public int deleteTopicApplyBySid(String sid) {
        return topicApplyMapper.deleteTopicApplyBySid(sid);
    }

    public List<StudentTopicVo> queryPageStudentTopicVo(Integer id,Integer page, Integer rows) {
            PageHelper.startPage(page, rows);
            return queryStudentTopicVoById(id);
    }

    public int queryCountStudentTopicVo(Integer id) {
        return topicApplyMapper.queryCountStudentTopicVoById(id);
    }

    public List<StudentTopicVo> queryStudentTopicVoById(Integer id) {
        return topicApplyMapper.queryStudentTopicVoById(id);
    }

    public List<StudentTopicVo> queryPageAllStudentTopicVo( Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryAllStudentTopicVo();
    }

    public int queryCountAllStudentTopicVo() {
        return topicApplyMapper.queryCountAllStudentTopicVo();
    }

    public List<StudentTopicVo> queryAllStudentTopicVo() {
        return topicApplyMapper.queryAllStudentTopicVo();
    }

    public List<StudentTopicVo> queryPageStudentTopicVoByGid(Integer gid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryStudentTopicVoByGid(gid);
    }

    public List<StudentTopicVo> queryStudentTopicVoByGid(Integer gid) {
        return topicApplyMapper.queryStudentTopicVoByGid(gid);
    }

    public int queryCountStudentTopicVoByGid(Integer gid) {
        return topicApplyMapper.queryCountStudentTopicVoByGid(gid);
    }

    public int updateTopicApplyById(TopicApply topicApply) {
        return topicApplyMapper.updateTopicApplyById(topicApply);
    }
}
