/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.Mau;
import java.util.List;

/**
 *
 * @author sontr
 */
public interface MauService {
     List<Mau> getMau();

     boolean add(Mau mau);
    boolean delete(int idMau);
}
