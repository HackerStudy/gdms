package com.gdms.dao;

import com.gdms.model.AdviseTeacher;
import tk.mybatis.mapper.common.Mapper;

public interface AdviseTeacherMapper extends Mapper<AdviseTeacher> {
    AdviseTeacher queryAdviseTeacherByTid(String tid);

    int updateAdviseTeacher(AdviseTeacher adviseTeacher);

    int updateAdviseTeacherByTid(AdviseTeacher adviseTeacher);

    int insertAdviseTeacherByTid(AdviseTeacher adviseTeacher);
}