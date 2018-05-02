package com.gdms.service.user;

import com.gdms.model.Student;
import com.gdms.model.Teacher;
import com.gdms.vo.LimitVo;

import java.util.List;

public interface UserService {
    List<LimitVo> limitgrouplogin(int identityid);
    Student selectStudentByid(String username);
    Teacher selectTeacherById(String username);
    int findIdentityidByTid(String username);
}
