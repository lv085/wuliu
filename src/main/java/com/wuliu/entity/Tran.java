package com.wuliu.entity;

public class Tran {
    private int tran_id;
    private String tran_name;
    private double tran_money;
    private int tran_state; //工具状态：0运输中，1正常

    public int getTran_id() {
        return tran_id;
    }

    public void setTran_id(int tran_id) {
        this.tran_id = tran_id;
    }

    public String getTran_name() {
        return tran_name;
    }

    public void setTran_name(String tran_name) {
        this.tran_name = tran_name;
    }

    public double getTran_money() {
        return tran_money;
    }

    public void setTran_money(double tran_money) {
        this.tran_money = tran_money;
    }

    public int getTran_state() {
        return tran_state;
    }

    public void setTran_state(int tran_state) {
        this.tran_state = tran_state;
    }

    public Tran(int tran_id, String tran_name, double tran_money, int tran_state) {
        this.tran_id = tran_id;
        this.tran_name = tran_name;
        this.tran_money = tran_money;
        this.tran_state = tran_state;
    }

    public Tran(String tran_name, double tran_money, int tran_state) {
        this.tran_name = tran_name;
        this.tran_money = tran_money;
        this.tran_state = tran_state;
    }

    public Tran() {
    }

    @Override
    public String toString() {
        return "Tran{" +
                "tran_id=" + tran_id +
                ", tran_name='" + tran_name + '\'' +
                ", tran_money=" + tran_money +
                ", tran_state=" + tran_state +
                '}';
    }
}
