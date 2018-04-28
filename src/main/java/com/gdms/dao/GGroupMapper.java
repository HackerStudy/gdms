package com.gdms.dao;

import com.gdms.model.GGroup;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface GGroupMapper extends Mapper<GGroup> {

    List<GGroup> getListByGroupName(GGroup gGroup);
}