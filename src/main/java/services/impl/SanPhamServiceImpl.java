/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;


import java.util.List;
import model.SanPhamJPN;
import responsitory.impl.SanPhamRepository;
import services.SanPhamService;

/**
 *
 * @author Phan Loc
 */
public class SanPhamServiceImpl implements SanPhamService{
    private SanPhamRepository spr = new SanPhamRepository();

    @Override
    public List<SanPhamJPN> getAll() {
        return spr.getAll();
    }

    @Override
    public String add(SanPhamJPN sp) {
        boolean add = spr.add(sp);
        if(add){
            return "Thêm thành công";
        }else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(SanPhamJPN sp, String id) {
        boolean update = spr.update(sp, id);
        if(update){
            return "Sửa thành công";
        }else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = spr.delete(id);
        if(delete){
            return "Xóa thành công";
        }else {
            return "Xóa thất bại";
        }
    }
}
