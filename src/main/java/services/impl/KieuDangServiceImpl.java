/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.KieuDangJPN;
import responsitory.impl.KieuDangRepository;
import services.KieuDangService;



/**
 *
 * @author Phan Loc
 */
public class KieuDangServiceImpl implements KieuDangService{
    private KieuDangRepository kdr = new KieuDangRepository();

    @Override
    public String Add(KieuDangJPN kd) {
        boolean add = kdr.Add(kd);
        if(add){
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public List<KieuDangJPN> getAll() {
        return kdr.getAll();
    }

    @Override
    public String delete(String ma) {
        boolean upkh = kdr.delete(ma);
        if(upkh){
            return "Delete thanh cong";
        }else{
            return "Delete that bai";
        }
        }
}
