package com.wuliu.service;

import com.wuliu.entity.Customer;
import com.wuliu.entity.Order;

import java.util.List;

public interface CustomerService {

    public Customer checkLogin(String customer_username, String customer_password);

    List<Customer> findCustomerList(int currentPage, int pageSize, String customer_name);

    int saveCustomer(Customer customer);

    Customer findCustomerById(Integer customer_id);

    int updateCustomer(Customer customer);

    List<Order> findCustomerOwnOrder(int currentPage, int pageSize, Integer customer_id);

    Customer checkCustomer(String customer_username);

    int deleteCustomerById(int customer_id);
}
