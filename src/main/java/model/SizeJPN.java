/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
public class SizeJPN {
    private String id;
    private int ten;
    private String ma;

    public SizeJPN() {
    }

    public SizeJPN(int ten, String ma) {
        this.ten = ten;
        this.ma = ma;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Object[] toDataRow() {
        return new Object[] {ma,ten};
    }
}
