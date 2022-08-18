package com.wuliu.dao;

import com.wuliu.entity.Customer;
import com.wuliu.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    /**
     * 用户登录
     *
     * @param customer_username
     * @param customer_password
     * @return
     */
    Customer checkLogin(@Param("customer_username") String customer_username, @Param("customer_password") String customer_password);

    /**
     * 分页搜索高级查询客户
     *
     * @param customer_name
     * @return
     */
    List<Customer> findCustomerList(String customer_name);

    /**
     * 保存客户
     *
     * @param customer
     * @return
     */
    int saveCustomer(Customer customer);


    /**
     * 修改前通过id查询客户信息
     *
     * @param customerId
     * @return
     */
    Customer findCustomerById(Integer customerId);

    /**
     * 修改客户
     *
     * @param customer
     * @return
     */
    int updateCustomer(Customer customer);

    /**
     * 查询用户个人订单
     *
     * @param customer_id
     * @return
     */
    List<Order> findCustomerOwnOrder(@Param("customer_id") Integer customer_id);

    Customer checkCustomer(String customer_username);
}
