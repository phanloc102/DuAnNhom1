/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Bean;
import controller.ChuyenManHinh;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang
 */
public class GiaoDienQuanLy extends javax.swing.JFrame {

    public GiaoDienQuanLy() {
        initComponents();

        setTitle("PHẦN MỀM QUẢN LÍ BÁN GIÀY SNEAKER");

        ChuyenManHinh controller = new ChuyenManHinh(jpnView);
//        controller.setName(jpnGiaoDich, jlbGiaodich);

        List<Bean> listItem = new ArrayList<>();
        listItem.add(new Bean("GiaoDich", jpnGiaoDich, jlbGiaodich));
        listItem.add(new Bean("NhanVien", jpnNhanVien, jlbNhanVien));
        listItem.add(new Bean("SanPham", jpnSanPham, jlbSanPham));
        listItem.add(new Bean("HoaDon", jpnHoaDon, jlbHoaDon));
        listItem.add(new Bean("DoiTra", jpnDoiTra, jlbDoiTra));
        listItem.add(new Bean("DoiMatKhau", jpnDoiMatKhau, jlbDoiMatKhau));
        listItem.add(new Bean("ThongKe", jpnThongKe, jlbThongKe));
        listItem.add(new Bean("DoiMatKhau", jpnDoiMatKhau, jlbDoiMatKhau));

        controller.setEven(listItem);
    }

//    public void mouseClick(int index){
//        ChiTietSanPham ctsp = listCTSP.get(index);
//        lbl_maSp.setText(ctsp.getSanPham().getMaSp());
//        lbl_tenSp.setText(ctsp.getSanPham().getTenSp());
//        lbl_chieuCaoDe.setText((ctsp.getDeGiay().getChieuCaoDe()));
////        lbl_size.setText(String.valueOf(ctsp.getSizeGiay().getTenSize()));
//        
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMain1111 = new javax.swing.JPanel();
        jpnGiaoDich = new javax.swing.JPanel();
        jlbGiaodich = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jlbNhanVien = new javax.swing.JLabel();
        jpnSanPham = new javax.swing.JPanel();
        jlbSanPham = new javax.swing.JLabel();
        jpnDoiTra = new javax.swing.JPanel();
        jlbDoiTra = new javax.swing.JLabel();
        jpnDoiMatKhau = new javax.swing.JPanel();
        jlbDoiMatKhau = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jpnThoat = new javax.swing.JPanel();
        btn_thoat = new javax.swing.JButton();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();
        jdeskTop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnMain1111.setBackground(new java.awt.Color(255, 255, 255));

        jpnGiaoDich.setBackground(new java.awt.Color(0, 153, 153));
        jpnGiaoDich.setForeground(new java.awt.Color(255, 255, 255));

        jlbGiaodich.setBackground(new java.awt.Color(0, 153, 153));
        jlbGiaodich.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbGiaodich.setForeground(null);
        jlbGiaodich.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbGiaodich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Billboard.png"))); // NOI18N
        jlbGiaodich.setText("GIAO DỊCH");

