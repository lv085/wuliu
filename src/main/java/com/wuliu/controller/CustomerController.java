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

    /**
     * 用户登录
     *
     * @param customer_username 用户账号名
     * @param customer_password 登录密码
     * @return 查询到的用户
     */
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

    /**
     * 分页查询所有用户
     *
     * @param currentPage   传入当前页数
     * @param pageSize      传入当前页数数据数
     * @param customer_name 传入搜索名
     * @return 分页返回查询用户
     */
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

    /**
     * 管理员增加用户
     *
     * @param customer 用户实体
     * @return 返回执行结果
     */
    @PostMapping("/saveCustomer")
    public Result saveCustomer(@RequestBody Customer customer) {
        if (customer.getCustomer_name() == null || customer.getCustomer_tel() ==null || customer.getCustomer_username() == null){
            return Result.error("客户增加失败");
        }else{
            if(customerService.checkCustomer(customer.getCustomer_username())!=null){
                return Result.error("添加失败");
            }else{

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


    /**
     * 先查询要修改用户
     *
     * @param customer_id 传入先查询要修改用户的id
     * @return 返回执行结果
     */
    @GetMapping("/findCustomerById")
    public Result findCustomerById(@RequestParam("customer_id") Integer customer_id) {
        Customer customer = customerService.findCustomerById(customer_id);
        if (null != customer) {
            return Result.success(customer, "客户查询成功");
        } else {
            return Result.success("客户查询失败");
        }
    }

    /**
     * 修改用户
     *
     * @param customer 传入修改用户后的实体
     * @return 执行结果
     */
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

    /**
     * 查询用户自己的订单
     *
     * @param currentPage 传入当前页
     * @param pageSize    每页的数据
     * @param customer_id 用户id
     * @return 订单信息
     */
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

}
