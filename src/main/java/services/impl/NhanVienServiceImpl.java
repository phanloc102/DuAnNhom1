/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import Model.NhanVien;
import responsitory.impl.NhanVienResponsitory;
import java.util.ArrayList;
import java.util.List;
import services.NhanVienService;

public class NhanVienServiceImpl implements NhanVienService {

    private List<NhanVien> lsNhanVien;
    NhanVienResponsitory ql;
    private NhanVienResponsitory NhanVienResponitory;
    private NhanVienResponsitory nv = new NhanVienResponsitory();

    public NhanVienServiceImpl() {
        ql = new NhanVienResponsitory();
    }

    public List<NhanVien> getAll() {
        return ql.getAll();

    }

    public List<NhanVien> getAll(String input) {
        if (input == null) {
            return ql.getAll();
        }
        List<NhanVien> temp = new ArrayList<>();
        for (NhanVien x : ql.getAll()) {
            if (x.getManv().contains(input)) {
                temp.add(x);
            }
        }

        return temp;
    }

    public String add(NhanVien nv) {

        if (ql.add(nv)) {

            return "thanh cong";
        }
        return "that bai";
    }

    public String update(NhanVien nv) {
        if (ql.update(nv)) {

            return "Sua thành công";
        }
        return "Không sua duoc";
    }

    public String delete(NhanVien nv) {
        if (ql.delete(nv)) {

            return "thanh cong";
        }
        return "that bai";
    }

    public List<NhanVien> TK(String ten) {
        return nv.Tk(ten);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<NhanVien> LocGT(String gioitinh) {
        return nv.LocGT(gioitinh);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<String> getListTrangThai() {
        return nv.getListTrangThai();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<String> getListGioiTinh() {
        return nv.getListGioiTinh();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public NhanVien getbyma(String ma) {
        for (NhanVien x : ql.getAll()) {
            if (x.getManv().equalsIgnoreCase(ma)) {
                return x;
            }
        }
        return null;
    }

    public List<NhanVien> LocTT(String trangthai) {
        return nv.LocTT(trangthai);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhanVien> gettrangthai(String tt) {
        List<NhanVien> temp = new ArrayList<>();
        for (NhanVien x : ql.getAll()) {
            if (x.getManv().equalsIgnoreCase(tt)) {
                temp.add(x);
            }
        }
        return temp;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
