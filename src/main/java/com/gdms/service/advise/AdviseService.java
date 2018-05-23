package com.gdms.service.advise;

import com.gdms.model.Advise;
import com.gdms.model.Student;
import com.gdms.service.common.BaseService;
import com.gdms.vo.AdviseStudentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdviseService extends BaseService<Advise> {
    Advise queryAdviseBySid(String sid);

    int insertAdvise(Advise advise);

    int deleteByTidAndSid(String tid,String sid);

    List<Advise> queryPageByTid(String tid,Integer pass,Integer page,Integer rows);

    int queryCount(String tid);

    int updateAdvise(Advise advise);

    List<AdviseStudentVo> queryPageApplyStudent(String tid,Integer page,Integer rows);

    List<AdviseStudentVo> queryApplyStudent(String tid);

    Integer queryCountApplyStudent(String tid);

}
