package com.gdms.service.user.impl;

import com.gdms.dao.StudentMapper;
import com.gdms.model.Student;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.user.StudentService;
import com.gdms.vo.AdviseStudentVo;
import com.gdms.vo.StudentInfoVo;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {
    private Logger log = Logger.getLogger(UserServiceImpl.class);
    @Resource
    private StudentMapper studentMapper;

    public Integer insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    public List<Student> searchStudentListBySid(String sid,Integer page,Integer rows) {
        PageHelper.startPage(page, rows);
        return studentMapper.searchStudentListBySid(sid);
    }

    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public List<Student> getStudentList(Student student,Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return studentMapper.getStudentList(student);
    }

    public Student queryStudentBySid(String sid) {
        return studentMapper.queryStudentBySid(sid);
    }

    public int queryIdBySid(String sid) {
        return studentMapper.queryIdBySid(sid);
    }

    public int updateNewStudent(Integer adviserid, Integer id) {
        return studentMapper.updateNewStudent(adviserid,id);
    }

    public List<AdviseStudentVo> queryPageAdviseStudent(String tid, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryAdviseStudent(tid);
    }

    public List<AdviseStudentVo> queryAdviseStudent(String tid) {
        return studentMapper.queryAdviseStudent(tid);
    }

    public Integer queryCountAdviseStudent(String tid) {
        return studentMapper.queryCountAdviseStudent(tid);
    }

    public StudentInfoVo queryStudentInfoVoBySid(String sid) {
        return studentMapper.queryStudentInfoVoBySid(sid);
    }

    public List<AdviseStudentVo> queryPageDistributionStudent(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return queryDistributionStudent();
    }

    public List<AdviseStudentVo> queryDistributionStudent() {
        return studentMapper.queryDistributionStudent();
    }

    public Integer queryCountDistributionStudent() {
        return studentMapper.queryCountDistributionStudent();
    }

}
