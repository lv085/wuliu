package com.wuliu.service;

import com.wuliu.entity.Customer;
import com.wuliu.entity.Order;

import java.util.List;

public interface CustomerService {
    /**
     * 用户登录
     *
     * @param customer_username 用户账号名
     * @param customer_password 登录密码
     * @return 查询到的用户
     */
    public Customer checkLogin(String customer_username, String customer_password);

    /**
     * 分页查询所有用户
     *
     * @param currentPage   传入当前页数
     * @param pageSize      传入当前页数数据数
     * @param customer_name 传入搜索名
     * @return 分页返回查询用户
     */
    List<Customer> findCustomerList(int currentPage, int pageSize, String customer_name);

    /**
     * 管理员增加用户
     *
     * @param customer 用户实体
     * @return 返回执行结果
     */
    int saveCustomer(Customer customer);


    /**
     * 先查询要修改用户
     *
     * @param customer_id 传入先查询要修改用户的id
     * @return 返回执行结果
     */
    Customer findCustomerById(Integer customer_id);

    /**
     * 修改用户
     *
     * @param customer 传入修改用户后的实体
     * @return 执行结果
     */
    int updateCustomer(Customer customer);

    /**
     * 查询用户自己的订单
     *
     * @param currentPage 传入当前页
     * @param pageSize    每页的数据
     * @param customer_id 用户id
     * @return 订单信息
     */
    List<Order> findCustomerOwnOrder(int currentPage, int pageSize, Integer customer_id);

    Customer checkCustomer(String customer_username);
}
