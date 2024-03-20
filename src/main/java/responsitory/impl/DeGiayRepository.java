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

/**
 *
 * @author Phan Loc
 */
public class DeGiayRepository {

    public boolean Add(DeGiayJPN dg) {
        String query = "INSERT INTO [dbo].[DEGIAY]\n"
                + "           ([Made]\n"
                + "           ,[Chatlieude]\n"
                + "           ,[Docaode])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, dg.getMade());
            ps.setObject(2, dg.getChatLieu());
            ps.setObject(3, dg.getDoCao());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<DeGiayJPN> getAll() {
        String query = "SELECT[Made]\n"
                + "      ,[Chatlieude]\n"
                + "      ,[Docaode]\n"
                + "  FROM [dbo].[DEGIAY]";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<DeGiayJPN> list = new ArrayList<>();
            while (rs.next()) {
                DeGiayJPN dg = new DeGiayJPN(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(dg);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean Update(DeGiayJPN dg, String id) {
        String query = "UPDATE [dbo].[DEGIAY]\n"
                + "   SET [Made] = ?\n"
                + "      ,[Chatlieude] = ?\n"
                + "      ,[Docaode] = ?\n"
                + " WHERE [Id] = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, dg.getMade());
            ps.setObject(2, dg.getChatLieu());
            ps.setObject(3, dg.getDoCao());
            ps.setObject(3, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[DEGIAY]\n"
                + "      WHERE Made = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
}
