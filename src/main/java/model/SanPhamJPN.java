/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class SanPhamJPN {
    private String id;
    private String ma;
    private String ten;
    

    public SanPhamJPN() {
    }

    public SanPhamJPN(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
       
    }

    public SanPhamJPN(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    
    
    public Object[] toDataRow(){
        return new Object[] {id,ma,ten};
    }

}
