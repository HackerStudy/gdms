package com.gdms.dao;

import com.gdms.model.Admin;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface AdminMapper extends Mapper<Admin>{
    List<Admin> getModelByUsernameAndPassword(Admin admin);

    Admin selectUserByUsername(String username);

    int updateByAdminId(Admin admin);
}