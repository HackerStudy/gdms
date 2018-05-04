package com.gdms.service.user.impl;

import com.gdms.dao.GGroupLimitMapper;
import com.gdms.dao.StudentMapper;
import com.gdms.dao.UserMapper;
import com.gdms.model.Student;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.user.StudentService;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
}
