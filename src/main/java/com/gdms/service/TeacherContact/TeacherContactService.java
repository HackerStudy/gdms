package com.gdms.service.TeacherContact;

import com.gdms.model.Advise;
import com.gdms.model.Teacher;
import com.gdms.model.TeacherContact;
import com.gdms.service.common.BaseService;

import java.util.List;

public interface TeacherContactService  extends BaseService<TeacherContact> {

    List<TeacherContact> getTeacherContactList(TeacherContact teacherContact, Integer page, Integer rows);

    List<TeacherContact> queryTeacherContactList();

    int updateTeacherContactByTid(TeacherContact teacherContact);

    TeacherContact queryTeacherContactByTid(String tid);

    int insertTeacherContact(TeacherContact teacherContact);

    int deleteTeacherContactByTid(String tid);
}
