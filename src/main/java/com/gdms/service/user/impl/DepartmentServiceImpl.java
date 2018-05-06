package com.gdms.service.user.impl;

import com.gdms.dao.DepartmentMapper;
import com.gdms.dao.GGroupMapper;
import com.gdms.model.Department;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.g.impl.GGroupServiceImpl;
import com.gdms.service.user.DepartmentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Service("DepartmentService")
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {
    private Logger log = Logger.getLogger(GGroupServiceImpl.class);
    @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> queryAllList() {
        return departmentMapper.queryAllList();
    }
}
