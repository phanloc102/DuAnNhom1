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
@Table(name = "KIEUDANG")
public class KieuDang {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    
    @Column(name = "Id")
    private String id;
    
    @Column(name = "Tenkieu")
    private String tenKieu;
    
    @Column(name = "maKieu")
    private String maKieu;

    @OneToMany(mappedBy = "kieuDang",cascade = CascadeType.ALL)
    List<ChiTietSanPham> listCTSP = new ArrayList<>();
    
    public KieuDang() {
    }

    public KieuDang(String id, String tenKieu, String maKieu) {
        this.id = id;
        this.tenKieu = tenKieu;
        this.maKieu = maKieu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenKieu() {
        return tenKieu;
    }

    public void setTenKieu(String tenKieu) {
        this.tenKieu = tenKieu;
    }

    public String getMaKieu() {
        return maKieu;
    }

    public void setMaKieu(String maKieu) {
        this.maKieu = maKieu;
    }

    @Override
    public String toString() {
        return "KieuDang{" + "id=" + id + ", tenKieu=" + tenKieu + ", maKieu=" + maKieu + ", listCTSP=" + '}';
    }

    
}
