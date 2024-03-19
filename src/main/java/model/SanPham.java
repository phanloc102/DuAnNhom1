/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Hoang
 */
@Entity
@Table(name = "SANPHAM")
public class SanPham {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id")
    private String id;
    @Column(name = "Masp")
    private String maSp;
    @Column(name = "Ten")
    private String tenSp;
   
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
    List<ChiTietSanPham> listCTSP = new ArrayList<>();

    public SanPham() {
    }

    public SanPham(String id, String maSp, String tenSp) {
        this.id = id;
        this.maSp = maSp;
        this.tenSp = tenSp;
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public List<ChiTietSanPham> getListCTSP() {
        return listCTSP;
    }

    public void setListCTSP(List<ChiTietSanPham> listCTSP) {
        this.listCTSP = listCTSP;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", maSp=" + maSp + ", tenSp=" + tenSp +  '}';
    }

    
}
