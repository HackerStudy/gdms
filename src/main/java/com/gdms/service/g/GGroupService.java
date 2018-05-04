package com.gdms.service.g;

import com.gdms.model.GGroup;
import com.gdms.service.common.BaseService;

import java.util.List;

public interface GGroupService  extends BaseService<GGroup> {
    List<GGroup> getListByGroupName(GGroup gGroup);

    List<GGroup> queryAll();

    List<GGroup> queryAllAdminGroup();
}
