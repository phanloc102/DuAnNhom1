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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Hoang
 */
@Entity
@Getter
@Setter
@Table(name = "HOADON")
public class HoaDon {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Idkh")
    private KhachHang khachHang;

  

    @JoinColumn(name = "Idnv")
    private String idnv;


    @JoinColumn(name = "Mahd")
    private String maHd;
   

    @JoinColumn(name = "Ngaytao")
    private Date ngayTao;

    //test
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "hoaDon",fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();

    public HoaDon() {
    }

    public HoaDon(String id, KhachHang khachHang, String idnv, String maHd, Date ngayTao) {
        this.id = id;
        this.khachHang = khachHang;
        this.idnv = idnv;
        this.maHd = maHd;
        this.ngayTao = ngayTao;
    }

   

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", maHd=" + maHd + ", idKH=" + khachHang + ", idnv=" + idnv + ", ngayTao=" + ngayTao + '}';
    }

}
