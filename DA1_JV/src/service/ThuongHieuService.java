/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.ThuongHieu;
import java.util.List;

/**
 *
 * @author sontr
 */
public interface ThuongHieuService {
    List<ThuongHieu> getThuongHieu();
    public boolean add(ThuongHieu th);
}
