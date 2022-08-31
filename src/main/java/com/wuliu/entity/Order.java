package com.wuliu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Order {
    private int order_id; //运单id
    private String order_no; //运单号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date send_date; //发货日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date arrive_date; //到货日期
    private String send_address; //发货地址
    private String arrive_address; //收货地址
    private int order_state; //运单状态：0待审核，1运输中，2已到货，3订单完成
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date order_create_date; //运单创建时间
    private double order_money; //运费
    private String order_arrive_username; //收货人姓名
    private String order_arrive_usertel; //收货人电话
    private Customer order_customer; //下单客户（外键）
    private Driver order_driver; //司机（外键）
    private Tran order_tran; //运输工具（外键）

    public Order(int order_id, String order_no, Date send_date, Date arrive_date, String send_address, String arrive_address, int order_state, Date order_create_date, double order_money, Customer order_customer, String order_arrive_username, String order_arrive_usertel, Driver order_driver, Tran order_tran) {
        this.order_id = order_id;
        this.order_no = order_no;
        this.send_date = send_date;
        this.arrive_date = arrive_date;
        this.send_address = send_address;
        this.arrive_address = arrive_address;
        this.order_state = order_state;
        this.order_create_date = order_create_date;
        this.order_money = order_money;
        this.order_customer = order_customer;
        this.order_arrive_username = order_arrive_username;
        this.order_arrive_usertel = order_arrive_usertel;
        this.order_driver = order_driver;
        this.order_tran = order_tran;
    }

    public Order(String order_no, Date send_date, Date arrive_date, String send_address, String arrive_address, int order_state, Date order_create_date, double order_money, Customer order_customer, String order_arrive_username, String order_arrive_usertel, Driver order_driver, Tran order_tran) {
        this.order_no = order_no;
        this.send_date = send_date;
        this.arrive_date = arrive_date;
        this.send_address = send_address;
        this.arrive_address = arrive_address;
        this.order_state = order_state;
        this.order_create_date = order_create_date;
        this.order_money = order_money;
        this.order_customer = order_customer;
        this.order_arrive_username = order_arrive_username;
        this.order_arrive_usertel = order_arrive_usertel;
        this.order_driver = order_driver;
        this.order_tran = order_tran;
    }

}
