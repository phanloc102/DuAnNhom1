/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ChiTietSanPham;
import model.DeGiay;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KieuDang;
import model.MauSac;
import model.SanPham;
import model.sizeGiay;
import responsitory.impl.BanHangIMP;
import services.ISVBanHang;
import responsitory.IRPBanHang;

public class SVBanHangIMPL implements ISVBanHang {
    
    private IRPBanHang repoSanPham = new BanHangIMP();
    
    @Override
    public List<ChiTietSanPham> getListChiTietSanPham() {
        return repoSanPham.getChiTietSanPham();
    }
    
    @Override
    public ChiTietSanPham getMaSp(String maSp) {
        for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
            if (ctsp.getSanPham().getMaSp().equalsIgnoreCase(maSp)) {
                return ctsp;
            }
        }
        return null;
    }
    
    @Override
    public List<ChiTietSanPham> searchByMa(String maSp) {
        List<ChiTietSanPham> listSearch = new ArrayList<>();
        for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
            if (ctsp.getSanPham().getTenSp().contains(maSp)) {
                listSearch.add(ctsp);
            }
        }
        return listSearch;
    }
    
    @Override
    public List<sizeGiay> getListSizeGiay() {
        return repoSanPham.getListSizeGiay();
    }
    
    @Override
    public List<SanPham> getListSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<DeGiay> getListDeGiay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<MauSac> getListMauSac() {
        return repoSanPham.getListMauSac();
    }
    
    @Override
    public List<KieuDang> getListKieudang() {
        return repoSanPham.getListKieudang();
    }
    
    @Override
    public List<KhachHang> getListKhachHang() {
        return repoSanPham.getListKhachHang();
    }
    
    @Override
    public List<HoaDonChiTiet> getListHoaDonChiTiet() {
        return repoSanPham.getListHoaDonChiTiet();
    }
    
    @Override
    public List<HoaDon> getListHoaDon() {
        return repoSanPham.getListHoaDon();
    }
    
    @Override
    public String checkKhacHang(int sdt) {
        String tenKhachHang = null;
        for (KhachHang kh : repoSanPham.getListKhachHang()) {
            if (kh.getSdt() == sdt) {
                tenKhachHang = kh.getTenKH();
                return tenKhachHang;
            }
        }
        return "null";
    }
    
    @Override
    public boolean themKhachHang(KhachHang kh) {
        kh.setId(null);
        if (repoSanPham.themKh(kh)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean checkTrungSdt(int sdt) {
        for (KhachHang kh : repoSanPham.getListKhachHang()) {
            if (kh.getSdt() == sdt) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public HoaDonChiTiet getMaHD(String maHD) {
        for (HoaDonChiTiet hd : repoSanPham.getListHoaDonChiTiet()) {
            if (hd.getHoaDon().getMaHd().equalsIgnoreCase(maHD)) {
                return hd;
            }
        }
        return null;
    }
    
    @Override
    public List<ChiTietSanPham> searchKhoangGia(String khoangGia, String kieu, String size) {
        List<ChiTietSanPham> listSearch = new ArrayList<>();
        
        
        for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
            if (khoangGia.equals("Dưới 500")
                    && ctsp.getKieuDang().getTenKieu().contains(kieu)
                    && ctsp.getSizeGiay().getTenSize().contains(size)) {
//            for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
                if (ctsp.getKieuDang().getTenKieu().contains(kieu) && ctsp.getDonGia() < 500
                        && ctsp.getSizeGiay().getTenSize().contains(size)) {
                    listSearch.add(ctsp);
                }
            }
        }
        
        for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
            if (khoangGia.equals("Từ 500 Đến 1Tr")
                    && ctsp.getKieuDang().getTenKieu().contains(kieu)
                    && ctsp.getSizeGiay().getTenSize().contains(size)) {
                if (ctsp.getKieuDang().getTenKieu().contains(kieu)
                        && ctsp.getDonGia() >= 500 && ctsp.getDonGia() <= 1000
                        && ctsp.getSizeGiay().getTenSize().contains(size)) {
                    listSearch.add(ctsp);
                }
            }
        }
        
        for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
            if (khoangGia.equals("Từ 1Tr Đến 5Tr")
                    && ctsp.getKieuDang().getTenKieu().contains(kieu)
                    && ctsp.getSizeGiay().getTenSize().contains(size)) {
                if (ctsp.getKieuDang().getTenKieu().contains(kieu)
                        && ctsp.getDonGia() > 1000 && ctsp.getDonGia() <= 5000
                        && ctsp.getSizeGiay().getTenSize().contains(size)) {
                    listSearch.add(ctsp);
                }
            }
        }
        
        for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
            if (khoangGia.equals("Từ 5Tr Đến 10Tr")
                    && ctsp.getKieuDang().getTenKieu().contains(kieu)
                    && ctsp.getSizeGiay().getTenSize().contains(size)) {
                if (ctsp.getKieuDang().getTenKieu().contains(kieu)
                        && ctsp.getDonGia() > 5000 && ctsp.getDonGia() <= 10000
                        && ctsp.getSizeGiay().getTenSize().contains(size)) {
                    listSearch.add(ctsp);
                }
            }
        }
        
        for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
            if (khoangGia.equals("Trên 10Tr")
                    && ctsp.getKieuDang().getTenKieu().contains(kieu)
                    && ctsp.getSizeGiay().getTenSize().contains(size)) {
                if (ctsp.getKieuDang().getTenKieu().contains(kieu)
                        && ctsp.getDonGia() > 10000
                        && ctsp.getSizeGiay().getTenSize().contains(size)) {
                    listSearch.add(ctsp);
                }
            }
        }
        
        return listSearch;
        
    }

