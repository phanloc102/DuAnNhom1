package view;

import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import model.SanPham;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KieuDang;
import model.MauSac;
import model.sizeGiay;
import services.ISVBanHang;
import services.impl.SVBanHangIMPL;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoang
 */
public class GiaoDich extends javax.swing.JPanel {

    private ISVBanHang banHangServices;
    DefaultComboBoxModel dcbm;
    DefaultComboBoxModel dcbm1;
    DefaultComboBoxModel dcbm2;
    DefaultComboBoxModel dcbm3;
    List<String> listDonGia;
    List<String> listTrangThaiSP;
    List<ChiTietSanPham> listCTSPTT;
    int i = 0;
    int soDT;
    int index = -1;

    /**
     * Creates new form banHang
     */
    public GiaoDich() {
        banHangServices = new SVBanHangIMPL();
        dcbm = new DefaultComboBoxModel();
        dcbm1 = new DefaultComboBoxModel();
        dcbm2 = new DefaultComboBoxModel();
        listDonGia = new ArrayList<>();
        listTrangThaiSP = new ArrayList<>();
        initComponents();
        fillTableHoaDonCho(banHangServices.getListHoaDonChiTiet());
        fillTableSanPham(banHangServices.getListChiTietSanPham());
        dcbm = (DefaultComboBoxModel) cboSearhDonGia.getModel();
        dcbm2 = (DefaultComboBoxModel) cboSearhKieuDang.getModel();
        dcbm3 = (DefaultComboBoxModel) cboSearhSize.getModel();
        listDonGia.add("Dưới 500");
        listDonGia.add("Từ 500 Đến 1Tr");
        listDonGia.add("Từ 1Tr Đến 5Tr");
        listDonGia.add("Từ 5Tr Đến 10Tr");
        listDonGia.add("Trên 10Tr");

        listTrangThaiSP.add("Tất Cả");
        listTrangThaiSP.add("Còn Kinh Doanh");
        listTrangThaiSP.add("Ngừng Kinh Doanh");

//        String trangThai = "Tất Cả" ;
//        listCTSPTT = banHangServices.searchTrangThai(trangThai);
        fillDataCBB(listDonGia);
        fillDataCBBTT(listTrangThaiSP);
        fillDataCBBKieu(banHangServices.getListKieudang());
        fillDataCBBSize(banHangServices.getListSizeGiay());

    }

//  
    public void getTongTien1() {
        double tongTien = 0;
        for (HoaDonChiTiet hdct : banHangServices.getListHoaDonChiTiet()) {
            for (int i = 0; i < tblHoaDonCho.getRowCount(); i++) {
                String maHD = (String) tblHoaDonCho.getModel().getValueAt(1, 0);
                if (hdct.getHoaDon().getMaHd().contains(maHD)) {
                    tongTien += hdct.getSoLuong() * hdct.getChiTietSanPham().getDonGia();
                }
            }
        }

    }

    private void fillTableHoaDonCho(List<HoaDonChiTiet> listHDCT) {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblHoaDonCho.getModel();
        model.setRowCount(0);

        for (HoaDonChiTiet hdct : listHDCT) {
            if(hdct.getTrangThai() != 0 ){
            model.addRow(new Object[]{
                hdct.getHoaDon().getMaHd(), hdct.getHoaDon().getKhachHang().getTenKH(),
                hdct.thayDoiTrangThai()
            });
            }
        }
    }

