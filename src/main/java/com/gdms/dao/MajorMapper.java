package com.gdms.dao;

import com.gdms.model.Department;
import com.gdms.model.Major;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface MajorMapper extends Mapper<Major> {
    int deleteByPrimaryKey(Integer mid);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    List<Major> queryAllList();
}