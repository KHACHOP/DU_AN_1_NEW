/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author MSI
 */
import model.khuyenMai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class khuyenMaiServiceIMPL implements khuyenMaiService {

    private Connection conn = connectionProvider.DBConnect.getConnection();

    public List<khuyenMai> getAll(String search) {
        List<khuyenMai> listKm = new ArrayList<>();
        ResultSet rs = null;
        try {

            if (search.equals("") || search.equals("tất cả") || search.equals("1-9")) {
                String sql = "select  id_khuyenMai,tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai from khuyenMai";
                Statement stm = conn.createStatement();
                rs = stm.executeQuery(sql);
            } else if (search.equals("1") || search.equals("0")) {
                String sql = "select id_khuyenMai,tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai from khuyenMai where trangThai like ?";
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, search);
                rs = prm.executeQuery();
            } else if (search.equals("VNĐ")) {
                String sql = "select id_khuyenMai,tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai from khuyenMai where loai like ?";
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, search);
                rs = prm.executeQuery();
            } else if (search.equals("%")) {
                String sql = "select id_khuyenMai,tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai from khuyenMai where loai like ?";
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, "[" + search + "]");
                rs = prm.executeQuery();
            } else {
                String sql = "select id_khuyenMai,tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai from khuyenMai where tenKhuyenMai like ?";
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, "%" + search + "%");
                rs = prm.executeQuery();
            }
            while (rs.next()) {
                int ma = Integer.parseInt(rs.getString(1));
                String tenKm = rs.getString(2);
                String loai = rs.getString(3);
                String giaTri = rs.getString(4);
                String ngayBatDau = rs.getString(5);
                String ngayKetThuc = rs.getString(6);
                int trangThai = Integer.parseInt(rs.getString(7));

                khuyenMai km = new khuyenMai();
                km.setId_khuyenMai(ma);
                km.setTenKhuyenMai(tenKm);
                km.setLoai(loai);
                km.setGiaTri(giaTri);
                km.setNgayBatDau(ngayBatDau);
                km.setNgayKetThuc(ngayKetThuc);
                km.setTrangThai(trangThai);
                listKm.add(km);
            }
            return listKm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void themKhuyenMai(khuyenMai kh) {
        try {
            String sql = "insert into khuyenMai(tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai) values(?,?,?,?,?,?)";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, kh.getTenKhuyenMai());
            prm.setString(2, kh.getLoai());
            prm.setString(3, String.valueOf(kh.getGiaTri()));
            prm.setString(4, kh.getNgayBatDau());
            prm.setString(5, kh.getNgayKetThuc());
            prm.setString(6, String.valueOf(kh.getTrangThai()));
            prm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaKhuyenMai(khuyenMai kh) {
        try {
            String sql = "update khuyenMai set tenKhuyenMai = ?,loai = ?,giaTri = ?,ngayBatDau = ?,ngayKetThuc = ?,trangThai = ?  where id_khuyenMai = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, kh.getTenKhuyenMai());
            prm.setString(2, kh.getLoai());
            prm.setString(3, String.valueOf(kh.getGiaTri()));
            prm.setString(4, kh.getNgayBatDau());
            prm.setString(5, kh.getNgayKetThuc());
            prm.setString(6, String.valueOf(kh.getTrangThai()));
            prm.setString(7, String.valueOf(kh.getId_khuyenMai()));
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sửa thất bại");
            e.printStackTrace();
        }
    }

//    @Override
//    public void xoaKhuyenMai(khuyenMai kh) {
//        try {
//            String sql = "delete from khuyenMai where id_khuyenMai = ? ";
//            PreparedStatement prm = conn.prepareStatement(sql);
//            prm.setString(1, String.valueOf(kh.getId_khuyenMai()));
//            prm.executeUpdate();
//            JOptionPane.showMessageDialog(null, "xóa thành công");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "xóa thất bại");
//        }
//    }

    @Override
    public void xoaKhuyenMai(khuyenMai kh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