    private void fillTableSanPham(List<ChiTietSanPham> listCTSP) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tbl_sanpham.getModel();
        dtm.setRowCount(0);
        for (ChiTietSanPham sp : listCTSP) {
            dtm.addRow(new Object[]{
                sp.getSanPham().getMaSp(), sp.getSanPham().getTenSp(),
                sp.getKieuDang().getTenKieu(), sp.getSizeGiay().getTenSize(),
                sp.getSoLuong(), sp.getDonGia(),});
        }
    }

    private void fillTableGioHang(List<HoaDonChiTiet> list) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tbl_GioHang.getModel();
        dtm.setRowCount(0);
        for (HoaDonChiTiet x : list) {
            dtm.addRow(new Object[]{
                x.getChiTietSanPham().getSanPham().getMaSp(),
                x.getChiTietSanPham().getSanPham().getTenSp(),
                x.getChiTietSanPham().getDonGia(),
                x.getSoLuong()
            });
        }
    }

    private void fillDataCBB(List<String> listDonGia1) {
        for (String s : listDonGia1) {
            dcbm.addElement(s);
        }
    }

    private void fillDataCBBTT(List<String> listTrangThai) {
        for (String s : listTrangThai) {
            dcbm1.addElement(s);
        }
    }

    private void fillDataCBBKieu(List<KieuDang> listKieu) {
        for (KieuDang kd : listKieu) {
            dcbm2.addElement(kd.getTenKieu());
        }
    }

    private void fillDataCBBSize(List<sizeGiay> listSize) {
        for (sizeGiay kd : listSize) {
            dcbm3.addElement(kd.getTenSize());
        }
    }

    private void searchCBB() {
        String giaTien = cboSearhDonGia.getSelectedItem().toString();
        String kieuDang = (String) cboSearhKieuDang.getSelectedItem();
        String size = (String) cboSearhSize.getSelectedItem();
        List<ChiTietSanPham> listCTSP = banHangServices.searchKhoangGia(giaTien, kieuDang, size);
        fillTableSanPham(listCTSP);
    }

    public KhachHang getKhachHang() {
        KhachHang kh = new KhachHang();
        return new KhachHang(null, kh.getMaKH(), txtTenKhachHang.getText(), kh.getDiaChi(), Integer.parseInt(txtCheckSdtKhachHang.getText()));
    }

