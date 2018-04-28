package com.gdms.dao;

import com.gdms.model.GGroupLimit;
import com.gdms.vo.LimitVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface GGroupLimitMapper extends Mapper<GGroupLimit> {

    List<LimitVo> getModelByGroupId(@Param("groupId") Integer groupId);

    List<GGroupLimit>  getModelByGroupIdAndLimitId(@Param("adminid")int adminid,@Param("id")int id);

    void delByGroupId(Integer integer);

    List<GGroupLimit> getListByGroupId(Integer integer);
}