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
public class GiaoDienNhanVien1 extends javax.swing.JFrame {

    /**
     * Creates new form GiaoDienNhanVien1
     */
    public GiaoDienNhanVien1() {
        initComponents();
        setTitle("PHẦN MỀM QUẢN LÍ BÁN GIÀY SNEAKER");
        ChuyenManHinh controller = new ChuyenManHinh(jpnView);
        List<Bean> listItem = new ArrayList<>();
        listItem.add(new Bean("GiaoDich", jpnGiaoDich, jlbGiaodich));
        listItem.add(new Bean("SanPhamNhanVien", jpnSanPham, jlbSanPham));
        listItem.add(new Bean("DoiTra", jpnDoiTra, jlbDoiTra));
        
        controller.setEven(listItem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jpnMain1111 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnGiaoDich = new javax.swing.JPanel();
        jlbGiaodich = new javax.swing.JLabel();
        jpnSanPham = new javax.swing.JPanel();
        jlbSanPham = new javax.swing.JLabel();
        jpnDoiTra = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jlbDoiTra = new javax.swing.JLabel();
        jpnThoat = new javax.swing.JPanel();
        btn_thoat = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("PHẦN MỀM BÁN GIÀY SNEAKER");

        jpnMain1111.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z3859450958514_6178f0938865600b4ae719866ae35e65-removebg-preview.png"))); // NOI18N

        jpnGiaoDich.setBackground(new java.awt.Color(0, 153, 153));
        jpnGiaoDich.setForeground(new java.awt.Color(255, 255, 255));

        jlbGiaodich.setBackground(java.awt.Color.blue);
        jlbGiaodich.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbGiaodich.setForeground(new java.awt.Color(255, 255, 255));
        jlbGiaodich.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbGiaodich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Billboard.png"))); // NOI18N
        jlbGiaodich.setText("GIAO DỊCH");

        javax.swing.GroupLayout jpnGiaoDichLayout = new javax.swing.GroupLayout(jpnGiaoDich);
        jpnGiaoDich.setLayout(jpnGiaoDichLayout);
        jpnGiaoDichLayout.setHorizontalGroup(
            jpnGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbGiaodich, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpnGiaoDichLayout.setVerticalGroup(
            jpnGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbGiaodich, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );

        jpnSanPham.setBackground(new java.awt.Color(0, 153, 153));
        jpnSanPham.setForeground(new java.awt.Color(255, 255, 255));

        jlbSanPham.setBackground(java.awt.Color.blue);
        jlbSanPham.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbSanPham.setForeground(new java.awt.Color(255, 255, 255));
        jlbSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Label.png"))); // NOI18N
        jlbSanPham.setText("SẢN PHẨM");

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
        );

        jpnDoiTra.setBackground(new java.awt.Color(0, 153, 153));
        jpnDoiTra.setForeground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setBackground(java.awt.Color.blue);

        jlbDoiTra.setBackground(new java.awt.Color(0, 153, 153));
        jlbDoiTra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbDoiTra.setForeground(new java.awt.Color(255, 255, 255));
        jlbDoiTra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDoiTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
        jlbDoiTra.setText("ĐỔI TRẢ");
        jlbDoiTra.setAutoscrolls(true);
        jlbDoiTra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlbDoiTra.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jlbDoiTra.setFocusable(false);
        jlbDoiTra.setInheritsPopupMenu(false);
        jlbDoiTra.setRequestFocusEnabled(false);
        jlbDoiTra.setVerifyInputWhenFocusTarget(false);

        jLayeredPane1.setLayer(jlbDoiTra, javax.swing.JLayeredPane.POPUP_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbDoiTra, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jlbDoiTra.getAccessibleContext().setAccessibleDescription("");
        jlbDoiTra.getAccessibleContext().setAccessibleParent(jlbDoiTra);

        javax.swing.GroupLayout jpnDoiTraLayout = new javax.swing.GroupLayout(jpnDoiTra);
        jpnDoiTra.setLayout(jpnDoiTraLayout);
        jpnDoiTraLayout.setHorizontalGroup(
            jpnDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jpnDoiTraLayout.setVerticalGroup(
            jpnDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jpnThoat.setBackground(new java.awt.Color(0, 153, 153));

        btn_thoat.setBackground(new java.awt.Color(0, 153, 153));
        btn_thoat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_thoat.setForeground(new java.awt.Color(255, 255, 255));
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exit.png"))); // NOI18N
        btn_thoat.setText("THOÁT");
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
            .addComponent(btn_thoat, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnMain1111Layout = new javax.swing.GroupLayout(jpnMain1111);
        jpnMain1111.setLayout(jpnMain1111Layout);
        jpnMain1111Layout.setHorizontalGroup(
            jpnMain1111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnGiaoDich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnDoiTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMain1111Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnMain1111Layout.setVerticalGroup(
            jpnMain1111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMain1111Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jpnGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jpnDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jpnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnMain1111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpnMain1111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_thoatActionPerformed

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
            java.util.logging.Logger.getLogger(GiaoDienNhanVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienNhanVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienNhanVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienNhanVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienNhanVien1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel jlbDoiTra;
    private javax.swing.JLabel jlbGiaodich;
    private javax.swing.JLabel jlbSanPham;
    private javax.swing.JPanel jpnDoiTra;
    private javax.swing.JPanel jpnGiaoDich;
    private javax.swing.JPanel jpnMain1111;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JPanel jpnThoat;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
