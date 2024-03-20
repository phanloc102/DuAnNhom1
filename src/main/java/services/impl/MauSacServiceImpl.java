/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.MauSacJPN;
import responsitory.impl.MauSacRepository;
import services.MauSacService;



/**
 *
 * @author Phan Loc
 */
public class MauSacServiceImpl implements MauSacService{
    private MauSacRepository msr = new MauSacRepository();

    @Override
    public String Add(MauSacJPN ms) {
        boolean Add = msr.Add(ms);
        if(Add){
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public List<MauSacJPN> getAll() {
        return msr.getAll();
    }

    @Override
    public String delete(String ma) {
        boolean upkh = msr.delete(ma);
        if(upkh){
            return "Delete thanh cong";
        }else{
            return "Delete that bai";
        }
        }
}