//    public void inHoaDon() {
//        area.setText("**************************************\n\n");
//        area.setText(area.getText() + "*             HÓA ĐƠN     *\n\n");
//        area.setText(area.getText() + "***************************************\n\n");
//
//        area.setText(area.getText() + "SDT khach hang:   " + txtCheckSdtKhachHang.getText() + "\n");
//        area.setText(area.getText() + "Ten khach Hang:   " + txtTenKhachHang.getText() + "\n\n");
//        area.setText(area.getText() + "Ma hoa don:       " + lblMaHoaDon.getText() + "\n\n");
//        area.setText(area.getText() + "Soluonng:         " + lblSoLuong.getText() + "\n\n");
//        area.setText(area.getText() + "Tong tien:        " + lblTongTien.getText() + "\n\n");
//        area.setText(area.getText() + "Tien khach dua:   " + txtTienKhachDua.getText() + "\n\n");
//        area.setText(area.getText() + "Hinh thuc thanh toan:" + cboHinhThucThanhToan.getSelectedItem() + "\n\n");
//
//        try {
//            area.print();
//        } catch (Exception e) {
//            System.out.println("loi");
//        }
//    }
    
    public ImageIcon resizeImage(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnBanhang = new javax.swing.JPanel();
        lblAnh = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cboHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSearchTenSP = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        cboSearhDonGia = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cboSearhKieuDang = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cboSearhSize = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonCho = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_GioHang = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCheckSdtKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        btnCheckKhachHang = new javax.swing.JButton();
        AddKhachHang = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setForeground(new java.awt.Color(255, 255, 255));

        lblAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout lblAnhLayout = new javax.swing.GroupLayout(lblAnh);
        lblAnh.setLayout(lblAnhLayout);
        lblAnhLayout.setHorizontalGroup(
            lblAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );
        lblAnhLayout.setVerticalGroup(
            lblAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hóa Đơn Chờ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Hình Ảnh SP");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThanhToan.setBackground(new java.awt.Color(0, 153, 153));
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tick.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Warning.png"))); // NOI18N
        jButton4.setText("Hủy Hóa Đơn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã Hóa Đơn: ");

        btnTaoHoaDon.setBackground(new java.awt.Color(0, 255, 0));
        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel8.setText("Tổng Tiền");

        jLabel10.setText("Số Lượng");

        jLabel11.setText("Sản Phẩm");

        jLabel13.setText("Tiền Khách Đưa");

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        jLabel14.setText("VND");

        jLabel15.setText("Hình Thức Thanh Toán");

        cboHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản" }));
        cboHinhThucThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThucThanhToanActionPerformed(evt);
            }
        });

        jLabel19.setText("Tiền Thừa");

        jLabel18.setText("Tên Nhân Viên");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(cboHinhThucThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTaoHoaDon)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienKhachDua)
                            .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(105, 105, 105))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(35, 35, 35)
                                .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(jLabel13))
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel19)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Nhập Tên Sản Phẩm");

        txtSearchTenSP.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchTenSPCaretUpdate(evt);
            }
        });
        txtSearchTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchTenSPActionPerformed(evt);
            }
        });

        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Kiểu", "Size", "Số Lượng Tồn", "Đơn giá"
            }
        ));
        tbl_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_sanpham);

        cboSearhDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSearhDonGiaActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Đơn Giá");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel20.setText("Size");

        cboSearhKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSearhKieuDangActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setText("Kiểu");

        cboSearhSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSearhSizeActionPerformed(evt);
            }
        });

        btnLoc.setBackground(new java.awt.Color(0, 153, 153));
        btnLoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLoc.setForeground(new java.awt.Color(255, 255, 255));
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtSearchTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboSearhKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboSearhSize, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cboSearhDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearhDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearhKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearhSize, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Tên Khách Hàng ", "Trạng Thái"
            }
        ));
        tblHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonCho);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Giỏ Hàng");

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbl_GioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Đơn Giá", "Số Lượng"
            }
        ));
        jScrollPane2.setViewportView(tbl_GioHang);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Danh Sách Sản Phẩm");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("SDT Khách Hàng");

        jLabel12.setText("Tên Khách Hàng");

        btnCheckKhachHang.setText("Check");
        btnCheckKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckKhachHangActionPerformed(evt);
            }
        });

        AddKhachHang.setText("Thêm");
        AddKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddKhachHangActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCheckSdtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(AddKhachHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCheckSdtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckKhachHang))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddKhachHang)
                    .addComponent(btnUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnBanhangLayout = new javax.swing.GroupLayout(jpnBanhang);
        jpnBanhang.setLayout(jpnBanhangLayout);
        jpnBanhangLayout.setHorizontalGroup(
            jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanhangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpnBanhangLayout.createSequentialGroup()
                            .addGroup(jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnBanhangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnBanhangLayout.setVerticalGroup(
            jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanhangLayout.createSequentialGroup()
                .addGroup(jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnBanhangLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnBanhangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnBanhangLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnBanhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnBanhang, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckKhachHangActionPerformed
        String dinhDangSDT = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])"
                + "           |(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (txtCheckSdtKhachHang.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Số Điện Thoại Khách Hàng");
            return;
        }
        int checkKhachHang = Integer.parseInt(txtCheckSdtKhachHang.getText());
        String tenKH = banHangServices.checkKhacHang(checkKhachHang);

        boolean checkSDT = txtCheckSdtKhachHang.getText().matches(dinhDangSDT);
        if (checkSDT == false) {
            JOptionPane.showMessageDialog(this, "Số Điên Thoại Không Đúng Định Dạng");
            return;
        }
        if (tenKH.equals("null")) {
            JOptionPane.showMessageDialog(this, "Khách Hàng Mới Chưa Có Thông Tin");
            return;
        }
        txtTenKhachHang.setText(tenKH);
        index = 1;
        soDT = Integer.valueOf(txtCheckSdtKhachHang.getText());
    }//GEN-LAST:event_btnCheckKhachHangActionPerformed

    private void AddKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddKhachHangActionPerformed
        ThemKhachHang tkh = new ThemKhachHang();
        tkh.setVisible(true);

    }//GEN-LAST:event_AddKhachHangActionPerformed
    public model.HoaDon hoaDonCho = null;

    private void tblHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChoMouseClicked
        int index = tblHoaDonCho.getSelectedRow();
        String mahd = tblHoaDonCho.getModel().getValueAt(index, 0).toString();
        hoaDonCho = banHangServices.getObjHoaDonbyMa(mahd);
        fillTableGioHang(hoaDonCho.getListHDCT());
