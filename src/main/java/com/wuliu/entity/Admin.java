package com.wuliu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private int admin_id;
    private String admin_name;
    private String admin_username;
    private String admin_password;

    public Admin(String admin_name, String admin_username, String admin_password) {
        this.admin_name = admin_name;
        this.admin_username = admin_username;
        this.admin_password = admin_password;
    }

}
