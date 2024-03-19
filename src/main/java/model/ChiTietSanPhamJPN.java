/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class ChiTietSanPhamJPN {
    private String id;
    private String ma;
    private String sanPham;
    private String mauSac;
    private String kieuDang;
    private String size;
    private String deGiay;
    private String hinhAnh;
    private int soLuong;
    private int donGia;
    private String moTa;
    private int trangThai;

    public ChiTietSanPhamJPN() {
    }

    public ChiTietSanPhamJPN(String sanPham, String mauSac, String kieuDang, String size, String deGiay, String ma, int soLuong, int donGia, String moTa, int trangThai) {
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.kieuDang = kieuDang;
        this.size = size;
        this.deGiay = deGiay;
        this.ma = ma;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public ChiTietSanPhamJPN(String id, String sanPham, String mauSac, String kieuDang, String size, String deGiay, String ma, String hinhAnh, int soLuong, int donGia, String moTa, int trangThai) {
        this.id = id;
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.kieuDang = kieuDang;
        this.size = size;
        this.deGiay = deGiay;
        this.ma = ma;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public ChiTietSanPhamJPN(String sanPham, String mauSac, String kieuDang, String size, String deGiay, String ma, String hinhAnh, int soLuong, int donGia, String moTa, int trangThai) {
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.kieuDang = kieuDang;
        this.size = size;
        this.deGiay = deGiay;
        this.ma = ma;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        this.sanPham = sanPham;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDeGiay() {
        return deGiay;
    }

    public void setDeGiay(String deGiay) {
        this.deGiay = deGiay;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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

    
    public String TrangThai(){
        if(trangThai == 0){
            return "Hết Hàng";
        }else{
            return "Còn Hàng";
        }
    }
    public Object[] toDataRow(){
        return new Object[] {ma,sanPham,kieuDang,size,mauSac,deGiay,donGia,soLuong,moTa,TrangThai()};
    }

    @Override
    public String toString() {
        return "ChiTietSanPhamJPN{" + "id=" + id + ", ma=" + ma + ", sanPham=" + sanPham + ", mauSac=" + mauSac + ", kieuDang=" + kieuDang + ", size=" + size + ", deGiay=" + deGiay + ", hinhAnh=" + hinhAnh + ", soLuong=" + soLuong + ", donGia=" + donGia + ", moTa=" + moTa + ", trangThai=" + trangThai + '}';
    }
    
}
