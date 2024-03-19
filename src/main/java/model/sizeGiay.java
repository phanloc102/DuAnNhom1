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
@Table(name = "SIZE")
public class sizeGiay {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    
    @Column(name = "Tensize")
    private String tenSize;
    
    @Column(name = "Masize")
    private String maSize;

    @OneToMany(mappedBy = "sizeGiay",cascade = CascadeType.ALL)
    List<ChiTietSanPham> listCTSP = new ArrayList<>();
    
    public sizeGiay() {
    }

    public sizeGiay(String id, String tenSize, String maSize) {
        this.id = id;
        this.tenSize = tenSize;
        this.maSize = maSize;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public List<ChiTietSanPham> getListCTSP() {
        return listCTSP;
    }

    public void setListCTSP(List<ChiTietSanPham> listCTSP) {
        this.listCTSP = listCTSP;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    @Override
    public String toString() {
        return "sizeGiay{" + "id=" + id + ", tenSize=" + tenSize + ", maSize=" + maSize +  '}';
    }
    
    
}
