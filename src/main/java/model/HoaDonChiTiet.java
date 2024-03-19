/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Hoang
 */
@Entity
@Table(name = "HOADONCHITIET")
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Idhd")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Idctsp")
    private ChiTietSanPham chiTietSanPham;

    @Column(name = "Soluong")
    private int soLuong;

    @Column(name = "Tongtien")
    private int tongTien;

    @Column(name = "Trangthai")
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String id, HoaDon hoaDon, ChiTietSanPham chiTietSanPham, int soLuong, int tongTien, int trangThai) {
        this.id = id;
        this.hoaDon = hoaDon;
        this.chiTietSanPham = chiTietSanPham;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public String thayDoiTrangThai(){
        if(trangThai == 0){
            return "Đã Thanh Toán";
        }
        return "Chưa Thanh Toán";
    }

    public String getMaHD(){
        return hoaDon.getMaHd();
    }
    @Override
    public String toString() {
        return "HoaDonChiTiet{" + getMaHD();
    }
    
    

}
