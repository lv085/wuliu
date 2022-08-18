package com.wuliu.entity;

public class Driver {
    private int driver_id;
    private String driver_name;
    private String driver_username;
    private String driver_password;
    private int driver_state; //司机状态：0空闲，1忙碌

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriver_username() {
        return driver_username;
    }

    public void setDriver_username(String driver_username) {
        this.driver_username = driver_username;
    }

    public String getDriver_password() {
        return driver_password;
    }

    public void setDriver_password(String driver_password) {
        this.driver_password = driver_password;
    }

    public int getDriver_state() {
        return driver_state;
    }

    public void setDriver_state(int driver_state) {
        this.driver_state = driver_state;
    }

    public Driver(int driver_id, String driver_name, String driver_username, String driver_password, int driver_state) {
        this.driver_id = driver_id;
        this.driver_name = driver_name;
        this.driver_username = driver_username;
        this.driver_password = driver_password;
        this.driver_state = driver_state;
    }

    public Driver(String driver_name, String driver_username, String driver_password, int driver_state) {
        this.driver_name = driver_name;
        this.driver_username = driver_username;
        this.driver_password = driver_password;
        this.driver_state = driver_state;
    }

    public Driver() {
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driver_id=" + driver_id +
                ", driver_name='" + driver_name + '\'' +
                ", driver_username='" + driver_username + '\'' +
                ", driver_password='" + driver_password + '\'' +
                ", driver_state=" + driver_state +
                '}';
    }
}
