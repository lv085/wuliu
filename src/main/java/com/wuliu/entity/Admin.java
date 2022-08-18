package com.wuliu.entity;

public class Admin {
    private int admin_id;
    private String admin_name;
    private String admin_username;
    private String admin_password;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public Admin(int admin_id, String admin_name, String admin_username, String admin_password) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_username = admin_username;
        this.admin_password = admin_password;
    }

    public Admin(String admin_name, String admin_username, String admin_password) {
        this.admin_name = admin_name;
        this.admin_username = admin_username;
        this.admin_password = admin_password;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_username='" + admin_username + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }
}
