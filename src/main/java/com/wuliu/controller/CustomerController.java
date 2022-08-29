package com.wuliu.controller;

import com.wuliu.entity.Customer;
import com.wuliu.entity.Order;
import com.wuliu.service.CustomerService;
import com.wuliu.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/CustomerController")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @GetMapping("/checkLogin")
    public Result checkLogin(
            @RequestParam(name = "username", required = true) String customer_username,
            @RequestParam(name = "password", required = true) String customer_password) {


        Customer customer = customerService.checkLogin(customer_username, customer_password);

        if (null == customer) {
            return Result.error("账号或者密码错误，请重新登录！");
        }
        return Result.success(customer, "恭喜登录成功！");

    }

    @GetMapping("/findCustomerList")
    public Result findCustomerList(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "6") int pageSize,
            @RequestParam(value = "customer_name", defaultValue = "") String customer_name) {

        List<Customer> customerList = customerService.findCustomerList(currentPage, pageSize, customer_name);
        //分页对象
        PageInfo pageInfo = new PageInfo(customerList);

        return Result.success(pageInfo, "查询成功");
    }

    @PostMapping("/saveCustomer")
    public Result saveCustomer(@RequestBody Customer customer) {
        if (customer.getCustomer_name() == null || customer.getCustomer_tel() == null || customer.getCustomer_username() == null) {
            return Result.error("客户增加失败");
        } else {
            if (customerService.checkCustomer(customer.getCustomer_username()) != null) {
                return Result.error("添加失败");
            } else {

                try {
                    int i = customerService.saveCustomer(customer);
                    if (i > 0) {
                        return Result.success("客户增加成功");
                    } else {
                        return Result.error("客户增加失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.error("程序异常，客户增加失败");
                }
            }

        }
    }

    @GetMapping("/findCustomerById")
    public Result findCustomerById(@RequestParam("customer_id") Integer customer_id) {
        Customer customer = customerService.findCustomerById(customer_id);
        if (null != customer) {
            return Result.success(customer, "客户查询成功");
        } else {
            return Result.success("客户查询失败");
        }
    }

    @PutMapping("/updateCustomer")
    public Result updateCustomer(@RequestBody Customer customer) {
        try {
            int i = customerService.updateCustomer(customer);
            if (i > 0) {
                return Result.success("客户修改成功");
            } else {
                return Result.error("客户修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("程序异常，客户修改失败");
        }
    }

    @GetMapping("/findCustomerOwnOrder")
    public Result findCustomerOwnOrder(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "6") int pageSize,
            @RequestParam(value = "customer_id", required = true) Integer customer_id) {
        List<Order> customerOwnOrder = customerService.findCustomerOwnOrder(currentPage, pageSize, customer_id);
        //分页对象
        PageInfo pageInfo = new PageInfo(customerOwnOrder);
        return Result.success(pageInfo, "查询成功");
    }

    @DeleteMapping("/deleteCustomerById")
    public Result deleteCustomerById(@RequestParam("customer_id") int customer_id) {
        int i = customerService.deleteCustomerById(customer_id);
        if (i > 0) {
            return Result.success("删除用户成功");
        }
        return Result.error("删除用户失败");
    }
}
