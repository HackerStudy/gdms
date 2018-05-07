package com.gdms.service.user.impl;

import com.gdms.dao.TeacherMapper;
import com.gdms.model.Student;
import com.gdms.model.Teacher;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.user.TeacherService;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Service("teacherService")
@Transactional(rollbackFor = Exception.class)
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService {
    private Logger log = Logger.getLogger(TeacherServiceImpl.class);
    @Resource
    private TeacherMapper teacherMapper;

    public Integer insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    public List<Teacher> searchTeacherListByTid(String tid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return teacherMapper.searchTeacherListByTid(tid);
    }

    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    public List<Teacher> getTeacherList(Teacher teacher, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return teacherMapper.getTeacherList(teacher);
    }

    public Teacher queryTeacherByTid(String tid) {
        return teacherMapper.queryTeacherByTid(tid);
    }

    public int queryidByTid(String tid) {
        return teacherMapper.queryidByTid(tid);
    }

}
