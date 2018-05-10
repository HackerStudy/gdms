package com.gdms.dao;

import com.gdms.model.Student;
import com.gdms.model.Teacher;
import com.gdms.model.TeacherContact;
import com.gdms.vo.AdviseTeacherVo;
import com.gdms.vo.TeacherInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface TeacherMapper extends Mapper<Teacher> {
    Integer insertTeacher(Teacher teacher);

    List<Teacher> searchTeacherListByTid(@Param("tid") String tid);

    int updateTeacher(Teacher teacher);

    List<Teacher> getTeacherList(Teacher teacher);

    Teacher queryTeacherByTid(@Param("tid") String tid);

    int queryidByTid(@Param("tid") String tid);

    List<Teacher> queryTeacherList();

    List<AdviseTeacherVo> queryAdviseTeacherVoByIdentity();

    int queryCountAdviseTeacherVo();

    List<AdviseTeacherVo> queryAdviseTeacherVoByDid(@Param("did") Integer did,@Param("identity") Integer identity);

    int queryCountAdviseTeacherVoByDid(@Param("did") Integer did,@Param("identity") Integer identity);

    TeacherInfoVo queryTeacherInfoVoByTid(@Param("tid") String tid);
}