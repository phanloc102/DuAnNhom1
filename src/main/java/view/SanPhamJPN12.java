/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.ChiTietSanPhamJPN;
//import sevice.ChiTietSanPhamServiceImpl;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.impl.ChiTietSanPhamServiceImpl;

/**
 *
 * @author Hoang
 */
public class SanPhamJPN12 extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private ChiTietSanPhamServiceImpl ctspsi = new ChiTietSanPhamServiceImpl();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private List<ChiTietSanPhamJPN> list = new ArrayList<>();
    private String strAnh = "C:\\Users\\Phan Loc\\Downloads\\PRO1041_DUAN1_BLOCK2 (1)\\src\\main\\resources\\Peace.PNG";

    /**
     * Creates new form SanPhamJPN
     */
    public SanPhamJPN12() {
        initComponents();
        dtm = (DefaultTableModel) tblSanPham.getModel();

        LoadCbbMS(ctspsi.getListMauSac());
        LoadCbbKD(ctspsi.getListKieuDang());
        LoadCbbS(ctspsi.getListSize());
        LoadCbbCC(ctspsi.getListChieuCao());
//        LoadCbbLocTT(ctspsi.getListTrangThai());
        LoadCbbLocKD(ctspsi.getListKieuDang());
        LoadCbbLocMS(ctspsi.getListMauSac());
        list = ctspsi.getAll();
        showData(list);

    }

    private void showData(List<ChiTietSanPhamJPN> list) {
        dtm.setRowCount(0);
        for (ChiTietSanPhamJPN ctsp : list) {
            dtm.addRow(ctsp.toDataRow());
        }
    }

    public void reset(){
        txtMa.setText("");
        txtGia.setText("");
        txtMota.setText("");
        txtSoLuong.setText("");
        cbbChieuCao.setSelectedIndex(0);
        cbbKieu.setSelectedIndex(0);
        cbbMau.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        txtTen.setText("");
        buttonGroup1.clearSelection();
        lblAnh.setText("HINH ANH");
        lblAnh.setIcon(null);
        list = ctspsi.getAll();
    }
    private void fillData(int index) {
        ChiTietSanPhamJPN ctsp = list.get(index);
        txtMa.setText(ctsp.getMa());
        txtGia.setText(ctsp.getDonGia() + "");
        txtSoLuong.setText(ctsp.getSoLuong() + "");
        txtMota.setText(ctsp.getMoTa());
        cbbChieuCao.setSelectedItem(ctsp.getDeGiay() + "");
        txtTen.setText(ctsp.getSanPham());
        cbbKieu.setSelectedItem(ctsp.getKieuDang());
        cbbMau.setSelectedItem(ctsp.getMauSac());
        cbbSize.setSelectedItem(ctsp.getSize() + "");
        lblAnh.setIcon(resizeImage(String.valueOf(ctsp.getHinhAnh())));
        int trangThai = ctsp.getTrangThai();
        if (trangThai == 0) {
            rdHet.setSelected(true);
        } else {
            rdCon.setSelected(true);
        }

    }

    public ImageIcon resizeImage(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    private void LoadCbbMS(List<String> list) {
        dcbm = (DefaultComboBoxModel) cbbMau.getModel();
        for (String string : list) {
            dcbm.addElement(string);
        }
    }

    private void LoadCbbKD(List<String> list) {
        dcbm = (DefaultComboBoxModel) cbbKieu.getModel();
        for (String string : list) {
            dcbm.addElement(string);
        }
    }

    private void LoadCbbS(List<String> list) {
        dcbm = (DefaultComboBoxModel) cbbSize.getModel();
        for (String string : list) {
            dcbm.addElement(string);
        }
    }

    private void LoadCbbCC(List<String> list) {
        dcbm = (DefaultComboBoxModel) cbbChieuCao.getModel();
        for (String string : list) {
            dcbm.addElement(string);
        }
    }

    private void LoadCbbLocTT(List<String> list) {
        dcbm = (DefaultComboBoxModel) cbbTt.getModel();
        for (String string : list) {
            dcbm.addElement(string);
        }
    }

    private void LoadCbbLocKD(List<String> list) {
        dcbm = (DefaultComboBoxModel) cbbKD.getModel();
        for (String string : list) {
            dcbm.addElement(string);
        }
    }

    private void LoadCbbLocMS(List<String> list) {
        dcbm = (DefaultComboBoxModel) cbbMS.getModel();
        for (String string : list) {
            dcbm.addElement(string);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btLamMoi = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btXuatExel = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        cbbMau = new javax.swing.JComboBox<>();
        cbbKieu = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbbChieuCao = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        rdCon = new javax.swing.JRadioButton();
        txtGia = new javax.swing.JTextField();
        rdHet = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        lblAnh = new javax.swing.JLabel();
        btChonAnh = new javax.swing.JButton();
        btAddMS = new javax.swing.JButton();
        btAddKD = new javax.swing.JButton();
        btAddSize = new javax.swing.JButton();
        btAddCC = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbbTt = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        txtTK = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btTK = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbbKD = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        cbbMS = new javax.swing.JComboBox<>();

        jLabel1.setText("THÔNG TIN SẢN PHẨM");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("TÊN SẢN PHẨM");

        jLabel4.setText("GIÁ");

        jLabel5.setText("SỐ LƯỢNG");

        btLamMoi.setBackground(new java.awt.Color(231, 154, 22));
        btLamMoi.setText("Làm mới ");
        btLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLamMoiActionPerformed(evt);
            }
        });

        btThem.setBackground(new java.awt.Color(231, 154, 22));
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(231, 154, 22));
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btXuatExel.setBackground(new java.awt.Color(231, 154, 22));
        btXuatExel.setText("Xuất Exel");
        btXuatExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXuatExelActionPerformed(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(231, 154, 22));
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btXuatExel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(btThem)
                .addGap(18, 18, 18)
                .addComponent(btSua)
                .addGap(27, 27, 27)
                .addComponent(btLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btXoa)
                .addGap(18, 18, 18)
                .addComponent(btXuatExel)
                .addGap(24, 24, 24))
        );

        jLabel9.setText("SIZE");

        jLabel10.setText("KIỂU");

        jLabel11.setText("MÀU SẮC");

        jLabel12.setText("MÔ TẢ");

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane2.setViewportView(txtMota);

        cbbMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauActionPerformed(evt);
            }
        });

        jLabel13.setText("TRẠNG THÁI");

        jLabel14.setText("CHIỀU CAO ĐẾ");

        jLabel15.setText("ẢNH SẢN PHẨM");

        buttonGroup1.add(rdCon);
        rdCon.setText("Còn Hàng");
        rdCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdConActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdHet);
        rdHet.setText("Hết Hàng");

        jLabel16.setText("Mã Sản Phẩm");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        lblAnh.setText("Photo");
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        btChonAnh.setBackground(new java.awt.Color(231, 154, 22));
        btChonAnh.setText("Chọn Ảnh");
        btChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChonAnhActionPerformed(evt);
            }
        });

        btAddMS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add.png"))); // NOI18N
        btAddMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddMSActionPerformed(evt);
            }
        });

        btAddKD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add.png"))); // NOI18N
        btAddKD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddKDActionPerformed(evt);
            }
        });

        btAddSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add.png"))); // NOI18N
        btAddSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddSizeActionPerformed(evt);
            }
        });

        btAddCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add.png"))); // NOI18N
        btAddCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddCCActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbChieuCao, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdCon)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbKieu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdHet)
                                .addGap(2, 2, 2))
                            .addComponent(btAddCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAddSize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAddKD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAddMS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(340, 340, 340)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 24, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btChonAnh))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton7)
                                    .addComponent(btAddKD)))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btAddMS)
                                .addComponent(jButton8))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbKieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btAddSize)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btAddCC, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(cbbChieuCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(25, 25, 25)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(rdCon)
                                .addComponent(rdHet)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Kiểu", "Size", "Màu Sắc", "Chiều Cao Đế", "Giá", "Số Lượng", "Mô Tả", "Trạng Thái"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jLabel6.setText("LỌC SẢN PHẨM");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Trạng Thái");

        cbbTt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        cbbTt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTt, 0, 123, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbTt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("Tìm kiếm sản phẩm");

        btTK.setBackground(new java.awt.Color(231, 154, 22));
        btTK.setText("Tìm");
        btTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btTK, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTK, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTK))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel17.setText("Kiểu Dáng");

        cbbKD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(cbbKD, 0, 123, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbKD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setText("Màu Sắc");

        cbbMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(cbbMS, 0, 103, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int row = tblSanPham.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void cbbMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauActionPerformed

    }//GEN-LAST:event_cbbMauActionPerformed

    private void cbbMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMSActionPerformed
        // TODO add your handling code here:
        String ten = cbbMS.getSelectedItem().toString();
        ctspsi.Loc(ten);
        list = ctspsi.Loc(ten);
        showData(list);
    }//GEN-LAST:event_cbbMSActionPerformed

    private void cbbKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKDActionPerformed
        // TODO add your handling code here:
        String ma = cbbKD.getSelectedItem().toString();
        ctspsi.Loc(ma);
        list = ctspsi.Loc(ma);
        showData(list);
    }//GEN-LAST:event_cbbKDActionPerformed

    private void cbbTtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTtActionPerformed
        // TODO add your handling code here:
        String trangThai = cbbTt.getSelectedItem().toString();

        ctspsi.Loc1(trangThai);
        list = ctspsi.Loc1(trangThai);
        showData(list);
    }//GEN-LAST:event_cbbTtActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void rdConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdConActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        String id = list.get(tblSanPham.getSelectedRow()).getId();
        String sanPham = txtTen.getText();
        String mauSac = (String) cbbMau.getSelectedItem();
        String kieuDang = (String) cbbKieu.getSelectedItem();
        String size = (String) cbbSize.getSelectedItem();
        String deGiay = (String) cbbChieuCao.getSelectedItem();
        String ma = txtMa.getText();
        String donGia = txtGia.getText();
        String soLuong = (String) txtSoLuong.getText();
        String moTa = txtMota.getText();
        String trangThai = "0";
        if (rdCon.isSelected()) {
            trangThai = "1";
        }
        ChiTietSanPhamJPN ctsp = new ChiTietSanPhamJPN(sanPham, mauSac, kieuDang, size, deGiay, ma, Integer.parseInt(donGia), Integer.parseInt(soLuong), moTa, Integer.parseInt(trangThai));
        ctsp.setHinhAnh(strAnh);
        JOptionPane.showMessageDialog(this, ctspsi.update(ctsp, id));
        list = ctspsi.getAll();
        showData(list);
        txtMa.setText("");
        txtGia.setText("");
        txtMota.setText("");
        txtSoLuong.setText("");
        cbbChieuCao.setSelectedIndex(0);
        cbbKieu.setSelectedIndex(0);
        cbbMau.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        txtTen.setText("");
        buttonGroup1.clearSelection();
        lblAnh.setText("HINH ANH");
        lblAnh.setIcon(null);
        reset();
    }//GEN-LAST:event_btSuaActionPerformed

    private void btLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtGia.setText("");
        txtMota.setText("");
        txtSoLuong.setText("");
        cbbChieuCao.setSelectedIndex(0);
        cbbKieu.setSelectedIndex(0);
        cbbMau.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        txtTen.setText("");
        buttonGroup1.clearSelection();
        lblAnh.setText("HINH ANH");
        lblAnh.setIcon(null);
        list = ctspsi.getAll();
        showData(list);

    }//GEN-LAST:event_btLamMoiActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        String id = list.get(tblSanPham.getSelectedRow()).getId();
        JOptionPane.showMessageDialog(this, ctspsi.delete(id));
        list = ctspsi.getAll();
        showData(list);
        txtMa.setText("");
        txtGia.setText("");
        txtMota.setText("");
        txtSoLuong.setText("");
        cbbChieuCao.setSelectedIndex(0);
        cbbKieu.setSelectedIndex(0);
        cbbMau.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        txtTen.setText("");
        buttonGroup1.clearSelection();
        reset();
    }//GEN-LAST:event_btXoaActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        String sanPham = txtTen.getText();
        String mauSac = (String) cbbMau.getSelectedItem();
        String kieuDang = (String) cbbKieu.getSelectedItem();
        String size = (String) cbbSize.getSelectedItem();
        String deGiay = (String) cbbChieuCao.getSelectedItem();
        String ma = txtMa.getText();
        String donGia = txtGia.getText();
        String soLuong = (String) txtSoLuong.getText();
        String moTa = txtMota.getText();
        String trangThai = "0";
        if (rdCon.isSelected()) {
            trangThai = "1";
        }

        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được bỏ trống");
        } else if (sanPham.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được bỏ trống");
        } else if (!sanPham.matches("[A-Z a-z]+")) {
            JOptionPane.showMessageDialog(this, "Tên phải là chữ");
        } else if (soLuong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số lượng không được bỏ trống");
        } else if (!soLuong.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số");
        } else if (donGia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Đơn giá không được bỏ trống");
        } else if (!donGia.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số");
        } else if (moTa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mô tả không được bỏ trống");
        } else {
            ChiTietSanPhamJPN ctsp = new ChiTietSanPhamJPN(sanPham, mauSac, kieuDang, size, deGiay, ma, Integer.parseInt(donGia), Integer.parseInt(soLuong), moTa, Integer.parseInt(trangThai));

            ctsp.setHinhAnh(strAnh);

            JOptionPane.showMessageDialog(this, ctspsi.add(ctsp));
            list = ctspsi.getAll();
            showData(list);
            reset();
        }

    }//GEN-LAST:event_btThemActionPerformed

    private void btXuatExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXuatExelActionPerformed
        // TODO add your handling code here:
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("dsNV");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(2);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SACH SAN PHAM");

            row = sheet.createRow(3);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Mã Sản Phẩm");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tên Sản Phẩm");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Kiểu Dáng");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Size");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Màu Sắc");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Chiều Cao Đế");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Giá");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Số Lượng");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Mô Tả");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Trạng Thái");

            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("Hình Ảnh");

            for (int i = 0; i < list.size(); i++) {
                //Modelbook book =arr.get(i);
                row = sheet.createRow(4 + i);

//                cell = row.createCell(0, CellType.NUMERIC);
//                cell.setCellValue(i + 1);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(list.get(i).getMa());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(list.get(i).getSanPham());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(list.get(i).getKieuDang());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(list.get(i).getSize());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(list.get(i).getMauSac());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(list.get(i).getDeGiay());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(list.get(i).getDonGia());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(list.get(i).getSoLuong());

                cell = row.createCell(8, CellType.ERROR);
                cell.setCellValue(list.get(i).getMoTa());

                cell = row.createCell(9, CellType.ERROR);
                cell.setCellValue(list.get(i).getTrangThai());

                cell = row.createCell(10, CellType.ERROR);
                cell.setCellValue(list.get(i).getHinhAnh());

            }

            File f = new File("D://danhsach.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                wordkbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "in thanh cong D:\\danhsach");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Loi mo file");
        }
    }//GEN-LAST:event_btXuatExelActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cbbMau.removeAllItems();
        LoadCbbMS(ctspsi.getListMauSac());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTKActionPerformed
        // TODO add your handling code here:
        String tk = txtTK.getText();
        ctspsi.TK(tk);
        list = ctspsi.TK(tk);
        showData(list);
    }//GEN-LAST:event_btTKActionPerformed

    private void btAddMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddMSActionPerformed
        // TODO add your handling code here:
        MauSac ms = new MauSac();
        ms.setVisible(true);
    }//GEN-LAST:event_btAddMSActionPerformed

    private void btAddKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddKDActionPerformed
        // TODO add your handling code here:
        KieuDang ms = new KieuDang();
        ms.setVisible(true);
    }//GEN-LAST:event_btAddKDActionPerformed

    private void btAddSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddSizeActionPerformed
        // TODO add your handling code here:
        Size ms = new Size();
        ms.setVisible(true);
    }//GEN-LAST:event_btAddSizeActionPerformed

    private void btAddCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddCCActionPerformed
        // TODO add your handling code here:
        DeGiay ms = new DeGiay();
        ms.setVisible(true);
    }//GEN-LAST:event_btAddCCActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cbbKieu.removeAllItems();
        LoadCbbKD(ctspsi.getListKieuDang());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cbbSize.removeAllItems();
        LoadCbbS(ctspsi.getListSize());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cbbChieuCao.removeAllItems();
        LoadCbbCC(ctspsi.getListChieuCao());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonAnhActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("C:\\Users\\Phan Loc\\Downloads\\PRO1041_DUAN1_BLOCK2 (1)\\src\\main\\resources");
            jfc.setDialogTitle("Chọn Ảnh :");
            jfc.showOpenDialog(null);
            File fl = jfc.getSelectedFile();
            strAnh = fl.getAbsolutePath();
            if (strAnh != null) {
                lblAnh.setIcon(resizeImage(strAnh));
            } else {
                JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Ảnh!"
                    + "Nếu Chưa Chọn Thì Hệ Thống Sẽ Chọn Ảnh Mặc Định");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Ảnh!"
                + "Nếu Chưa Chọn Thì Hệ Thống Sẽ Chọn Ảnh Mặc Định");
        }
    }//GEN-LAST:event_btChonAnhActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        //        try {
            //            // TODO add your handling code here:
            //            JFileChooser jfc = new JFileChooser("C:\\Users\\Phan Loc\\Downloads\\PRO1041_DUAN1_BLOCK2 (1)\\src\\main\\resources");
            //            jfc.showOpenDialog(null);
            //            File file = jfc.getSelectedFile();
            //            strAnh = file.getName();
            //            Image img = ImageIO.read(file);
            //            lblAnh.setText("");
            //            int width = lblAnh.getWidth();
            //            int height = lblAnh.getHeight();
            //            lblAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
            //        } catch (IOException ex) {
            //            System.out.println("Error: " + ex.toString());
            //        }
    }//GEN-LAST:event_lblAnhMouseClicked


   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddCC;
    private javax.swing.JButton btAddKD;
    private javax.swing.JButton btAddMS;
    private javax.swing.JButton btAddSize;
    private javax.swing.JButton btChonAnh;
    private javax.swing.JButton btLamMoi;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btTK;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btXuatExel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChieuCao;
    private javax.swing.JComboBox<String> cbbKD;
    private javax.swing.JComboBox<String> cbbKieu;
    private javax.swing.JComboBox<String> cbbMS;
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbTt;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JRadioButton rdCon;
    private javax.swing.JRadioButton rdHet;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
