/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.NhaCungCap;
import java.util.List;

/**
 *
 * @author sontr
 */
public interface NhaCCService {

    List<NhaCungCap> getNCC();

    public boolean add(NhaCungCap ncc);
}
