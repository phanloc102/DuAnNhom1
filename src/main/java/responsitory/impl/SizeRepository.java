/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
