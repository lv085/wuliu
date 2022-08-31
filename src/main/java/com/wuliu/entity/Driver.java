package com.wuliu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    private int driver_id;
    private String driver_name;
    private String driver_username;
    private String driver_password;
    private int driver_state; //司机状态：0空闲，1忙碌

    public Driver(String driver_name, String driver_username, String driver_password, int driver_state) {
        this.driver_name = driver_name;
        this.driver_username = driver_username;
        this.driver_password = driver_password;
        this.driver_state = driver_state;
    }

}
