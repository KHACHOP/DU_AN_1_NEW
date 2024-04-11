/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import service.khachHang_service;
import model.khachHang;
import connectionProvider.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class khachHangService_impl implements khachHang_service {

    private Connection conn = DBConnect.getConnection();

    @Override
    public void themKhachHang(khachHang kh) {
        try {
            String sql = "insert into khachHang(hoTen,gioiTinh,diaChi,soDienThoai) values(?,?,?,?)";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, kh.getTenKhachHang());
            prm.setString(2, String.valueOf(kh.getGioiTinh()));
            prm.setString(3, kh.getDiaChi());
            prm.setString(4, String.valueOf(kh.getSoDienThoai()));
            int inserted = prm.executeUpdate();
            if (inserted > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
            e.printStackTrace();
        }
    }

}
