/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Bean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.DoiMatKhau;
import view.DoiTra;
import view.GiaoDich;
import view.HoaDon;
import view.SPNhanVien;
import view.SanPhamJPN12;
import view.ThongKe;
import view.ViewNhanVien;

/**
 *
 * @author Hoang
 */
public class ChuyenManHinh {
    private JPanel root;
    private String kinSelected = "";

    private List<Bean> listItem = null;

    public ChuyenManHinh(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setName(JPanel jpnItem, JLabel jlbItem) {
        kinSelected = "BanHang";

        jpnItem.setBackground(new Color(231, 154, 22));
        jlbItem.setBackground(new Color(231, 154, 22));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new GiaoDich());
        root.validate();
        root.repaint();
    }

    public void setEven(List<Bean> listItem){
        this.listItem = listItem;
        for(Bean b : listItem){
            b.getJlb().addMouseListener(new LabelEvent(b.getKind(), b.getJpn(), b.getJlb()));
        }
    }
    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "GiaoDich":
                    node = new GiaoDich();
                    break;
                case "NhanVien":
                    node = new ViewNhanVien();
                    break;
                case "SanPham":
                    node = new SanPhamJPN12();
                    break;
                case "HoaDon":
                    node = new HoaDon();
                    break;
                case "DoiTra":
                    node = new DoiTra();
                    break;
                case "DoiMatKhau":
                    node = new DoiMatKhau();
                    break;
                case "ThongKe":
                    node = new  ThongKe();
                    break;
                case "SanPhamNhanVien":
                    node = new SPNhanVien();
                    break;
                default:
                    node = new GiaoDich();
                    break;

            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            kinSelected = kind;
            jpnItem.setBackground(new Color(249, 167, 27));
            jlbItem.setBackground(new Color(249, 167, 27));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(249,167,27));
            jlbItem.setBackground(new Color(249,167,27));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kinSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(231, 154, 22));
                jlbItem.setBackground(new Color(231, 154, 22));
            }
        }

        
        private void setChangeBackgroud(String kind) {
            for (Bean item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    jpnItem.setBackground(new Color(249, 167, 27));
                    jlbItem.setBackground(new Color(249, 167, 27));
                } else {
                    item.getJlb().setBackground(new Color(231, 154, 22));
                    item.getJpn().setBackground(new Color(231, 154, 22));
                }
            }
        }
    }
}
