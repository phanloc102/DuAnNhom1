/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.SizeJPN;
import responsitory.impl.SizeRepository;
import services.SizeService;



/**
 *
 * @author Phan Loc
 */
public class SizeServiceImpl implements SizeService{
    private SizeRepository sr = new SizeRepository();

    @Override
    public String Add(SizeJPN s) {
        boolean add = sr.Add(s);
        if(add){
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public List<SizeJPN> getAll() {
        return sr.getAll();
    }

    @Override
    public String delete(String ma) {
        boolean upkh = sr.delete(ma);
        if(upkh){
            return "Delete thanh cong";
        }else{
            return "Delete that bai";
        }
        }
}
