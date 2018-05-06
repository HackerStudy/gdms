package com.gdms.dao;

import com.gdms.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface TeacherMapper extends Mapper<Teacher> {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Integer insertTeacher(Teacher teacher);

    List<Teacher> searchTeacherListByTid(@Param("tid") String tid);

    int updateTeacher(Teacher teacher);
}