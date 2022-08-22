package com.wuliu.dao;

import com.wuliu.entity.Customer;
import com.wuliu.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {

    Customer checkLogin(@Param("customer_username") String customer_username, @Param("customer_password") String customer_password);

    List<Customer> findCustomerList(String customer_name);

    int saveCustomer(Customer customer);

    Customer findCustomerById(Integer customerId);

    int updateCustomer(Customer customer);

    List<Order> findCustomerOwnOrder(@Param("customer_id") Integer customer_id);

    Customer checkCustomer(String customer_username);
}
