package com.gdms.dao;

import com.gdms.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface StudentMapper extends Mapper<Student> {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int updateStudent(Student student);

    Integer insertStudent(Student student);

    List<Student> searchStudentListBySid(@Param("sid") String sid);

    List<Student> getStudentList(Student student);

    Student queryStudentBySid(@Param("sid") String sid);

    int queryIdBySid(@Param("sid") String sid);
}