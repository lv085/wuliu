package com.wuliu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

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

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public Date getSend_date() {
        return send_date;
    }

    public void setSend_date(Date send_date) {
        this.send_date = send_date;
    }

    public Date getArrive_date() {
        return arrive_date;
    }

    public void setArrive_date(Date arrive_date) {
        this.arrive_date = arrive_date;
    }

    public String getSend_address() {
        return send_address;
    }

    public void setSend_address(String send_address) {
        this.send_address = send_address;
    }

    public String getArrive_address() {
        return arrive_address;
    }

    public void setArrive_address(String arrive_address) {
        this.arrive_address = arrive_address;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public Date getOrder_create_date() {
        return order_create_date;
    }

    public void setOrder_create_date(Date order_create_date) {
        this.order_create_date = order_create_date;
    }

    public double getOrder_money() {
        return order_money;
    }

    public void setOrder_money(double order_money) {
        this.order_money = order_money;
    }

    public Customer getOrder_customer() {
        return order_customer;
    }

    public void setOrder_customer(Customer order_customer) {
        this.order_customer = order_customer;
    }

    public String getOrder_arrive_username() {
        return order_arrive_username;
    }

    public void setOrder_arrive_username(String order_arrive_username) {
        this.order_arrive_username = order_arrive_username;
    }

    public String getOrder_arrive_usertel() {
        return order_arrive_usertel;
    }

    public void setOrder_arrive_usertel(String order_arrive_usertel) {
        this.order_arrive_usertel = order_arrive_usertel;
    }

    public Driver getOrder_driver() {
        return order_driver;
    }

    public void setOrder_driver(Driver order_driver) {
        this.order_driver = order_driver;
    }

    public Tran getOrder_tran() {
        return order_tran;
    }

    public void setOrder_tran(Tran order_tran) {
        this.order_tran = order_tran;
    }

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

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_no='" + order_no + '\'' +
                ", send_date=" + send_date +
                ", arrive_date=" + arrive_date +
                ", send_address='" + send_address + '\'' +
                ", arrive_address='" + arrive_address + '\'' +
                ", order_state=" + order_state +
                ", order_create_date=" + order_create_date +
                ", order_money=" + order_money +
                ", order_customer=" + order_customer +
                ", order_arrive_username='" + order_arrive_username + '\'' +
                ", order_arrive_usertel='" + order_arrive_usertel + '\'' +
                ", order_driver=" + order_driver +
                ", order_tran=" + order_tran +
                '}';
    }
}
