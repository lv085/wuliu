package com.wuliu.controller;

import com.wuliu.entity.Admin;
import com.wuliu.service.AdminService;
import com.wuliu.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/AdminController")

public class AdminController {
    @Resource
    private AdminService adminService;

    /**
     * 管理员登录
     *
     * @param admin_username 管理员账户名
     * @param admin_password 管理员登录密码
     * @return 查询结果
     */
    @GetMapping("/checkLogin")
    public Result checkLogin(
            @RequestParam(name = "username", required = true) String admin_username,
            @RequestParam(name = "password", required = true) String admin_password) {

        Admin admin = adminService.checkLogin(admin_username, admin_password);

        if (null == admin) {
            return Result.error("账号或者密码错误，请重新登录！");
        }
        return Result.success(admin, "恭喜登录成功！");

    }

    /**
     * 分页所有管理员查询
     *
     * @param currentPage
     * @param pageSize
     * @param admin_name
     * @return
     */
    @GetMapping("/findAdminList")
    public Result findAdminList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                @RequestParam(value = "name", defaultValue = "") String admin_name) {
        List<Admin> adminList = adminService.findAdminList(currentPage, pageSize, admin_name);
        PageInfo pageInfo = new PageInfo(adminList);
        return Result.success(pageInfo, "查询用户成功");

    }

    /**
     * 增加
     *
     * @param admin
     * @return
     */
    @PostMapping("/saveAdmin")
    public Result saveAdmin(@RequestBody Admin admin) {
        int i = adminService.saveAdmin(admin);
        if (i > 0) {
            return Result.success("用户增加成功");
        }
        return Result.error("用户增加失败");
    }

    /**
     * 根据id查询
     *
     * @param admin_id
     * @return
     */
    @GetMapping("/findAdminById")
    public Result findAdminById(@RequestParam("admin_id") int admin_id) {
        Admin admin = adminService.findAdminById(admin_id);
        if (null != admin) {
            return Result.success(admin, "用户查询成功");
        }
        return Result.error("用户查询失败");
    }

    /**
     * 修改
     *
     * @param admin
     * @return
     */
    @PutMapping("/updateAdmin")
    public Result updateAdmin(@RequestBody Admin admin) {
        int i = adminService.updateAdmin(admin);
        if (i > 0) {
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    @DeleteMapping("/deleteAdmin")
    public Result deleteAdmin(@RequestParam("admin_id") int admin_id) {
        int i = adminService.deleteAdmin(admin_id);
        if (i > 0) {
            return Result.success("删除用户成功");
        }
        return Result.error("删除用户失败");
    }
}

