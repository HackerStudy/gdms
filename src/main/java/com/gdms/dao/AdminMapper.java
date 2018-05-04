package com.gdms.dao;

import com.gdms.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface AdminMapper extends Mapper<Admin>{
    List<Admin> getModelByUsernameAndPassword(Admin admin);

    List<Admin> getAlladmin();

    Admin selectUserByUsername(String username);

    Admin selectAdminById(@Param("adminId") String adminId);

    int updateByAdminId(Admin admin);

    void insertAdmin(Admin admin);

    String findAdminIdByAdminUsername(@Param("kitAdminUsername") String kitAdminUsername);

    List<Admin> searchAdminByAdminUsername(@Param("kitAdminUsername") String kitAdminUsername);
}