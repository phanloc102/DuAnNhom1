/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class NhanVien {

    private String manv;
    private String ten;
    private String diachi;
    private String gioitinh;
    private String ngaysinh;
    private String email;
    private String sdt;
    private String luong;
    private String trangthai;

    public NhanVien() {
    }

    public NhanVien(String manv, String ten, String diachi, String gioitinh, String ngaysinh, String email, String sdt, String luong, String trangthai) {
        this.manv = manv;
        this.ten = ten;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.sdt = sdt;
        this.luong = luong;
        this.trangthai = trangthai;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "manv=" + manv + ", ten=" + ten + ", diachi=" + diachi + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh + ", email=" + email + ", sdt=" + sdt + ", luong=" + luong + ", trangthai=" + trangthai + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{manv, ten, diachi, gioitinh, ngaysinh, email, sdt, luong, trangthai};
    }
}
