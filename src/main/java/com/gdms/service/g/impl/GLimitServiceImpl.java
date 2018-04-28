package com.gdms.service.g.impl;

import com.gdms.dao.GLimitMapper;
import com.gdms.model.GLimit;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.g.GLimitService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class GLimitServiceImpl  extends BaseServiceImpl<GLimit> implements GLimitService {
    private Logger log = Logger.getLogger(GLimitServiceImpl.class);

    @Resource
    private GLimitMapper gLimitMapper;

}
