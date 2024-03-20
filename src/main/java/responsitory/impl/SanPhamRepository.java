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
import model.SanPhamJPN;

/**
 *
 * @author Phan Loc
 */
public class SanPhamRepository {

    public List<SanPhamJPN> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Masp]\n"
                + "      ,[Ten]\n"
                + "  FROM [dbo].[SANPHAM]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamJPN> listSp = new ArrayList<>();
            while (rs.next()) {
                listSp.add(new SanPhamJPN(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(SanPhamJPN sp) {
        String query = "INSERT INTO [dbo].[SANPHAM]\n"
                + "           ([Masp]\n"
                + "           ,[Ten])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(SanPhamJPN sp, String id) {
        String query = "UPDATE [dbo].[SANPHAM]\n"
                + "   SET \n"
                + "       [Masp] = ?\n"
                + "      ,[Ten] = ?\n"
                + " WHERE Id like ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());

            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[SANPHAM]\n"
                + "      WHERE Id like ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
