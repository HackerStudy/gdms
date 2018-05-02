package com.gdms.service.admin.impl;

import com.gdms.dao.AdminMapper;
import com.gdms.model.Admin;
import com.gdms.service.admin.AdminService;
import com.gdms.service.common.impl.BaseServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    private Logger log = Logger.getLogger(AdminServiceImpl.class);

    @Resource
    private AdminMapper adminMapper;

    public Admin getModelByUsernameAndPassword(Admin admin) {
        // 查询
//        密码加密
//        user.setKitAdminPassword(AppUtil.md5pwd(user.getKitAdminPassword()));
        List<Admin> adminList = adminMapper.getModelByUsernameAndPassword(admin);
        Admin retuenAdmin = null;
        if(adminList.size()>0){
            retuenAdmin = adminList.get(0);
        }
        return retuenAdmin;
    }

    public List<Admin> getAlladmin() {
        return adminMapper.getAlladmin();
    }

    public Admin selectUserByUsername(String username) {
        Admin admin=adminMapper.selectUserByUsername(username);
        System.out.println("当前的管理员为："+admin);
        return admin;
    }

    public Admin selectAdminById(String adminId) {
        return adminMapper.selectAdminById(adminId);
    }

    public int updateByAdminId(Admin admin) {

        System.out.println(admin.getKitAdminId());
        System.out.println(admin.getKitAdminPassword());

        return adminMapper.updateByAdminId(admin);
    }

    public Boolean insertAdmin(Admin admin) {
        Boolean b=true;
        adminMapper.insertAdmin(admin);
        return b;
    }

    public String findAdminIdByAdminUsername(String kitAdminUsername) {
        return adminMapper.findAdminIdByAdminUsername(kitAdminUsername);
    }
}
