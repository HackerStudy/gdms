package com.gdms.dao;

import com.gdms.model.Admin;
import com.gdms.model.Department;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface DepartmentMapper extends Mapper<Department> {
    List<Department> queryAllList();
}