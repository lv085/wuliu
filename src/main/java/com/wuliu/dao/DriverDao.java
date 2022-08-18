package com.wuliu.dao;

import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverDao {
    Driver checkLogin(@Param("username") String driver_username, @Param("password") String driver_password);

    /*查询运输人员
     *
     * */
    List<Driver> findDriverList(String driver_name);

    /*增加运输人员
     *
     * */
    int saveDriver(Driver driver);

    /*查重
     *
     * */
    Driver findDriverByName(String driver_username);

    /*通过ID查找运输人员
     *
     * */
    Driver findDriverById(int driver_id);

    /*修改运输人员
     *
     * */
    int updateDriver(Driver driver);

    /*删除运输人员
     *
     * */
    int deleteDriver(int driver_id);

    //停职司机
    int updateDriverStateById(int driver_id);

    //根据司机id查找运单(目的地模糊查询)
    List<Order> findOrderByDid(@Param("driver_id") int driver_id, @Param("search_address") String search_address);

    //修改运单状态
    int changeOrderState(@Param("order_id") int order_id, @Param("order_state") int order_state);

    //修改司机状态为空闲0
    void changeDriverState0(@Param("driver_id") int driver_id);

    //将运输工具状态改为1空闲
    void changeTranState1(int tran_id);

    Order findOneOrder(int driver_id);
}