//    @Override
//    public List<ChiTietSanPham> searchTrangThai(String trangThai) {
//        List<ChiTietSanPham> listSearch = new ArrayList<>();
//
//        if (trangThai.equals("Tất Cả")) {
//            for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
//                listSearch.add(ctsp);
//            }
//        }
//        if (trangThai.equals("Còn Kinh Doanh")) {
//            for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
//                if (ctsp.thayDoiTrangThai().equals(trangThai)) {
//                    listSearch.add(ctsp);
//                }
//            }
//        }
//        if (trangThai.equals("Ngừng Kinh Doanh")) {
//            for (ChiTietSanPham ctsp : repoSanPham.getChiTietSanPham()) {
//                if (ctsp.thayDoiTrangThai().equals(trangThai)) {
//                    listSearch.add(ctsp);
//                }
//            }
//        }
//
//        return listSearch;
//    }
    @Override
    public HoaDon getObjHoaDonbyMa(String ma) {
        return repoSanPham.getObjHoaDonbyMa(ma);
    }
    
    @Override
    public ChiTietSanPham getObjCTSPbyMa(String ma) {
            ChiTietSanPham ctsp = new ChiTietSanPham();
            for(ChiTietSanPham ctsp1 : repoSanPham.getChiTietSanPham()){
                if(ctsp1.getSanPham().getMaSp().contains(ma)){
                    return ctsp1;
                }
            }
            return null;
    }
    
    @Override
    public HoaDonChiTiet getObjHoaDonCTbyid(String id) {
        return repoSanPham.getObjHoaDonCTbyid(id);
    }
    
    @Override
    public void saveHoaDon(HoaDon hd) throws Exception {
        repoSanPham.createHoaDon(hd);
    }
    
    @Override
    public void updateHoaDon(HoaDon hd) throws Exception {
        repoSanPham.createHoaDon(hd);
    }
    
    @Override
    public void saveHoaDonCT(HoaDonChiTiet hct) throws Exception {
        repoSanPham.createHoaDonCT(hct);
    }
    
    @Override
    public void updateHoaDonCT(HoaDonChiTiet hct) throws Exception {
       repoSanPham.createHoaDonCT(hct);
    }
    
    @Override
    public void updateChiTietSP(ChiTietSanPham ctsp) throws Exception {
        repoSanPham.createCTSP(ctsp);
    }
    
    @Override
    public void deleteHoaDonCT(String ma) throws Exception {
        repoSanPham.deleteHoaDonCT(ma);
    }

    @Override
    public String getIdHDCT(String maHD) {
        for(HoaDonChiTiet hdct : repoSanPham.getListHoaDonChiTiet()){
            if(hdct.getHoaDon().getMaHd().contains(maHD)){
                return hdct.getId();
            }
        }
        return null;
    }

    @Override
    public void updateKhachHang(KhachHang kh) {
        repoSanPham.themKh(kh);
    }

    @Override
    public KhachHang getIdKhachHangbySDT(int sdt) {
        String id = null;
        for (KhachHang kh : repoSanPham.getListKhachHang()) {
            if (kh.getSdt() == sdt) 
                return kh;
            }
        return null;
    }
    
}
