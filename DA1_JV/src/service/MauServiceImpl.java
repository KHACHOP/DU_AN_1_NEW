/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import connectionProvider.DBConnect;
import connectionProvider.DBConnect;
import model.Mau;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sontr
 */
public class MauServiceImpl implements MauService {

    private Connection conn = DBConnect.getConnection();

    @Override
    public List<Mau> getMau() {
//        try {
//            List<Mau> list = new ArrayList<>();
//            Statement stm = conn.createStatement();
//            String sql = "select * from mau";
//            ResultSet rs = stm.executeQuery(sql);
//            while (rs.next()) {
//                int idMau = rs.getInt(1);
//                String tenMau = rs.getString(2);
//
//                Mau mau = new Mau();
//                mau.setIdMau(idMau);
//                mau.setTenMau(tenMau);
//                list.add(mau);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public boolean add(Mau mau) {
        try {
            String sql = "INSERT mau(tenMau) VALUES(?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, mau.getTenMau());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }
    
    
    
      @Override
    public boolean delete(int idMau) {
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM mau WHERE idMau = ?");
            stmt.setInt(1, idMau);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
