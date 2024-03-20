/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.MauSacJPN;
import model.SizeJPN;



/**
 *
 * @author Phan Loc
 */
public interface MauSacService  {
    String Add(MauSacJPN ms);
    List<MauSacJPN> getAll();
    String delete(String ma);
}
