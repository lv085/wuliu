package com.wuliu.dao;

import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import com.wuliu.entity.Tran;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName OrderDao
 * Author 王弈程
 * @Date 2021/9/3 14:06
 **/
public interface OrderDao {
    List<Order> adminFindAllOrder(@Param("order_state") int order_state,
                                  @Param("order_no") String order_no,
                                  @Param("customer_name") String customer_name,
                                  @Param("driver_name") String driver_name,
                                  @Param("tran_name") String tran_name);

    int customerAddOrder(Order order);

    List<Order> adminFindOrderFlagIs0();

    Order adminFindOrderContent(@Param("order_id") int order_id);

    List<Driver> findDriverFlagIs0();

    List<Tran> findTranFlagIs1();

    int driverFlagChangeIs1(int driver_id);

    int tranFlagChangeIs0(int tran_id);

    int adminUpdateOrder(Order order);

    int orderFlagChangeIs1(int order_id);

    int delOrderById(int order_id);

    int customerUpdateOrder(Order order);
}
