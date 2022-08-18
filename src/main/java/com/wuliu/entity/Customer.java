package com.wuliu.entity;

public class Customer {
    private int customer_id;
    private String customer_name; //客户姓名
    private String customer_tel;
    private String customer_username;
    private String customer_password;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_tel() {
        return customer_tel;
    }

    public void setCustomer_tel(String customer_tel) {
        this.customer_tel = customer_tel;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public Customer(int customer_id, String customer_name, String customer_tel, String customer_username, String customer_password) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_tel = customer_tel;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
    }

    public Customer(String customer_name, String customer_tel, String customer_username, String customer_password) {
        this.customer_name = customer_name;
        this.customer_tel = customer_tel;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_tel='" + customer_tel + '\'' +
                ", customer_username='" + customer_username + '\'' +
                ", customer_password='" + customer_password + '\'' +
                '}';
    }
}
