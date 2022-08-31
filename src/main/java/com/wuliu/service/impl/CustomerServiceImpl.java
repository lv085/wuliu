package com.wuliu.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliu.dao.CustomerDao;
import com.wuliu.entity.Customer;
import com.wuliu.entity.Order;
import com.wuliu.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    @Override
    public Customer checkLogin(String customer_username, String customer_password) {
        return customerDao.checkLogin(customer_username, customer_password);
    }

    @Override
    public List<Customer> findCustomerList(int currentPage, int pageSize, String customer_name) {
        PageHelper.startPage(currentPage, pageSize);
        return customerDao.findCustomerList(customer_name);
    }

    @Override
    public int saveCustomer(Customer customer) {
        return customerDao.saveCustomer(customer);
    }


    @Override
    public Customer findCustomerById(Integer customer_id) {
        return customerDao.findCustomerById(customer_id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }


    public List<Order> findCustomerOwnOrder(int currentPage, int pageSize, Integer customer_id) {
        PageHelper.startPage(currentPage, pageSize);
        return customerDao.findCustomerOwnOrder(customer_id);
    }

    @Override
    public Customer checkCustomer(String customer_username) {
        return customerDao.checkCustomer(customer_username);
    }

    @Override
    public int deleteCustomerById(int customer_id) {
        return customerDao.deleteCustomerById(customer_id);
    }

}
