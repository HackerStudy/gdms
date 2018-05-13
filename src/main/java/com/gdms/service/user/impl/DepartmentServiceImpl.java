package com.gdms.service.user.impl;

import com.gdms.dao.DepartmentMapper;
import com.gdms.model.Department;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.user.DepartmentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {
    private Logger log = Logger.getLogger(DepartmentServiceImpl.class);
    @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> queryAllList() {
        return departmentMapper.queryAllList();
    }
}
