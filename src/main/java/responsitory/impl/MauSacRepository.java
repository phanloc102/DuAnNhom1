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
import model.KieuDangJPN;
import model.MauSacJPN;

/**
 *
 * @author Phan Loc
 */
public class MauSacRepository {

    public boolean Add(MauSacJPN ms) {
        String query = "INSERT INTO [dbo].[MAUSAC]\n"
                + "           ([Tenmau]\n"
                + "           ,[Mamau])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<MauSacJPN> getAll() {
        String query = "SELECT "
                + "[Tenmau]\n"
                + "      ,[Mamau]\n"
                + "  FROM [dbo].[MAUSAC]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<MauSacJPN> list = new ArrayList<>();
            while (rs.next()) {
                MauSacJPN dg = new MauSacJPN(rs.getString(1), rs.getString(2));
                list.add(dg);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[MAUSAC]\n"
                + "      WHERE Mamau = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
}
