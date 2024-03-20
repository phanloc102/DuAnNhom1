/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.DeGiayJPN;
import responsitory.impl.DeGiayRepository;
import services.DegiayService;



/**
 *
 * @author Phan Loc
 */
public class DegiayServiceImpl implements DegiayService{
    private DeGiayRepository dgr = new DeGiayRepository();

    @Override
    public String Add(DeGiayJPN dg) {
      boolean add = dgr.Add(dg);
        if(add){
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }  
    }

    @Override
    public List<DeGiayJPN> getAll() {
        return dgr.getAll();
    }

    @Override
    public String Update(DeGiayJPN dg, String id) {
        boolean upKh = dgr.Update(dg, id);
        if(upKh){
            return "Update thanh cong";
        }else {
            return "Update that bai";
        }
    }

    @Override
    public String delete(String ma) {
        boolean upKh = dgr.delete(ma);
        if(upKh){
            return "Delete thanh cong";
        }else{
            return "Delete that bai";
        }
    }
}
