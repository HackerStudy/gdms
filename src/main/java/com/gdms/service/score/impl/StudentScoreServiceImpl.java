package com.gdms.service.score.impl;

import com.gdms.dao.AdviserScoreMapper;
import com.gdms.dao.StudentScoreMapper;
import com.gdms.model.AdviserScore;
import com.gdms.model.StudentScore;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.score.AdviserScoreService;
import com.gdms.service.score.StudentScoreService;
import com.gdms.service.user.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("StudentScoreService")
@Transactional(rollbackFor = Exception.class)
public class StudentScoreServiceImpl extends BaseServiceImpl<StudentScore> implements StudentScoreService {
    private Logger log = Logger.getLogger(StudentScoreServiceImpl.class);
    @Resource
    private StudentScoreMapper studentScoreMapper;
}
