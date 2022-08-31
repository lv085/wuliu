package com.wuliu.controller;

import com.github.pagehelper.PageInfo;
import com.wuliu.entity.Driver;
import com.wuliu.entity.Order;
import com.wuliu.entity.Tran;
import com.wuliu.service.OrderService;
import com.wuliu.utils.ODDGenerator;
import com.wuliu.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/OrderController")
public class OrderController {
    @Resource
    private OrderService orderService;

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

    @PostMapping("/customerAddOrder")
    public Result customerAddOrder(@RequestBody Order order) {
        if (order.getArrive_address() == null || order.getSend_address() == null || order.getOrder_arrive_username() == null || order.getOrder_arrive_usertel() == null) {
            return Result.error("添加失败！");
        } else {
            int i = orderService.customerAddOrder(order);
            return Result.success("客户下单成功");
        }
    }

    @DeleteMapping("/delOrderById")
    public Result delOrderById(@RequestParam("order_id") int order_id) {
        int i = orderService.delOrderById(order_id);
        if (i > 0) {
            return Result.success("操作成功！");
        }
        return Result.error("操作失败！");
    }

    @GetMapping("/adminFindOrderFlagIs0")
    public Result adminFindOrderFlagIs0(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        List<Order> list = orderService.adminFindOrderFlagIs0(currentPage, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        return Result.success(pageInfo, "所有状态为0的订单查询成功");
    }

    @GetMapping("/adminFindOrderContent")
    public Result adminFindOrderContent(@RequestParam(value = "order_id", required = true) int order_id) {
        Order order = orderService.adminFindOrderContent(order_id);
        return Result.success(order, "管理员查看订单详细信息成功");
    }

    @GetMapping("/findDriverFlagIs0")
    public Result findDriverFlagIs0() {
        List<Driver> driverList = orderService.findDriverFlagIs0();
        return Result.success(driverList, "查询所有状态为0的司机成功");
    }

    @GetMapping("/findTranFlagIs1")
    public Result findTranFlagIs1() {
        List<Tran> tranList = orderService.findTranFlagIs1();
        return Result.success(tranList, "查询所有状态为1的车成功");
    }

    @PutMapping("/adminUpdateOrder")
    public Result adminUpdateOrder(@RequestBody Order order) {
        if (order.getSend_date() == null || order.getArrive_date() == null || order.getOrder_money() == 0.0 || order.getOrder_driver() == null || order.getOrder_tran() == null) {
            return Result.error("信息不完善！");
        } else {
            int i = orderService.adminUpdateOrder(order);
            if (i > 0) {
                return Result.success("管理员修改订单成功");
            } else {
                return Result.error("管理员修改订单失败");
            }
        }
    }

    @PutMapping("/driverFlagChangeIs1")
    public Result driverFlagChangeIs1(@RequestParam(value = "driver_id", required = true) int driver_id) {
        int i = orderService.driverFlagChangeIs1(driver_id);
        if (i > 0) {
            return Result.success("司机状态变为1");
        }
        return Result.error("司机状态改变失败");
    }

    @PutMapping("/tranFlagChangeIs0")
    public Result tranFlagChangeIs0(@RequestParam(value = "tran_id", required = true) int tran_id) {
        int i = orderService.tranFlagChangeIs0(tran_id);
        if (i > 0) {
            return Result.success("车状态改变成功");
        }
        return Result.error("车状态改变失败");
    }

    @PutMapping("/orderFlagChangeIs1")
    public Result orderFlagChangeIs1(@RequestParam(value = "order_id", required = true) int order_id) {
        int i = orderService.orderFlagChangeIs1(order_id);
        if (i > 0) {
            return Result.success("订单状态改变成功");
        }
        return Result.error("订单状态改变失败");
    }

    @GetMapping("/createOrderId")
    public Result createOrderId() {
        return Result.success(ODDGenerator.getOrderNo());
    }

    @PutMapping("/customerUpdateOrder")
    public Result customerUpdateOrder(@RequestBody Order order) {
        int i = orderService.customerUpdateOrder(order);
        if (i > 0) {
            return Result.success("订单修改成功");
        }
        return Result.error("修改失败");
    }

}
