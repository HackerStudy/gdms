package com.gdms.service.advise.impl;

import com.gdms.dao.AdviseMapper;
import com.gdms.dao.AdviseTAndSMapper;
import com.gdms.dao.AdviseTeacherMapper;
import com.gdms.model.Advise;
import com.gdms.model.AdviseTAndS;
import com.gdms.service.advise.AdviseService;
import com.gdms.service.advise.AdviseTAndSService;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.user.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("adviseTAndSService")
@Transactional(rollbackFor = Exception.class)
public class AdviseTAndSServiceImpl extends BaseServiceImpl<AdviseTAndS> implements AdviseTAndSService{
    private Logger log = Logger.getLogger(UserServiceImpl.class);
    @Resource
    private AdviseTAndSMapper adviseTAndSMapper;

    public int updateAdviseTAndS(AdviseTAndS adviseTAndS) {
        return adviseTAndSMapper.updateAdviseTAndS(adviseTAndS);
    }

    public int insertAdviseTAndS(AdviseTAndS adviseTAndS) {
        return adviseTAndSMapper.insertAdviseTAndS(adviseTAndS);
    }
}
