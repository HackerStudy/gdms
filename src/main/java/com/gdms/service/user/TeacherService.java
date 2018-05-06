package com.gdms.service.user;

import com.gdms.model.Teacher;
import com.gdms.service.common.BaseService;

import java.util.List;

public interface TeacherService extends BaseService<Teacher> {
    Integer insertTeacher(Teacher teacher);

    List<Teacher> searchTeacherListByTid(String tid, Integer page, Integer rows);

    int updateTeacher(Teacher teacher);
}
