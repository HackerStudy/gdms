package com.gdms.service.user;

import com.gdms.model.Student;
import com.gdms.model.Teacher;
import com.gdms.service.common.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService extends BaseService<Teacher> {
    Integer insertTeacher(Teacher teacher);

    List<Teacher> searchTeacherListByTid(String tid, Integer page, Integer rows);

    int updateTeacher(Teacher teacher);

    List<Teacher> getTeacherList(Teacher teacher, Integer page, Integer rows);

    Teacher queryTeacherByTid(String tid);

    int queryidByTid(String tid);
}
