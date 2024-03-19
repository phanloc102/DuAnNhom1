/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

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
}
