/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.DeGiayJPN;



/**
 *
 * @author Phan Loc
 */
public interface DegiayService {
    String Add(DeGiayJPN dg);
    List<DeGiayJPN> getAll();
    String Update(DeGiayJPN dg, String id);
    String delete(String ma);
}
