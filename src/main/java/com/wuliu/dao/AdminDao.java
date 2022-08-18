package com.wuliu.dao;

import com.wuliu.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    Admin checkLogin(@Param("username") String admin_username, @Param(("password")) String admin_password);

    List<Admin> findAdminList(@Param("name") String admin_name);

    int saveAdmin(Admin admin);

    Admin findAdminById(int admin_id);

    int updateAdmin(Admin admin);

    int deleteAdmin(int admin_id);
}
