package com.gdms.service.user;

import com.gdms.model.Student;
import com.gdms.model.Teacher;
import com.gdms.model.TeacherContact;
import com.gdms.service.common.BaseService;
import com.gdms.vo.AdviseTeacherVo;
import com.gdms.vo.TeacherInfoVo;
import com.gdms.vo.TeacherVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService extends BaseService<Teacher> {
    Integer insertTeacher(Teacher teacher);

    List<Teacher> searchTeacherListByTid(String tid, Integer page, Integer rows);

    int updateTeacher(Teacher teacher);

    List<Teacher> getTeacherList(Teacher teacher, Integer page, Integer rows);

    int queryCountByCondition(Teacher teacher);

    Teacher queryTeacherByTid(String tid);

    int queryidByTid(String tid);

    List<Teacher> queryTeacherList();

    List<Teacher> getPageTeacherList(Integer page,Integer rows);

    List<AdviseTeacherVo> queryPageAdviseTeacherVoList(Integer page, Integer rows);

    List<AdviseTeacherVo> queryAdviseTeacherVoList();

    int queryCountAdviseTeacherVo();

    List<AdviseTeacherVo> queryPageAdviseTeacherVoListByDid(Integer did,Integer identity,Integer page, Integer rows);

    List<AdviseTeacherVo> queryAdviseTeacherVoListByDid(Integer did,Integer identity);

    int queryCountAdviseTeacherVoByDid(Integer did,Integer identity);

    TeacherInfoVo queryTeacherInfoVoByTid(String tid);

    List<Teacher> queryTeacherByIdentity(Integer identity);

    List<TeacherVo> queryPageTeacherVoList(Teacher teacher, Integer page, Integer rows);

    List<TeacherVo> queryTeacherVo(Teacher teacher);

    int queryCountTeacherVo(Teacher teacher);

}
