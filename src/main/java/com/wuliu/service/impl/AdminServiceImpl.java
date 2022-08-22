package com.wuliu.service.impl;

import com.wuliu.dao.AdminDao;
import com.wuliu.entity.Admin;
import com.wuliu.service.AdminService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;

    @Override
    public Admin checkLogin(String admin_username, String admin_password) {
        return adminDao.checkLogin(admin_username, admin_password);
    }

    @Override
    public List<Admin> findAdminList(int currentPage, int pageSize, String admin_name) {
        PageHelper.startPage(currentPage, pageSize);
        return adminDao.findAdminList(admin_name);
    }

    @Override
    public int saveAdmin(Admin admin) {
        return adminDao.saveAdmin(admin);
    }

    @Override
    public Admin findAdminById(int admin_id) {
        return adminDao.findAdminById(admin_id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public int deleteAdmin(int admin_id) {
        return adminDao.deleteAdmin(admin_id);
    }
}
