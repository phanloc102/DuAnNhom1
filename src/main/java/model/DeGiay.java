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
@Table(name = "DEGIAY")
public class DeGiay {
    @Id 
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    
    @Column(name = "Made")
    private String maDe;
    
    @Column(name = "Chatlieude")
    private String chatLieuDe;
    
    @Column(name = "Docaode")
    private int chieuCaoDe;

    @OneToMany(mappedBy = "deGiay",cascade = CascadeType.ALL)
    List<ChiTietSanPham> listCTSP = new ArrayList<>();
    
    public DeGiay() {
    }

    public DeGiay(String id, String maDe, String chatLieuDe, int chieuCaoDe) {
        this.id = id;
        this.maDe = maDe;
        this.chatLieuDe = chatLieuDe;
        this.chieuCaoDe = chieuCaoDe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaDe() {
        return maDe;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }

    public String getChatLieuDe() {
        return chatLieuDe;
    }

    public void setChatLieuDe(String chatLieuDe) {
        this.chatLieuDe = chatLieuDe;
    }

    public int getChieuCaoDe() {
        return chieuCaoDe;
    }

    public void setChieuCaoDe(int chieuCaoDe) {
        this.chieuCaoDe = chieuCaoDe;
    }

    @Override
    public String toString() {
        return "DeGiay{" + "id=" + id + ", maDe=" + maDe + ", chatLieuDe=" + chatLieuDe + ", chieuCaoDe=" + chieuCaoDe + '}';
    }
    
    
}
