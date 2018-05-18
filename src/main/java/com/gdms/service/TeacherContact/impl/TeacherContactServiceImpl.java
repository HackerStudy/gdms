package com.gdms.service.TeacherContact.impl;

import com.gdms.dao.StudentMapper;
import com.gdms.dao.TeacherContactMapper;
import com.gdms.model.Advise;
import com.gdms.model.Teacher;
import com.gdms.model.TeacherContact;
import com.gdms.service.TeacherContact.TeacherContactService;
import com.gdms.service.advise.AdviseService;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.user.impl.UserServiceImpl;
import com.github.pagehelper.PageHelper;
import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Service("teacherContactService")
@Transactional(rollbackFor = Exception.class)
public class TeacherContactServiceImpl extends BaseServiceImpl<TeacherContact> implements TeacherContactService {
    private Logger log = Logger.getLogger(UserServiceImpl.class);
    @Resource
    private TeacherContactMapper teacherContactMapper;

    public List<TeacherContact> getTeacherContactList(TeacherContact teacherContact, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return teacherContactMapper.getTeacherContactList(teacherContact);
    }

    public List<TeacherContact> queryTeacherContactList() {
        return teacherContactMapper.queryTeacherContactList();
    }

    public int updateTeacherContactByTid(TeacherContact teacherContact) {
        return teacherContactMapper.updateTeacherContactByTid(teacherContact);
    }

    public TeacherContact queryTeacherContactByTid(String tid) {
        return teacherContactMapper.queryTeacherContactByTid(tid);
    }

    public int insertTeacherContact(TeacherContact teacherContact) {
        return teacherContactMapper.insertTeacherContact(teacherContact);
    }

    public int deleteTeacherContactByTid(String tid) {
        return teacherContactMapper.deleteTeacherContactByTid(tid);
    }
}
