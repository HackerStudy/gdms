package com.gdms.service.advise.impl;


import com.gdms.dao.AdviseMapper;
import com.gdms.dao.AdviseTAndSMapper;
import com.gdms.dao.AdviseTeacherMapper;
import com.gdms.model.Advise;
import com.gdms.model.AdviseTeacher;
import com.gdms.service.advise.AdviseService;
import com.gdms.service.advise.AdviseTeacherService;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.user.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("adviseTeacherService")
@Transactional(rollbackFor = Exception.class)
public class AdviseTeacherServiceImpl extends BaseServiceImpl<AdviseTeacher> implements AdviseTeacherService {
    private Logger log = Logger.getLogger(AdviseTeacherServiceImpl.class);
    @Resource
    private AdviseTeacherMapper adviseTeacherMapper;

    public AdviseTeacher queryAdviseTeacherByTid(String tid) {
        return adviseTeacherMapper.queryAdviseTeacherByTid(tid);
    }

    public int updateAdviseTeacher(AdviseTeacher adviseTeacher) {
        return adviseTeacherMapper.updateAdviseTeacher(adviseTeacher);
    }

    public int updateAdviseTeacherByTid(AdviseTeacher adviseTeacher) {
        return adviseTeacherMapper.updateAdviseTeacherByTid(adviseTeacher);
    }
}
