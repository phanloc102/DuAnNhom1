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
@Table(name = "MAUSAC")
public class MauSac {
    @Id 
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    
    @Column(name = "Tenmau")
    private String tenMau;
    
    @Column(name = "Mamau")
    private String maMau;

    @OneToMany(mappedBy = "mauSac",cascade = CascadeType.ALL)
    List<ChiTietSanPham> listCTSP = new ArrayList<>();
    
    public MauSac() {
    }

    public MauSac(String id, String tenMau, String maMau) {
        this.id = id;
        this.tenMau = tenMau;
        this.maMau = maMau;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    @Override
    public String toString() {
        return "MauSac{" + "id=" + id + ", tenMau=" + tenMau + ", maMau=" + maMau + '}';
    }
    
    
}
