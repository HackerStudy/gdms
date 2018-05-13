package com.gdms.service.user;

import com.gdms.model.Department;
import com.gdms.service.common.BaseService;
import java.util.List;


public interface DepartmentService extends BaseService<Department> {
    List<Department> queryAllList();
}
