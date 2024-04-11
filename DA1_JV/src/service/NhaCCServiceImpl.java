/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import connectionProvider.DBConnect;
import model.NhaCungCap;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author sontr
 */
public class NhaCCServiceImpl implements NhaCCService {

    private Connection conn = DBConnect.getConnection();

    @Override
    public List<NhaCungCap> getNCC() {
        try {
            List<NhaCungCap> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "select DISTINCT * from nhaCungCap";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idNCC = rs.getInt(1);
                String tenNCC = rs.getString(2);

                NhaCungCap th = new NhaCungCap();
                th.setIdNhaCungCap(idNCC);
                th.setTenNhaCungCap(tenNCC);
                list.add(th);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(NhaCungCap ncc) {
        try {
            String sql = "INSERT nhaCungCap(tenNhaCungCap) VALUES(?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, ncc.getTenNhaCungCap());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }

}