        javax.swing.GroupLayout jpnGiaoDichLayout = new javax.swing.GroupLayout(jpnGiaoDich);
        jpnGiaoDich.setLayout(jpnGiaoDichLayout);
        jpnGiaoDichLayout.setHorizontalGroup(
            jpnGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbGiaodich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnGiaoDichLayout.setVerticalGroup(
            jpnGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbGiaodich, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        jpnNhanVien.setBackground(new java.awt.Color(0, 153, 153));
        jpnNhanVien.setForeground(new java.awt.Color(255, 255, 255));

        jlbNhanVien.setBackground(new java.awt.Color(0, 153, 153));
        jlbNhanVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbNhanVien.setForeground(null);
        jlbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clien list.png"))); // NOI18N
        jlbNhanVien.setText("NHÂN VIÊN");
        jlbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbNhanVienMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnSanPham.setBackground(new java.awt.Color(0, 153, 153));
        jpnSanPham.setForeground(new java.awt.Color(255, 255, 255));

        jlbSanPham.setBackground(new java.awt.Color(0, 153, 153));
        jlbSanPham.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbSanPham.setForeground(null);
        jlbSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Label.png"))); // NOI18N
        jlbSanPham.setText("SẢN PHẨM");

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnDoiTra.setBackground(new java.awt.Color(0, 153, 153));
        jpnDoiTra.setForeground(new java.awt.Color(255, 255, 255));

        jlbDoiTra.setBackground(new java.awt.Color(0, 153, 153));
        jlbDoiTra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbDoiTra.setForeground(null);
        jlbDoiTra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDoiTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
        jlbDoiTra.setText("TRẢ HÀNG");

        javax.swing.GroupLayout jpnDoiTraLayout = new javax.swing.GroupLayout(jpnDoiTra);
        jpnDoiTra.setLayout(jpnDoiTraLayout);
        jpnDoiTraLayout.setHorizontalGroup(
            jpnDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDoiTraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDoiTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnDoiTraLayout.setVerticalGroup(
            jpnDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDoiTraLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jlbDoiTra, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnDoiMatKhau.setBackground(new java.awt.Color(0, 153, 153));
        jpnDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));

        jlbDoiMatKhau.setBackground(new java.awt.Color(0, 153, 153));
        jlbDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbDoiMatKhau.setForeground(null);
        jlbDoiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clipboard.png"))); // NOI18N
        jlbDoiMatKhau.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout jpnDoiMatKhauLayout = new javax.swing.GroupLayout(jpnDoiMatKhau);
        jpnDoiMatKhau.setLayout(jpnDoiMatKhauLayout);
        jpnDoiMatKhauLayout.setHorizontalGroup(
            jpnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDoiMatKhauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnDoiMatKhauLayout.setVerticalGroup(
            jpnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDoiMatKhauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnThongKe.setBackground(new java.awt.Color(0, 153, 153));
        jpnThongKe.setForeground(new java.awt.Color(255, 255, 255));

        jlbThongKe.setBackground(new java.awt.Color(0, 153, 153));
        jlbThongKe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbThongKe.setForeground(null);
        jlbThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Best.png"))); // NOI18N
        jlbThongKe.setText("THỐNG KÊ");

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        jpnThoat.setBackground(new java.awt.Color(0, 153, 153));

        btn_thoat.setBackground(new java.awt.Color(0, 153, 153));
        btn_thoat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_thoat.setForeground(new java.awt.Color(255, 255, 255));
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exit.png"))); // NOI18N
        btn_thoat.setText("THOÁT");
        btn_thoat.setBorder(null);
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnThoatLayout = new javax.swing.GroupLayout(jpnThoat);
        jpnThoat.setLayout(jpnThoatLayout);
        jpnThoatLayout.setHorizontalGroup(
            jpnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_thoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnThoatLayout.setVerticalGroup(
            jpnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_thoat, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        jpnHoaDon.setBackground(new java.awt.Color(0, 153, 153));
        jpnHoaDon.setForeground(new java.awt.Color(255, 255, 255));

        jlbHoaDon.setBackground(new java.awt.Color(0, 153, 153));
        jlbHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbHoaDon.setForeground(null);
        jlbHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/List.png"))); // NOI18N
        jlbHoaDon.setText("HÓA ĐƠN");

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z3859450958514_6178f0938865600b4ae719866ae35e65-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout jpnMain1111Layout = new javax.swing.GroupLayout(jpnMain1111);
        jpnMain1111.setLayout(jpnMain1111Layout);
        jpnMain1111Layout.setHorizontalGroup(
            jpnMain1111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnGiaoDich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnDoiTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMain1111Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jpnMain1111Layout.setVerticalGroup(
            jpnMain1111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMain1111Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("PHẦN MỀM BÁN GIÀY SNEAKER");

        jdeskTop.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jdeskTopLayout = new javax.swing.GroupLayout(jdeskTop);
        jdeskTop.setLayout(jdeskTopLayout);
        jdeskTopLayout.setHorizontalGroup(
            jdeskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1073, Short.MAX_VALUE)
        );
        jdeskTopLayout.setVerticalGroup(
            jdeskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addComponent(jdeskTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdeskTop))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnMain1111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMain1111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void jlbNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbNhanVienMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbNhanVienMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienQuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JDesktopPane jdeskTop;
    private javax.swing.JLabel jlbDoiMatKhau;
    private javax.swing.JLabel jlbDoiTra;
    private javax.swing.JLabel jlbGiaodich;
    private javax.swing.JLabel jlbHoaDon;
    private javax.swing.JLabel jlbNhanVien;
    private javax.swing.JLabel jlbSanPham;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JPanel jpnDoiMatKhau;
    private javax.swing.JPanel jpnDoiTra;
    private javax.swing.JPanel jpnGiaoDich;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnMain1111;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JPanel jpnThoat;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
