package com.gdms.dao;

import com.gdms.model.Advise;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdviseMapper extends Mapper<Advise> {
    int deleteByPrimaryKey(Integer id);

    int insert(Advise record);

    int insertSelective(Advise record);

    Advise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advise record);

    int updateByPrimaryKey(Advise record);

    Advise queryAdviseBySid(@Param("sid")String sid);

    int insertAdvise(Advise advise);

    int deleteByTidAndSid(@Param("tid") String tid,@Param("sid") String sid);

    List<Advise> getAdviseList(@Param("tid") String tid,@Param("pass") Integer pass);

    int queryCount(String tid);

    int updateAdvise(Advise advise);
}