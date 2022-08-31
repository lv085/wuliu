package com.wuliu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int customer_id;
    private String customer_name; //客户姓名
    private String customer_tel;
    private String customer_username;
    private String customer_password;

    public Customer(String customer_name, String customer_tel, String customer_username, String customer_password) {
        this.customer_name = customer_name;
        this.customer_tel = customer_tel;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
    }

}
