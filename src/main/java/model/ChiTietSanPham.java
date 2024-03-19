/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Table(name = "CHITIETSANPHAM")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Idsp")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Idkieu")
    private KieuDang kieuDang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Idms")
    private MauSac mauSac;

//    @Column(name = "Idms")
//    private String idMS;
//    @Column(name = "Idkieu")
//    private String idKieu;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Idsize")
    private sizeGiay sizeGiay;
//    @Column(name = "Idsize")
//    private String idSize;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Idde")
    private DeGiay deGiay;

//    @Column(name = "Idde")
//    private String idDe;
    @Column(name = "Mactsp")
    private String maCTSp;

    @Column(name = "Hinhanh")
    private String hinhAnh;

    @Column(name = "Soluong")
    private int soLuong;

    @Column(name = "Dongia")
    private int donGia;

    @Column(name = "Mota")
    private String moTa;

    @Column(name = "Trangthai")
    private int trangThai;

    @OneToMany(mappedBy = "chiTietSanPham",cascade = CascadeType.ALL)
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public String getMaCTSp() {
        return maCTSp;
    }

    public void setMaCTSp(String maCTSp) {
        this.maCTSp = maCTSp;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String thayDoiTrangThai() {
        if (trangThai == 0) {
            return "Còn Kinh Doanh";
        }
        return "Ngừng Kinh Doanh";
    }

    
    @Override
    public String toString() {
        return "ChiTietSanPham{ " ;
    }

}
