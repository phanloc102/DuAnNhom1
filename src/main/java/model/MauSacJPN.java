/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class MauSacJPN {
    private String id;
    private String ten;
    private String ma;

    public MauSacJPN() {
    }

    public MauSacJPN(String ten, String ma) {
        this.ten = ten;
        this.ma = ma;
    }

    public MauSacJPN(String id, String ten, String ma) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
    public Object[] toDataRow() {
        return new Object[] {ten, ma};
    }
}