/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

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
}
