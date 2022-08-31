package com.wuliu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tran {
    private int tran_id;
    private String tran_name;
    private double tran_money;
    private int tran_state; //工具状态：0运输中，1正常

    public Tran(String tran_name, double tran_money, int tran_state) {
        this.tran_name = tran_name;
        this.tran_money = tran_money;
        this.tran_state = tran_state;
    }

}
