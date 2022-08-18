package com.wuliu.service;

import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;

import java.util.List;

public interface DriverService {
    /**
     * 运输人员登录
     *
     * @param driver_username 运输人员账户名
     * @param driver_password 运输人员登录密码
     * @return
     */
    Driver checkLogin(String driver_username, String driver_password);

    /**
     * 查询所有在职运输人员
     *
     * @param currentPage
     * @param pageSize
     * @param driver_name
     * @return
     */
    List<Driver> findDriverList(int currentPage, int pageSize, String driver_name);

    /**
     * 增加运输人员
     *
     * @param driver
     * @return
     */
    int saveDriver(Driver driver);

    /*查重运输人员
     *
     * */
    Driver findDriverByName(String driver_username);

    /**
     * 通过ID查询运输人员（并有查重功能）
     *
     * @param driver_id 要查询的人员id
     * @return
     */
    Driver findDriverById(int driver_id);

    /**
     * 运输人员修改
     *
     * @param driver 修改后的司机
     * @return
     */
    int updateDriver(Driver driver);

    /**
     * 删除运输人员
     *
     * @param driver_id 删除运输人员的id
     * @return
     */
    int deleteDriver(int driver_id);

    /*
     * 停职在职人员
     * */
    int updateDriverStateById(int driver_id);

    /**
     * 根据司机id查找所有订单
     *
     * @param currentPage
     * @param pageSize
     * @param driver_id      司机id
     * @param search_address 目的地
     * @return
     */
    List<Order> findOrderByDid(int currentPage, int pageSize, int driver_id, String search_address);

    /**
     * 修改运单状态
     *
     * @param order_id    订单id
     * @param order_state 订单状态
     * @param driver_id   运输人员id
     * @param tran_id     运输工具id
     * @return
     */
    int changeOrderState(int order_id, int order_state, int driver_id, int tran_id);

    /**
     * 运输人员查询分配给自己的运行中订单
     *
     * @param driver_id
     * @return
     */
    Order findOneOrder(int driver_id);
}
