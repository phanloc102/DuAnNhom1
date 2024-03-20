/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DeGiayJPN;
import model.KieuDangJPN;

/**
 *
 * @author Phan Loc
 */
public class KieuDangRepository {

    public boolean Add(KieuDangJPN kd) {
        String query = "INSERT INTO [dbo].[KIEUDANG]\n"
                + "           ([Tenkieu]\n"
                + "           ,[Makieu])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kd.getMa());
            ps.setObject(2, kd.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<KieuDangJPN> getAll() {
        String query = "SELECT"
                + "[Tenkieu]\n"
                + "      ,[Makieu]\n"
                + "  FROM [dbo].[KIEUDANG]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<KieuDangJPN> list = new ArrayList<>();
            while (rs.next()) {
                KieuDangJPN dg = new KieuDangJPN(rs.getString(1), rs.getString(2));
                list.add(dg);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[KIEUDANG]\n"
                + "      WHERE Makieu = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
}
