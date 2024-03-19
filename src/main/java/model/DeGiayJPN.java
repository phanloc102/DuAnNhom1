/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class DeGiayJPN {
    private String id;
    private String Made;
    private String chatLieu;
    private int doCao;

    public DeGiayJPN() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMade() {
        return Made;
    }

    public void setMade(String Made) {
        this.Made = Made;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public int getDoCao() {
        return doCao;
    }

    public void setDoCao(int doCao) {
        this.doCao = doCao;
    }

    public DeGiayJPN(String Made, String chatLieu, int doCao) {
        this.Made = Made;
        this.chatLieu = chatLieu;
        this.doCao = doCao;
    }

    
}
