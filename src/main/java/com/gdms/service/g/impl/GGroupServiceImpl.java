package com.gdms.service.g.impl;

import com.gdms.dao.GGroupMapper;
import com.gdms.model.GGroup;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.g.GGroupService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class GGroupServiceImpl  extends BaseServiceImpl<GGroup> implements GGroupService {
    private Logger log = Logger.getLogger(GGroupServiceImpl.class);

    @Resource
    private GGroupMapper gGroupMapper;

    public List<GGroup> getListByGroupName(GGroup gGroup) {
        return gGroupMapper.getListByGroupName(gGroup);
    }

    @Override
    public List<GGroup> queryAll() {
        return gGroupMapper.queryAll();
    }

    public List<GGroup> queryAllAdminGroup() {
        return  gGroupMapper.queryAllAdminGroup();
    }
}
