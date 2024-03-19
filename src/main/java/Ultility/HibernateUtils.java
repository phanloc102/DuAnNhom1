/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
// */
//package Ultility;
//
//import java.util.Properties;
//import javax.imageio.spi.ServiceRegistry;
//import model.ChiTietSanPham;
//import model.DeGiay;
//import model.HoaDon;
//import model.HoaDonChiTiet;
//import model.KhachHang;
//import model.KieuDang;
//import model.MauSac;
//import model.SanPham;
//import model.sizeGiay;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Environment;
//
///**
// *
// * @author Hoang
// */
//public class HibernateUtils {
//
//    private final static SessionFactory FACTORY;
//
//    static {
//        Configuration conf = new Configuration();
//        Properties pros = new Properties();
//        pros.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
//        pros.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        pros.put(Environment.URL, "jdbc:sqlserver://localhost:1433;database = DUAN1");
//        pros.put(Environment.USER, "sa");
//        pros.put(Environment.PASS, "0866634564");
//
//        conf.addAnnotatedClass(SanPham.class);
//        conf.addAnnotatedClass(ChiTietSanPham.class);
//        conf.addAnnotatedClass(KieuDang.class);
//        conf.addAnnotatedClass(DeGiay.class);
//        conf.addAnnotatedClass(MauSac.class);
//        conf.addAnnotatedClass(sizeGiay.class);
//        conf.addAnnotatedClass(KhachHang.class);
//        conf.addAnnotatedClass(HoaDonChiTiet.class);
//        conf.addAnnotatedClass(HoaDon.class);
//        conf.setProperties(pros);
//        org.hibernate.service.ServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .applySettings(conf.getProperties()).build();
//
//        FACTORY = conf.buildSessionFactory(registry);
//    }
//
//    public static SessionFactory getSesionFactory() {
//        return FACTORY;
//    }
//
//    public static void main(String[] args) {
//
//        System.out.println(getSesionFactory());
//    }
//
//}
