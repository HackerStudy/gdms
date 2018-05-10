package com.gdms.dao;

import com.gdms.model.Advise;
import com.gdms.model.AdviseTAndS;
import tk.mybatis.mapper.common.Mapper;

public interface AdviseTAndSMapper extends Mapper<AdviseTAndS> {
    int deleteByPrimaryKey(Integer id);

    int insert(AdviseTAndS record);

    int insertSelective(AdviseTAndS record);

    AdviseTAndS selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdviseTAndS record);

    int updateByPrimaryKey(AdviseTAndS record);

    int updateAdviseTAndS(AdviseTAndS adviseTAndS);

    int insertAdviseTAndS(AdviseTAndS adviseTAndS);
}