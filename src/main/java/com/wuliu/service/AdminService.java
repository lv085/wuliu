package com.wuliu.service;

import com.wuliu.entity.Admin;

import java.util.List;

public interface AdminService {
    /**
     * 管理员登录
     *
     * @param admin_username 管理员账户名
     * @param admin_password 管理员登录密码
     * @return 查询结果
     */
    Admin checkLogin(String admin_username, String admin_password);
    /**
     * 分页所有管理员查询
     *
     * @param currentPage
     * @param pageSize
     * @param admin_name
     * @return
     */
    List<Admin> findAdminList(int currentPage, int pageSize, String admin_name);

    int saveAdmin(Admin admin);

    Admin findAdminById(int admin_id);

    int updateAdmin(Admin admin);

    int deleteAdmin(int admin_id);
}
