/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
