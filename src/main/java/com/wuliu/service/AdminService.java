package com.wuliu.service;

import com.wuliu.entity.Admin;

import java.util.List;

public interface AdminService {

    Admin checkLogin(String admin_username, String admin_password);

    List<Admin> findAdminList(int currentPage, int pageSize, String admin_name);

    int saveAdmin(Admin admin);

    Admin findAdminById(int admin_id);

    int updateAdmin(Admin admin);

    int deleteAdmin(int admin_id);
}
