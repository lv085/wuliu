package com.wuliu.dao;

import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverDao {
    Driver checkLogin(@Param("username") String driver_username, @Param("password") String driver_password);

    List<Driver> findDriverList(String driver_name);

    int saveDriver(Driver driver);

    Driver findDriverByName(String driver_username);

    Driver findDriverById(int driver_id);

    int updateDriver(Driver driver);

    int deleteDriver(int driver_id);

    int updateDriverStateById(int driver_id);

    List<Order> findOrderByDid(@Param("driver_id") int driver_id, @Param("search_address") String search_address);

    int changeOrderState(@Param("order_id") int order_id, @Param("order_state") int order_state);

    void changeDriverState0(@Param("driver_id") int driver_id);

    void changeTranState1(int tran_id);

    Order findOneOrder(int driver_id);
}