//
        String click = tblHoaDonCho.getModel().getValueAt(index, 0).toString();
        HoaDonChiTiet temp = banHangServices.getMaHD(click);
        lblMaHoaDon.setText(temp.getHoaDon().getMaHd());
        lblSoLuong.setText(String.valueOf(temp.getSoLuong()));
        lblTongTien.setText(String.valueOf(temp.getTongTien()));
        txtCheckSdtKhachHang.setText("0" + String.valueOf(temp.getHoaDon().getKhachHang().getSdt()));
        txtTenKhachHang.setText(temp.getHoaDon().getKhachHang().getTenKH());

        soDT = Integer.valueOf(txtCheckSdtKhachHang.getText());
    }//GEN-LAST:event_tblHoaDonChoMouseClicked
    public void tinhTienHd() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_GioHang.getModel();
        double moneyHoaDon = 0;
        int rowCount = dtm.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            double donGia = Double.parseDouble(tbl_GioHang.getModel().getValueAt(i, 2).toString());
            int sl = Integer.parseInt(tbl_GioHang.getModel().getValueAt(i, 3).toString());
            moneyHoaDon += donGia * sl;
        }
        lblTongTien.setText(String.format("%.1f", moneyHoaDon));
    }
    private void txtSearchTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchTenSPActionPerformed

    }//GEN-LAST:event_txtSearchTenSPActionPerformed

    private void txtSearchTenSPCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchTenSPCaretUpdate
        String searchTenSP = txtSearchTenSP.getText();
        List<ChiTietSanPham> listCTSP = banHangServices.searchByMa(searchTenSP);
        fillTableSanPham(listCTSP);
    }//GEN-LAST:event_txtSearchTenSPCaretUpdate

    private void cboSearhDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSearhDonGiaActionPerformed
        
    }//GEN-LAST:event_cboSearhDonGiaActionPerformed

    private void cboSearhKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSearhKieuDangActionPerformed
        
    }//GEN-LAST:event_cboSearhKieuDangActionPerformed

    private void cboSearhSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSearhSizeActionPerformed
        
    }//GEN-LAST:event_cboSearhSizeActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tbl_GioHang.getModel();
        
        lblMaHoaDon.setText("HD" + "");
        lblSoLuong.setText("");
        lblTienThua.setText("");
        lblTongTien.setText("");
        dtm.setRowCount(0);
        
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (txtCheckSdtKhachHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Thông Tin Khách Hàng Cần Cập Nhật");
            return;
        } else if (txtTenKhachHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Thông Tin Khách Hàng Cần Cập Nhật");
            return;
        } else {
            
            KhachHang kh = banHangServices.getIdKhachHangbySDT(soDT);
            String tenKHCu = kh.getTenKH();
            int soDTCu = kh.getSdt();
            kh.setSdt(Integer.valueOf(txtCheckSdtKhachHang.getText()));
            kh.setTenKH(txtTenKhachHang.getText());
            int submit = JOptionPane.showConfirmDialog(this, "Xác Nhận Cập Nhật Khách Hàng\n" + tenKHCu + "==>" + kh.getTenKH() + "\n"
                    + soDTCu + "==>" + kh.getSdt());
            if (submit == 0) {
                banHangServices.updateKhachHang(kh);
                JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
            } else {
                JOptionPane.showMessageDialog(this, "Cập Nhật Thất Bại");
            }

        }


    }//GEN-LAST:event_btnUpdateActionPerformed
    public int getIndex(ChiTietSanPham ctsp) {
        List<HoaDonChiTiet> list = hoaDonCho.getListHDCT();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getChiTietSanPham().getId().equals(ctsp.getId())) {
                return i;
            }
        }
        return -1;
    }

    public void updateSLCTSPKhiBan(ChiTietSanPham ctsp) {
        try {
            banHangServices.updateChiTietSP(ctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateKhachHang(KhachHang kh) {
        try {
            banHangServices.updateKhachHang(kh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveHDCT(HoaDonChiTiet hdct) {
        try {
            banHangServices.saveHoaDonCT(hdct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateHDct(HoaDonChiTiet hdct) {
        try {
            banHangServices.updateHoaDonCT(hdct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tbl_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseClicked
        int rowCL = tbl_sanpham.getSelectedRow();
        
//        lblAnh.setIcon(resizeImage(String.valueOf(ctsp.getHinhAnh())));
        
        String ma = tbl_sanpham.getModel().getValueAt(rowCL, 0).toString();
        ChiTietSanPham ctsp = banHangServices.getObjCTSPbyMa(ma);
        JOptionPane.showMessageDialog(this, ctsp + "-" + ma);
        double donGia = ctsp.getDonGia();
//        JOptionPane.showMessageDialog(this, donGia);

//        if (hoaDonCho == null) {
//            JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn");
//            return;
//        }
        String slText = JOptionPane.showInputDialog(this, "Nhập số lượng: ");
//
        if (slText != null) {
            int sl = Integer.parseInt(slText);
            if (sl > ctsp.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "So luong vuot qua");
                return;
            }
            HoaDonChiTiet hdct = new HoaDonChiTiet(null, hoaDonCho, ctsp, sl, 0, 1);

            if (hoaDonCho.getListHDCT() == null) {
                saveHDCT(hdct);
//                loadTableHoaDonCTfromDB(getListGioHangResByHoaDonCho());
                fillTableGioHang(hoaDonCho.getListHDCT());
                ctsp.setSoLuong(ctsp.getSoLuong() - sl);
                updateSLCTSPKhiBan(ctsp);
//                loadTableChiTietSP(getListChiTietSPRes());
                fillTableSanPham(banHangServices.getListChiTietSanPham());
            } else {
                //cehck trùng
                if (getIndex(ctsp) == -1) {
                    saveHDCT(hdct);
                    fillTableGioHang(hoaDonCho.getListHDCT());
                    ctsp.setSoLuong(ctsp.getSoLuong() - sl);
                    updateSLCTSPKhiBan(ctsp);
                    fillTableSanPham(banHangServices.getListChiTietSanPham());
                } else {
                    HoaDonChiTiet hdcttemp = hoaDonCho.getListHDCT().get(getIndex(ctsp));
                    hdcttemp.setSoLuong(hdcttemp.getSoLuong() + sl);
                    updateHDct(hdcttemp);
//                    loadTableHoaDonCTfromDB(getListGioHangResByHoaDonCho());
                    fillTableGioHang(hoaDonCho.getListHDCT());
                    ctsp.setSoLuong(ctsp.getSoLuong() - sl);
                    updateSLCTSPKhiBan(ctsp);
//                    loadTableChiTietSP(getListChiTietSPRes());
                    fillTableSanPham(banHangServices.getListChiTietSanPham());
                }
            }
        }

    }//GEN-LAST:event_tbl_sanphamMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int submit = JOptionPane.showConfirmDialog(this, "Bạn Muốn In Hóa Đơn");
        if (submit == 0) {
//            inHoaDon();
        } else {

        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int rowCL = tbl_sanpham.getSelectedRow();
        String ma = tbl_sanpham.getModel().getValueAt(rowCL, 0).toString();
        String id = banHangServices.getIdHDCT(ma);
        JOptionPane.showMessageDialog(this, id);
        try {
            banHangServices.deleteHoaDonCT(id);
            fillTableHoaDonCho(banHangServices.getListHoaDonChiTiet());
        } catch (Exception ex) {
            Logger.getLogger(GiaoDich.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        int tongTien = Integer.parseInt(lblTongTien.getText());
        int tienKhachDua = Integer.parseInt(txtTienKhachDua.getText());
        int tienThua = tienKhachDua - tongTien;
        lblTienThua.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        searchCBB();
    }//GEN-LAST:event_btnLocActionPerformed

    private void cboHinhThucThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThucThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboHinhThucThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddKhachHang;
    private javax.swing.JButton btnCheckKhachHang;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboHinhThucThanhToan;
    private javax.swing.JComboBox<String> cboSearhDonGia;
    private javax.swing.JComboBox<String> cboSearhKieuDang;
    private javax.swing.JComboBox<String> cboSearhSize;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpnBanhang;
    private javax.swing.JPanel lblAnh;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblHoaDonCho;
    private javax.swing.JTable tbl_GioHang;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txtCheckSdtKhachHang;
    private javax.swing.JTextField txtSearchTenSP;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
