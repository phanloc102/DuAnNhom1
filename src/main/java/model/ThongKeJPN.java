/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Phan Loc
 */
public class ThongKeJPN {
    private String id;
    private String ma;
    private String ten;
    private int gia;
    private int soLuong;
    private int doanhThu;

    public ThongKeJPN() {
    }

    public ThongKeJPN(String ma, String ten, int gia, int soLuong, int doanhThu) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.doanhThu = doanhThu;
    }

    public ThongKeJPN(String id, String ma, String ten, int gia, int soLuong, int doanhThu) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.doanhThu = doanhThu;
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }
    
    public Object[] toDataRow(){
        return new Object[] {ma,ten,gia,soLuong,doanhThu};
    }
}
