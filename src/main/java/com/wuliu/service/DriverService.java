package com.wuliu.service;

import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;

import java.util.List;

public interface DriverService {

    Driver checkLogin(String driver_username, String driver_password);

    List<Driver> findDriverList(int currentPage, int pageSize, String driver_name);

    int saveDriver(Driver driver);

    Driver findDriverByName(String driver_username);

    Driver findDriverById(int driver_id);

    int updateDriver(Driver driver);

    int deleteDriver(int driver_id);

    int updateDriverStateById(int driver_id);

    List<Order> findOrderByDid(int currentPage, int pageSize, int driver_id, String search_address);

    int changeOrderState(int order_id, int order_state, int driver_id, int tran_id);

    Order findOneOrder(int driver_id);
}
