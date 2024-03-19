/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import Ultility.HibernateUtils;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSanPham;
import model.DeGiay;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KieuDang;
import model.MauSac;
import model.SanPham;
import model.sizeGiay;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import responsitory.IRPBanHang;

/**
 *
 * @author Hoang
 */
public class BanHangIMP implements IRPBanHang {

//    public List<ChiTietSanPham> getall(){
//        try (Session s = HibernateUtils.getSesionFactory().openSession()){
//            List<ChiTietSanPham> list = new ArrayList<>();
//            TypedQuery<ChiTietSanPham> qr = s.createQuery("from ChiTietSanPham");
//            list = qr.getResultList();
//            s.close();
//            return list;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    @Override
    public List<ChiTietSanPham> getChiTietSanPham() {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<ChiTietSanPham> list = new ArrayList<>();
            TypedQuery<ChiTietSanPham> qr = s.createQuery("from ChiTietSanPham");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<sizeGiay> getListSizeGiay() {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<sizeGiay> listSG = new ArrayList<>();
            TypedQuery<sizeGiay> sg = s.createQuery("from sizeGiay");
            listSG = sg.getResultList();
            s.clear();
            return listSG;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SanPham> getListSanPham() {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<SanPham> listSP = new ArrayList<>();
            TypedQuery<SanPham> sp = s.createQuery("from SanPham");
            listSP = sp.getResultList();
            s.clear();;
            return listSP;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<DeGiay> getListDeGiay() {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<DeGiay> listDG = new ArrayList<>();
            TypedQuery dg = s.createQuery("from DeGiay");
            listDG = dg.getResultList();
            s.clear();
            return listDG;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<MauSac> getListMauSac() {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<MauSac> listMS = new ArrayList<>();
            TypedQuery ms = s.createQuery("from MauSac");
            listMS = ms.getResultList();
            s.clear();
            return listMS;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<KieuDang> getListKieudang() {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<KieuDang> listKD = new ArrayList<>();
            TypedQuery kd = s.createQuery("from KieuDang");
            listKD = kd.getResultList();
            s.clear();
            return listKD;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<KhachHang> getListKhachHang() {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<KhachHang> listKH = new ArrayList<>();
            TypedQuery query = s.createQuery("from KhachHang");
            listKH = query.getResultList();
            s.clear();
            return listKH;
        } catch (Exception x) {
            return null;
        }
    }

    @Override
    public List<HoaDonChiTiet> getListHoaDonChiTiet() {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<HoaDonChiTiet> listHDCT = new ArrayList<>();
            TypedQuery query = s.createQuery("from HoaDonChiTiet");
            listHDCT = query.getResultList();
            s.close();
            return listHDCT;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<HoaDon> getListHoaDon() {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<HoaDon> listHD = new ArrayList<>();
            TypedQuery query = s.createQuery("from HoaDon");
            listHD = query.getResultList();
            s.close();
            return listHD;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean themKh(KhachHang kh) {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                s.saveOrUpdate(kh);
                trans.commit();
                s.close();
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public HoaDon getObjHoaDonbyMa(String ma) {
        HoaDon nd;
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            Query qr = s.createQuery("from HoaDon where maHd=:ma", HoaDon.class);
            qr.setParameter("ma", ma);
            nd = (HoaDon) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChiTietSanPham getObjCTSPbyMa(String ma) {
        ChiTietSanPham ctsp;
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            Query qr = s.createQuery("from ChiTietSanPham where maCTSp=:ma", ChiTietSanPham.class);
            qr.setParameter("ma", ma);
            ctsp = (ChiTietSanPham) qr.getSingleResult();
            s.close();
            return ctsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public HoaDonChiTiet getObjHoaDonCTbyid(String id) {
        HoaDonChiTiet hdct;
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            Query qr = s.createQuery("from HoaDonChiTiet where id=:id", HoaDonChiTiet.class);
            qr.setParameter("id", id);
            hdct = (HoaDonChiTiet) qr.getSingleResult();
            s.close();
            return hdct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        BanHangIMP bh = new BanHangIMP();
        bh.getListSanPham().forEach(x->{
            System.out.println(x);
        });
    }
// save update bán hang
    @Override
    public void createCTSP(ChiTietSanPham ctsp) throws Exception {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                s.saveOrUpdate(ctsp);
                trans.commit();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createHoaDonCT(HoaDonChiTiet hdct) throws Exception {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                s.saveOrUpdate(hdct);
                trans.commit();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createHoaDon(HoaDon hd) throws Exception {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                s.saveOrUpdate(hd);
                trans.commit();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteHoaDonCT(String id) throws Exception {
        try ( Session s = HibernateUtils.getSesionFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                Query qr = s.createQuery("delete from HoaDonChiTiet where id=:id");
                qr.setParameter("id", id);
                qr.executeUpdate();
                trans.commit();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
