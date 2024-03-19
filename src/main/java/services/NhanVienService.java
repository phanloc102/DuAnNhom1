/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import Model.NhanVien;
import java.util.List;

/**
 *
 * @author PC
 */
public interface NhanVienService {

    List<NhanVien> getAll();

    List<NhanVien> getAll(String input);

    public String add(NhanVien cv);

    public String update(NhanVien cv);

    public String delete(NhanVien cv);

    public List<NhanVien> TK(String ten);

    public List<NhanVien> LocGT(String gioitinh);

    public List<NhanVien> LocTT(String trangthai);

    public List<String> getListTrangThai();

    public List<String> getListGioiTinh();

    public List<NhanVien> gettrangthai(String tt);
    //public List<NhanVien> getloctrangthai(String tt);

}
