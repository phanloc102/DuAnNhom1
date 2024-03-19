/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
