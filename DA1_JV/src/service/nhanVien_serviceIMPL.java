/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.nhanVien;
import connectionProvider.DBConnect;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class nhanVien_serviceIMPL implements nhanVien_service {

    private Connection conn = DBConnect.getConnection();

    public List<nhanVien> getNhanVien(String search) {
        List<nhanVien> listNv = new ArrayList<>();
        try {
            String sql = "select id_nhanVien, hoTen, gioiTinh,soDt,diaChi,id_taiKhoan,trangThai from nhanVien where hoTen like ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, "%" + search + "%");
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
                int idNhanVien = Integer.parseInt(rs.getString(1));
                String hoTen = rs.getString(2);
                int gioiTinh = Integer.parseInt(rs.getString(3));
                int soDienthoai = Integer.parseInt(rs.getString(4));
                String diaChi = rs.getString(5);
                int idTaiKhoan = Integer.parseInt(rs.getString(6));
                int trangThai = Integer.parseInt(rs.getString(7));
                nhanVien nv = new nhanVien();
                nv.setId_nhanVien(idNhanVien);
                nv.setTenNhanVien(hoTen);
                nv.setGioiTinh(gioiTinh);
                nv.setSoDienThoai(soDienthoai);
                nv.setDiaChi(diaChi);
                nv.setTaiKhoan(idTaiKhoan);
                nv.setTrangThai(trangThai);
                listNv.add(nv);
            }
            return listNv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void themNhanVien(nhanVien nv) {
        try {
            String sql = "insert into nhanVien(hoTen, gioiTinh,soDt,diaChi,id_taiKhoan,trangThai) values(?,?,?,?,?,?)";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, nv.getTenNhanVien());
            prm.setString(2, String.valueOf(nv.getGioiTinh()));
            prm.setString(3, String.valueOf(nv.getSoDienThoai()));
            prm.setString(4, nv.getDiaChi());
            prm.setString(5, String.valueOf(nv.getTaiKhoan()));
            prm.setString(6, String.valueOf(nv.getTrangThai()));
            int inserted = prm.executeUpdate();
            if (inserted > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không có id tài khoản như vậy");
//            e.printStackTrace();
        }

    }

    @Override
    public void suaNhanVien(nhanVien nv) {
        try {
            String sql = "update nhanVien "
                    + "set  hoTen = ?, gioiTinh = ?,soDt= ?,diaChi=?,id_taiKhoan = ?,trangThai= ?  "
                    + "where id_nhanVien = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, nv.getTenNhanVien());
            prm.setString(2, String.valueOf(nv.getGioiTinh()));
            prm.setString(3, String.valueOf(nv.getSoDienThoai()));
            prm.setString(4, nv.getDiaChi());
            prm.setString(5, String.valueOf(nv.getTaiKhoan()));
            prm.setInt(6, nv.getTrangThai());
            prm.setString(7, String.valueOf(nv.getId_nhanVien()));
            int inserted = prm.executeUpdate();
            if (inserted > 0) {
                JOptionPane.showMessageDialog(null, "Sửa thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
//            e.printStackTrace();
        }
    }

    public void xoa(int id) {
        try {
            String sql = "delete from nhanVien where id_nhanVien = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, id);
            int deleted = prm.executeUpdate();
            if (deleted > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
            e.printStackTrace();
        }
    }

}
