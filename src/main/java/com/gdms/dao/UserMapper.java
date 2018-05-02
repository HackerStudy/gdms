package com.gdms.dao;

import com.gdms.model.Student;
import com.gdms.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    Student selectStudentByid(@Param("username") String username);
    Teacher selectTeacherById(@Param("username") String username);
    int findIdentityByTid(@Param("username") String username);
}
