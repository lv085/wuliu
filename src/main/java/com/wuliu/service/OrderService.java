package com.wuliu.service;

import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import com.wuliu.entity.Tran;

import java.util.List;

/**
 * @ClassName OrderService
 * Author 王弈程
 * @Date 2021/9/3 14:06
 **/
public interface OrderService {
    /**
     * 管理员查询所有订单
     * 包括模糊查询（订单状态、客户姓名、订单号、司机姓名）
     *
     * @param currentPage
     * @param pageSize
     * @param order_state   订单状态
     * @param order_no      订单号
     * @param customer_name 客户姓名
     * @param driver_name   司机姓名
     * @param tran_name     运输工具名称
     * @return
     */
    List<Order> adminFindAllOrder(int currentPage, int pageSize, int order_state, String order_no, String customer_name, String driver_name, String tran_name);

    /**
     * 添加订单，需要管理员审核通过后才可以添加成功
     * 用户下单，用户添加不了发货时间，送货时间，司机id和车id，运费
     *
     * @param order 订单
     * @return
     */
    int customerAddOrder(Order order);

    /**
     * 管理员查看所有状态为0的订单
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Order> adminFindOrderFlagIs0(int currentPage, int pageSize);

    /**
     * 管理员点击一条状态为0的订单，显示该订单的详细信息
     *
     * @param order_id
     * @return
     */
    Order adminFindOrderContent(int order_id);

    /**
     * 查询空闲状态的司机0
     *
     * @return
     */
    List<Driver> findDriverFlagIs0();

    /**
     * 查询空闲状态的车1
     *
     * @return
     */
    List<Tran> findTranFlagIs1();

    /**
     * 把司机状态改为1
     *
     * @param driver_id
     * @return
     */
    int driverFlagChangeIs1(int driver_id);

    /**
     * 把车的状态改为0
     *
     * @param tran_id
     * @return
     */
    int tranFlagChangeIs0(int tran_id);

    /**
     * 管理员处理订单
     * 管理员查询
     *
     * @param order
     * @return
     */
    int adminUpdateOrder(Order order);

    /**
     * 把订单状态改为1
     *
     * @param order_id
     * @return
     */
    int orderFlagChangeIs1(int order_id);

    int delOrderById(int order_id);

    int customerUpdateOrder(Order order);
}
