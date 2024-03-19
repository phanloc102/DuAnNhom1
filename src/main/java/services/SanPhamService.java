/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.SanPhamJPN;

/**
 *
 * @author Phan Loc
 */
public interface SanPhamService {

    public List<SanPhamJPN> getAll();

    public String add(SanPhamJPN sp);

    public String update(SanPhamJPN sp, String id);

    public String delete(String id);
}
