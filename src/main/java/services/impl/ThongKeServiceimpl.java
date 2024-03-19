/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import model.ThongKeJPN;
import responsitory.impl.ThongKeRepository;
import services.ThongKeService;

/**
 *
 * @author Phan Loc
 */
public class ThongKeServiceimpl implements ThongKeService{
    
        private ThongKeRepository tkr = new ThongKeRepository();
    @Override
    public List<ThongKeJPN> getAll() {
        return tkr.getAll();
    }

    @Override
    public List<ThongKeJPN> tk(String ma) {
        return tkr.tk(ma);
    }

    @Override
    public List<ThongKeJPN> top() {
        return tkr.top();
    }
    
}
