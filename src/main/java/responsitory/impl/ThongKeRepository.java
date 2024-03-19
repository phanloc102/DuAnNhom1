/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ThongKeJPN;

/**
 *
 * @author Phan Loc
 */
public class ThongKeRepository {

    public List<ThongKeJPN> getAll() {
        String query = "SELECT SANPHAM.Masp, SANPHAM.Ten, CHITIETSANPHAM.Dongia, HOADONCHITIET.Soluong, Tongtien = Dongia * HOADONCHITIET.Soluong  FROM HOADONCHITIET \n"
                + "		INNER JOIN CHITIETSANPHAM ON HOADONCHITIET.Idctsp = CHITIETSANPHAM.id \n"
                + "		INNER JOIN SANPHAM ON SANPHAM.Id = CHITIETSANPHAM.Idsp";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKeJPN> listTt = new ArrayList<>();
            while (rs.next()) {
                listTt.add(new ThongKeJPN(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
            return listTt;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeJPN> tk(String ma) {
        String query = "SELECT SANPHAM.Masp, SANPHAM.Ten, CHITIETSANPHAM.Dongia, HOADONCHITIET.Soluong, Tongtien = Dongia * HOADONCHITIET.Soluong  FROM HOADONCHITIET \n"
                + "		INNER JOIN CHITIETSANPHAM ON HOADONCHITIET.Idctsp = CHITIETSANPHAM.id \n"
                + "		INNER JOIN SANPHAM ON SANPHAM.Id = CHITIETSANPHAM.Idsp  Where Masp like ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            List<ThongKeJPN> listTt = new ArrayList<>();
            while (rs.next()) {
                listTt.add(new ThongKeJPN(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
            return listTt;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeJPN> top() {
        String query = "SELECT TOP(5) SANPHAM.Masp, SANPHAM.Ten, CHITIETSANPHAM.Dongia, HOADONCHITIET.Soluong, Tongtien = Dongia * HOADONCHITIET.Soluong  FROM HOADONCHITIET \n"
                + "		INNER JOIN CHITIETSANPHAM ON HOADONCHITIET.Idctsp = CHITIETSANPHAM.id \n"
                + "		INNER JOIN SANPHAM ON SANPHAM.Id = CHITIETSANPHAM.Idsp order by Tongtien desc";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKeJPN> listTt = new ArrayList<>();
            while (rs.next()) {
                listTt.add(new ThongKeJPN(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
            return listTt;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
