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
import model.MauSacJPN;
import model.SizeJPN;

/**
 *
 * @author Phan Loc
 */
public class SizeRepository {

    public boolean Add(SizeJPN s) {
        String query = "INSERT INTO [dbo].[SIZE]\n"
                + "           ([Tensize]\n"
                + "           ,[Masize])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, s.getTen());
            ps.setObject(2, s.getMa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<SizeJPN> getAll() {
        String query = "SELECT [Tensize]\n"
                + "      ,[Masize]\n"
                + "  FROM [dbo].[SIZE]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SizeJPN> list = new ArrayList<>();
            while (rs.next()) {
                SizeJPN dg = new SizeJPN(rs.getInt(1), rs.getString(2));
                list.add(dg);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[SIZE]\n"
                + "      WHERE Masize = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
}
