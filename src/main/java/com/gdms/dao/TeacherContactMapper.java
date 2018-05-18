package com.gdms.dao;

import com.gdms.model.Admin;
import com.gdms.model.Teacher;
import com.gdms.model.TeacherContact;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TeacherContactMapper  extends Mapper<TeacherContact> {

    List<TeacherContact> getTeacherContactList(TeacherContact teacherContact);

    List<TeacherContact> queryTeacherContactList();

    int updateTeacherContactByTid(TeacherContact teacherContact);

    TeacherContact queryTeacherContactByTid(String tid);

    int insertTeacherContact(TeacherContact teacherContact);

    int deleteTeacherContactByTid(String tid);
}