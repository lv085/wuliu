package com.wuliu.controller;

import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import com.wuliu.service.DriverService;
import com.wuliu.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/DriverController")

public class DriverController {
    @Resource
    DriverService driverService;

    @GetMapping("/checkLogin")
    public Result checkLogin(
            @RequestParam(name = "username", required = true) String driver_username,
            @RequestParam(name = "password", required = true) String driver_password) {

        Driver driver = driverService.checkLogin(driver_username, driver_password);

        if (null == driver) {
            return Result.error("账号或者密码错误，请重新登录！");
        }
        return Result.success(driver, "恭喜登录成功！");

    }

    @PutMapping("/updateDriverStateById")
    public Result updateDriverStateById(@RequestBody int driver_id) {
        int i = driverService.updateDriverStateById(driver_id);
        if (i > 0) {
            return Result.success("停职成功！");
        }
        return Result.error("停职失败！");
    }

    @GetMapping("/findDriverList")
    public Result findDriverList(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
            @RequestParam(value = "driver_name", defaultValue = "") String driver_name) {
        List<Driver> driverList = driverService.findDriverList(currentPage, pageSize, driver_name);
        PageInfo pageInfo = new PageInfo(driverList);
        return Result.success(pageInfo, "查询成功");
    }

    @PostMapping("/saveDriver")
    public Result saveDriver(@RequestBody Driver driver) {
        if (driver.getDriver_name() == null || driver.getDriver_username() == null || driver.getDriver_password() == null) {
            return Result.error("添加失败");
        } else {
            Driver driver1 = driverService.findDriverByName(driver.getDriver_username());
            if (driver1 != null) {
                return Result.error("添加失败");
            } else {
                int i = driverService.saveDriver(driver);
                return Result.success("添加成功");
            }
        }
    }

    @GetMapping("/findDriverById")
    public Result findDriverById(@RequestParam(value = "driver_id") int driver_id) {
        Driver driver = driverService.findDriverById(driver_id);
        if (null != driver) {
            return Result.success(driver, "查询成功");
        }
        return Result.error("查询失败");
    }

    @PutMapping("/updateDriver")
    public Result updateDriver(@RequestBody Driver driver) {
        int i = driverService.updateDriver(driver);
        if (i > 0) {
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    @DeleteMapping("/deleteDriver")
    public Result deleteDriver(@RequestParam(value = "driver_id") int driver_id) {
        int i = driverService.deleteDriver(driver_id);
        if (i > 0) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

    @GetMapping("/findOrderByDid")
    public Result findOrderByDid(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
            @RequestParam(value = "driver_id", required = true) int driver_id,
            @RequestParam(value = "search_address", defaultValue = "") String search_address) {

        List<Order> orders = driverService.findOrderByDid(currentPage, pageSize, driver_id, search_address);

        PageInfo pageInfo = new PageInfo(orders);

        return Result.success(pageInfo, "根据司机id查询运单成功！");
    }

    @PutMapping("/changeOrderState")
    public Result changeOrderState(@RequestBody int[] upid) {
        //0:order_id,1:order_state,2:driver_id,3:tran_id
        int i = driverService.changeOrderState(upid[0], upid[1], upid[2], upid[3]);
        if (i > 0) {
            return Result.success("修改成功！");
        }
        return Result.error("修改失败！");
    }

    @GetMapping("/findOneOrder")
    public Result findOneOrder(@RequestParam("driver_id") int driver_id) {
        Order order = driverService.findOneOrder(driver_id);
        if (null != order) {
            return Result.success(order, "查询成功！");
        }
        return Result.error("没有正在进行的运单");
    }
}
