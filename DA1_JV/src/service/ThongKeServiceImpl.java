package service;

import model.ThongKe;
import connectionProvider.DBConnect;
import model.banHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThongKeServiceImpl implements ThongKeService {

    private Connection conn = DBConnect.getConnection();

    @Override
    public List<ThongKe> getAll() {
        List<ThongKe> listTK = new ArrayList<>();
        try {

            String sql = "SELECT hd.id_hoaDon,hd.id_hoaDon,hd.id_sanPham,hd.soLuong,hd.donGia,hd.id_nhanVien,hd.trangThai,hd.ngayTao,sp.tenSanPham,sp.id_theLoai,\n"
                    + "               sp.id_chatLieu,\n"
                    + "              sp.id_thuongHieu,\n"
                    + "               sp.id_nhaCungCap,\n"
                    + "                sp.mau,\n"
                    + "              sp.size\n"
                    + "                 FROM \n"
                    + "               hoaDon hd\n"
                    + "            JOIN  SANPHAM sp ON hd.id_sanPham = sp.id_sanPham";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
//                int id_hoaDonCt = Integer.parseInt(rs.getString(1));
                int id_hoaDon = Integer.parseInt(rs.getString(2));
                int id_sanPham = Integer.parseInt(rs.getString(3));
                int soLuong = Integer.parseInt(rs.getString(4));
                double donGia = Double.parseDouble(rs.getString(5));
                int id_nhanVien = Integer.parseInt(rs.getString(6));
                int trangThai = Integer.parseInt(rs.getString(7));
                String ngayTao = rs.getString(8);
                String tenSP = rs.getString(9);
                int id_TheLoai = Integer.parseInt(rs.getString(10));
                int id_ChatLieu = Integer.parseInt(rs.getString(11));
                int id_ThuongHieu = Integer.parseInt(rs.getString(12));
                int id_NCC = Integer.parseInt(rs.getString(13));
//                int id_Mau = Integer.parseInt(rs.getString(14));
                int size = Integer.parseInt(rs.getString(15));
                ThongKe bh = new ThongKe();
//                bh.setId_hoaDonCt(id_hoaDonCt);
                bh.setId_hoaDon(id_hoaDon);
                bh.setId_sanPham(id_sanPham);
                bh.setSoLuong(soLuong);
                bh.setGia(donGia);
                bh.setId_nhanVien(id_nhanVien);
                bh.setTrangThai(trangThai);
                bh.setNgayTao(ngayTao);
                bh.setTenSP(tenSP);
                bh.setIdTL(id_TheLoai);
                bh.setIdCL(id_ChatLieu);
                bh.setIdTH(id_ThuongHieu);
                bh.setIdNCC(id_NCC);
//                bh.setIdMau(id_Mau);
                bh.setSize(size);
                listTK.add(bh);
            }
            return listTK;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Double tongThang() {
        Double tongThang = 0.0;
        String sql = "SELECT SUM(DONGIA) as dongia\n"
                + "FROM HOADON\n"
                + "WHERE MONTH(GETDATE()) = MONTH(ngayTao)";
        PreparedStatement ps;
        try {
            ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String dongia = rs.getString("dongia");
                if (dongia != null) {
                    tongThang = Double.parseDouble(dongia);
                } else {
                    tongThang = 0.0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongThang;
    }

    public Double tongNam() {
        Double tongNam = 0.0;
        String sql = "     SELECT SUM(donGia) as dongia\n"
                + "FROM HOADON\n"
                + "WHERE YEAR(GETDATE()) = YEAR(ngayTao)";
        PreparedStatement ps;
        try {
            ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String dongia = rs.getString("dongia");
                if (dongia != null) {
                    tongNam = Double.parseDouble(dongia);
                } else {
                    tongNam = 0.0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongNam;
    }

    public Double tongNgay() {
        Double tongNgay = 0.0;
        String sql = "   SELECT SUM(donGia) as dongia\n"
                + "FROM HOADON\n"
                + "WHERE CONVERT(date, GETDATE()) = CONVERT(date, ngayTao)";
        PreparedStatement ps;
        try {
            ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String dongia = rs.getString("dongia");
                if (dongia != null) {
                    tongNgay = Double.parseDouble(dongia);
                } else {
                    tongNgay = 0.0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongNgay;
    }

}
