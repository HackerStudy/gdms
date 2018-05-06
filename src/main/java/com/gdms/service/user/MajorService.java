package com.gdms.service.user;

import com.gdms.dao.DepartmentMapper;
import com.gdms.model.Department;
import com.gdms.model.Major;
import com.gdms.service.common.BaseService;
import com.gdms.service.g.impl.GGroupServiceImpl;

import javax.annotation.Resource;
import java.util.List;

public interface MajorService extends BaseService<Major> {
    List<Major> queryAllList();

}
