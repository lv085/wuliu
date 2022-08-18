package com.wuliu.controller;

import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import com.wuliu.entity.Tran;
import com.wuliu.service.OrderService;
import com.wuliu.utils.ODDGenerator;
import com.wuliu.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName OrderController
 * Author 王弈程
 * @Date 2021/9/3 14:06
 **/
@RestController
@RequestMapping("/OrderController")
public class OrderController {
    @Resource
    private OrderService orderService;


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
    @RequestMapping("/adminFindAllOrder")
    public Result adminFindAllOrder(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                    @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                    @RequestParam(value = "order_state", defaultValue = "-1") int order_state,
                                    @RequestParam(value = "order_no", defaultValue = "") String order_no,
                                    @RequestParam(value = "customer_name", defaultValue = "") String customer_name,
                                    @RequestParam(value = "driver_name", defaultValue = "") String driver_name,
                                    @RequestParam(value = "tran_name", defaultValue = "") String tran_name) {
        List<Order> orderList = orderService.adminFindAllOrder(currentPage, pageSize, order_state, order_no, customer_name, driver_name, tran_name);
        PageInfo pageInfo = new PageInfo(orderList);
        return Result.success(pageInfo, "管理员查询订单成功");
    }


    /**
     * 添加订单，需要管理员审核通过后才可以添加成功
     * 用户下单，用户添加不了发货时间，送货时间，司机id和车id，运费
     *
     * @param order 订单
     * @return
     */
    @PostMapping("/customerAddOrder")
    public Result customerAddOrder(@RequestBody Order order) {
        if(order.getArrive_address()==null||order.getSend_address()==null||order.getOrder_arrive_username()==null||order.getOrder_arrive_usertel()==null){
            return Result.error("添加失败！");
        }else{
            int i = orderService.customerAddOrder(order);
            return Result.success("客户下单成功");
        }
    }

/*
* 用户撤销订单
* */
    @DeleteMapping("/delOrderById")
    public Result delOrderById(@RequestParam("order_id")int order_id){
        int i=orderService.delOrderById(order_id);
        if(i>0){
            return Result.success("操作成功！");
        }
        return Result.error("操作失败！");
    }

    /**
     * 管理员查看所有状态为0的订单
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/adminFindOrderFlagIs0")
    public Result adminFindOrderFlagIs0(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        List<Order> list = orderService.adminFindOrderFlagIs0(currentPage, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        return Result.success(pageInfo, "所有状态为0的订单查询成功");
    }

    /**
     * 管理员点击一条状态为0的订单，显示该订单的详细信息
     *
     * @param order_id
     * @return
     */
    @GetMapping("/adminFindOrderContent")
    public Result adminFindOrderContent(@RequestParam(value = "order_id", required = true) int order_id) {
        Order order = orderService.adminFindOrderContent(order_id);
        return Result.success(order, "管理员查看订单详细信息成功");
    }

    /**
     * 查询空闲状态的司机0
     *
     * @return
     */
    @GetMapping("/findDriverFlagIs0")
    public Result findDriverFlagIs0() {
        List<Driver> driverList = orderService.findDriverFlagIs0();
        return Result.success(driverList, "查询所有状态为0的司机成功");
    }

    /**
     * 查询空闲状态的车1
     *
     * @return
     */
    @GetMapping("/findTranFlagIs1")
    public Result findTranFlagIs1() {
        List<Tran> tranList = orderService.findTranFlagIs1();
        return Result.success(tranList, "查询所有状态为1的车成功");
    }


    /**
     * 管理员处理订单
     * 管理员查询
     *
     * @param order
     * @return
     */
    @PutMapping("/adminUpdateOrder")
    public Result adminUpdateOrder(@RequestBody Order order) {
        if(order.getSend_date()==null||order.getArrive_date()==null||order.getOrder_money()==0.0||order.getOrder_driver()==null||order.getOrder_tran()==null){
            return Result.error("信息不完善！");
        }else{
            int i = orderService.adminUpdateOrder(order);
            if (i > 0) {
                return Result.success("管理员修改订单成功");
            }else{
                return Result.error("管理员修改订单失败");
            }
        }
    }

    /**
     * 把司机状态改为1
     *
     * @param driver_id
     * @return
     */
    @PutMapping("/driverFlagChangeIs1")
    public Result driverFlagChangeIs1(@RequestParam(value = "driver_id", required = true) int driver_id) {
        int i = orderService.driverFlagChangeIs1(driver_id);
        if (i > 0) {
            return Result.success("司机状态变为1");
        }
        return Result.error("司机状态改变失败");
    }

    /**
     * 把车的状态改为0
     *
     * @param tran_id
     * @return
     */
    @PutMapping("/tranFlagChangeIs0")
    public Result tranFlagChangeIs0(@RequestParam(value = "tran_id", required = true) int tran_id) {
        int i = orderService.tranFlagChangeIs0(tran_id);
        if (i > 0) {
            return Result.success("车状态改变成功");
        }
        return Result.error("车状态改变失败");
    }

    /**
     * 把订单状态改为1
     *
     * @param order_id
     * @return
     */
    @PutMapping("/orderFlagChangeIs1")
    public Result orderFlagChangeIs1(@RequestParam(value = "order_id", required = true) int order_id) {
        int i = orderService.orderFlagChangeIs1(order_id);
        if (i > 0) {
            return Result.success("订单状态改变成功");
        }
        return Result.error("订单状态改变失败");
    }

    /**
     * 随机生成订单号
     *
     * @return
     */
    @GetMapping("/createOrderId")
    public Result createOrderId() {
        return Result.success(ODDGenerator.getOrderNo());
    }

    /**
     * 用户修改信息
     */
    @PutMapping("/customerUpdateOrder")
    public Result customerUpdateOrder(@RequestBody Order order){
        int i = orderService.customerUpdateOrder(order);
        if (i>0){
            return Result.success("订单修改成功");
        }
        return Result.error("修改失败");
    }

}
