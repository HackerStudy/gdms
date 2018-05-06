package com.gdms.service.user;

import com.gdms.dao.DepartmentMapper;
import com.gdms.dao.GGroupMapper;
import com.gdms.model.Department;
import com.gdms.service.common.BaseService;
import com.gdms.service.g.impl.GGroupServiceImpl;
import com.gdms.service.user.impl.DepartmentServiceImpl;
import com.gdms.service.user.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


public interface DepartmentService extends BaseService<Department> {
    List<Department> queryAllList();
}
