package com.gdms.dao;

import com.gdms.model.Admin;
import com.gdms.model.Major;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface MajorMapper extends Mapper<Major> {
    List<Major> queryAllList();

    Major queryMajorByMid(Integer mid);
}