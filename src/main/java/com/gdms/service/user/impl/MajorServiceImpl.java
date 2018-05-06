package com.gdms.service.user.impl;

import com.gdms.dao.DepartmentMapper;
import com.gdms.dao.MajorMapper;
import com.gdms.model.Department;
import com.gdms.model.Major;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.g.impl.GGroupServiceImpl;
import com.gdms.service.user.DepartmentService;
import com.gdms.service.user.MajorService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("MajorService")
@Transactional(rollbackFor = Exception.class)
public class MajorServiceImpl extends BaseServiceImpl<Major> implements MajorService {
    private Logger log = Logger.getLogger(GGroupServiceImpl.class);
    @Resource
    private MajorMapper majorMapper;

    public List<Major> queryAllList() {
        return majorMapper.queryAllList();
    }
}
