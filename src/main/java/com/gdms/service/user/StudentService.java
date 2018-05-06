package com.gdms.service.user;
import com.gdms.model.Student;
import com.gdms.service.common.BaseService;

import java.util.List;

public interface StudentService extends BaseService<Student> {
    Integer insertStudent(Student student);

    List<Student> searchStudentListBySid(String sid,Integer page,Integer rows);

    int updateStudent(Student student);

    List<Student> getStudentList(Student student,Integer page,Integer rows);
}
