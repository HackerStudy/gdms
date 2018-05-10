package com.gdms.service.advise.impl;

import com.gdms.dao.AdviseMapper;
import com.gdms.dao.StudentMapper;
import com.gdms.model.Advise;
import com.gdms.model.Student;
import com.gdms.service.advise.AdviseService;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.user.StudentService;
import com.gdms.service.user.impl.UserServiceImpl;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("adviseService")
@Transactional(rollbackFor = Exception.class)
public class AdviseServiceImpl extends BaseServiceImpl<Advise> implements AdviseService {
    private Logger log = Logger.getLogger(UserServiceImpl.class);
    @Resource
    private AdviseMapper adviseMapper;

    public Advise queryAdviseBySid(String sid) {
        return adviseMapper.queryAdviseBySid(sid);
    }

    public int insertAdvise(Advise advise) {
        return adviseMapper.insertAdvise(advise);
    }

    public int deleteByTidAndSid(String tid, String sid) {
        return adviseMapper.deleteByTidAndSid(tid,sid);
    }

    public List<Advise> queryPageByTid(String tid,Integer pass, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return adviseMapper.getAdviseList(tid,pass);
    }

    public int queryCount(String tid) {
        return adviseMapper.queryCount(tid);
    }

    public int updateAdvise(Advise advise) {
        return adviseMapper.updateAdvise(advise);
    }

}
