/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.ChiTietSanPhamJPN;

/**
 *
 * @author Phan Loc
 */
public interface ChiTietSanPhamService {

    public List<ChiTietSanPhamJPN> getAll();

    String add(ChiTietSanPhamJPN ctsp);

    String delete(String id);

    String update(ChiTietSanPhamJPN ctsp, String id);

    public List<ChiTietSanPhamJPN> TK(String ten);

    public List<ChiTietSanPhamJPN> Loc(String ten);

    public List<ChiTietSanPhamJPN> Loc1(String ten);

    public List<String> getListMauSac();

    public List<String> getListKieuDang();

    public List<String> getListSize();

    public List<String> getListChieuCao();

    public List<String> getListTrangThai();
}
