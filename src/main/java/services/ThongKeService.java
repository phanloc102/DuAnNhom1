/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.ThongKeJPN;

/**
 *
 * @author Phan Loc
 */
public interface ThongKeService {
   public List<ThongKeJPN> getAll();
   public List<ThongKeJPN> top();
   public List<ThongKeJPN> tk(String ma);
}
