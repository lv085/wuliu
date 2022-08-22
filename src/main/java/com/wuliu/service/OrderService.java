package com.wuliu.service;

import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import com.wuliu.entity.Tran;

import java.util.List;

public interface OrderService {

    List<Order> adminFindAllOrder(int currentPage, int pageSize, int order_state, String order_no, String customer_name, String driver_name, String tran_name);

    int customerAddOrder(Order order);

    List<Order> adminFindOrderFlagIs0(int currentPage, int pageSize);

    Order adminFindOrderContent(int order_id);

    List<Driver> findDriverFlagIs0();

    List<Tran> findTranFlagIs1();

    int driverFlagChangeIs1(int driver_id);

    int tranFlagChangeIs0(int tran_id);

    int adminUpdateOrder(Order order);

    int orderFlagChangeIs1(int order_id);

    int delOrderById(int order_id);

    int customerUpdateOrder(Order order);
}
