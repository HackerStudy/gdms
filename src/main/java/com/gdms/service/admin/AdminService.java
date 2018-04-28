package com.gdms.service.admin;

import com.gdms.model.Admin;
import com.gdms.service.common.BaseService;

public interface AdminService extends BaseService<Admin> {

    Admin getModelByUsernameAndPassword(Admin admin);

    Admin selectUserByUsername(String username);

    int updateByAdminId(Admin admin);
}
