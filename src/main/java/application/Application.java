/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import Ultility.HibernateUtils;
import model.ChiTietSanPham;
import model.HoaDon;
import org.hibernate.Session;
import responsitory.IRPBanHang;
import responsitory.impl.BanHangIMP;
import services.ISVBanHang;
import services.impl.SVBanHangIMPL;

/**
 *
 * @author hungs
 */
public class Application {
    public static void main(String[] args) {
//        Session s = HibernateUtils.getSesionFactory().openSession();
//        HoaDon hd = s.get(HoaDon.class, "B6FF00B2-0646-4DEF-A7BC-DB1C4A12E78F");
//        
//      
//        
//        hd.getListHDCT().forEach(x->{
//            System.out.println(x);
//        });
//        s.close();

        ISVBanHang bh = new SVBanHangIMPL();
         ChiTietSanPham ctsp=  bh.getObjCTSPbyMa("CTSP1");
         System.out.println(ctsp);
    }
}
