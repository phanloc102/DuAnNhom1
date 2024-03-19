/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

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

/**
 *
 * @author Hoang
 */
public interface IRPBanHang {

    public List<ChiTietSanPham> getChiTietSanPham();

    public List<sizeGiay> getListSizeGiay();

    public List<SanPham> getListSanPham();

    public List<DeGiay> getListDeGiay();

    public List<MauSac> getListMauSac();

    public List<KieuDang> getListKieudang();

    public List<KhachHang> getListKhachHang();

    public List<HoaDonChiTiet> getListHoaDonChiTiet();

    public List<HoaDon> getListHoaDon();

    public boolean themKh(KhachHang kh);

    //new 
    public HoaDon getObjHoaDonbyMa(String ma);

    public ChiTietSanPham getObjCTSPbyMa(String ma);

    public HoaDonChiTiet getObjHoaDonCTbyid(String id);

    //save 
    public void createCTSP(ChiTietSanPham ctsp) throws Exception;

    public void createHoaDonCT(HoaDonChiTiet hdct) throws Exception;

    public void createHoaDon(HoaDon hd) throws Exception;

    //delete hoadonct
    public void deleteHoaDonCT(String id) throws Exception;
}
