package com.gdms.service.user.impl;

import com.gdms.dao.MajorMapper;
import com.gdms.model.Major;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.user.MajorService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("majorService")
@Transactional(rollbackFor = Exception.class)
public class MajorServiceImpl extends BaseServiceImpl<Major> implements MajorService {
    private Logger log = Logger.getLogger(MajorServiceImpl.class);
    @Resource
    private MajorMapper majorMapper;

    public List<Major> queryAllList() {
        return majorMapper.queryAllList();
    }

    public Major queryMajorByMid(Integer mid) {
        return majorMapper.queryMajorByMid(mid);
    }
}
