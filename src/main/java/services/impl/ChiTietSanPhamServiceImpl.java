/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;



import java.util.ArrayList;
import java.util.List;
import model.ChiTietSanPhamJPN;
import responsitory.impl.ChiTietSanPhamRepository;
import services.ChiTietSanPhamService;

/**
 *
 * @author Phan Loc
 */
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService{

    private ChiTietSanPhamRepository ctspr = new ChiTietSanPhamRepository();
    
    @Override
    public List<ChiTietSanPhamJPN> getAll() {
        return ctspr.getAll();
    }


    @Override
    public String delete(String id) {
        boolean delete = ctspr.delete(id);
        if(delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String add(ChiTietSanPhamJPN ctsp) {
       
        boolean add = ctspr.add(ctsp);
        if(add) {
            return "Thêm Thành Công";
        }else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(ChiTietSanPhamJPN ctsp, String id) {
        boolean update = ctspr.update(ctsp, id);
        if(update){
            return "Sửa thành công";
        }else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<ChiTietSanPhamJPN> TK(String ten) {
        return ctspr.Tk(ten);
    }


    
    @Override
    public List<String> getListMauSac() {
        return ctspr.getListMauSac();
    }

    @Override
    public List<String> getListKieuDang() {
        return ctspr.getListKieuDang();
        }

    @Override
    public List<String> getListSize() {
        return ctspr.getListSize();
    }

    @Override
    public List<String> getListChieuCao() {
        return ctspr.getListChieuCao();
    }

    @Override
    public List<String> getListTrangThai() {
        return ctspr.getListTrangThai();
        
    }

    @Override
    public List<ChiTietSanPhamJPN> Loc(String ten) {
        return ctspr.Loc(ten);
    }

    @Override
    public List<ChiTietSanPhamJPN> Loc1(String ten) {
        return ctspr.Loc1(ten);
    }
    }


   
    

