/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import connectionProvider.DBConnect;
import model.banHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class banHangService_IMPL implements banhangService {

    List<banHang> listGioHang = new ArrayList<>();

    public List<banHang> getListGioHang() {
        return listGioHang;
    }

    public List<banHang> getListGioHang(int idNv) {
        try {
            String sql = "select [id_hoaDon],sp.tenSanPham,h.soLuong,h.donGia,tl.tenTheLoai,cl.tenChatLieu,th.tenThuongHieu,ncc.tennhaCC,sp.mau,sp.size \n"
                    + "FROM [BanGiay_DA1].[dbo].[HOADON] h join NHANVIEN n on n.id_nhanVien = h.id_nhanvien join SANPHAM sp on h.id_sanPham = sp.id_sanPham"
                    + " join THELOAI tl on sp.id_theLoai = tl.id_theLoai join CHATLIEU cl on sp.id_chatLieu = cl.id_chatLieu "
                    + "join NHACUNGCAP ncc on sp.id_nhaCungCap = ncc.id_nhaCC join THUONGHIEU th on sp.id_thuongHieu = th.id_thuongHieu\n"
                    + "where h.id_nhanvien = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, idNv);
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
                listGioHang.add(new banHang(rs.getInt("id_hoaDon"), rs.getString("tenSanPham"), rs.getInt("soLuong"), rs.getDouble("donGia"),
                        rs.getString("tenTheLoai"), rs.getString("tenChatLieu"), rs.getString("tenThuongHieu"), rs.getString("tennhaCC"),
                        rs.getString("mau"), rs.getInt("size")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGioHang;
    }

    private Connection conn = DBConnect.getConnection();

    public List<banHang> getHoaDon() {
        List<banHang> listHd = new ArrayList<>();
        try {
            String sql = "select hd.id_hoaDon,nv.hoTen,hd.trangThai, hd.ngayTao from hoaDon hd\n"
                    + "join nhanVien nv on hd.id_nhanVien = nv.id_nhanVien";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id_hoaDon = Integer.parseInt(rs.getString(1));
                String tenNhanVien = rs.getString(2);
                int trangThai = Integer.parseInt(rs.getString(3));
                String ngayTao = rs.getString(4);

                banHang bh = new banHang();
                bh.setId_hoaDon(id_hoaDon);
                bh.setTenNhanVien(tenNhanVien);
                bh.setTrangThai(trangThai);
                bh.setNgayTao(ngayTao);
                listHd.add(bh);
            }
            return listHd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> fullGioHang() {
        List<banHang> listGH = new ArrayList<>();
        try {
            //Statement stm = conn.createStatement();
            String sql = "select hd.id_hoaDon,sp.tenSanPham,hd.soLuong,hd.donGia,tl.tenTheLoai,cl.tenChatLieu,th.tenThuongHieu,ncc.tennhaCC,sp.mau,sp.size\n"
                    + "from hoaDon hd\n"
                    + "join sanPham sp on sp.id_sanPham = hd.id_sanPham\n"
                    + "join theloai tl on sp.id_theLoai = tl.id_theLoai\n"
                    + "join chatLieu cl on sp.id_chatLieu = cl.id_chatLieu\n"
                    + "join thuongHieu th on sp.id_thuongHieu = th.id_thuongHieu\n"
                    + "join nhaCungCap ncc on sp.id_nhaCungCap = ncc.id_nhaCC\n";
            PreparedStatement prm = conn.prepareStatement(sql);
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
                int id_hoaDon = Integer.parseInt(rs.getString("id_hoaDon"));
                String tenSanpham = rs.getString("tenSanPham");
                int soLuong = Integer.parseInt(rs.getString("soLuong"));
                Double donGia = Double.parseDouble(rs.getString("donGia"));
                String theLoai = rs.getString("tenTheLoai");
                String chatLieu = rs.getString("tenChatLieu");
                String thuongHieu = rs.getString("tenThuongHieu");
                String nhaCungCap = rs.getString("tennhaCC");
                String mau = rs.getString("mau");
                int size = Integer.parseInt(rs.getString("size"));

                banHang bh = new banHang();
                bh.setId_hoaDon(id_hoaDon);
                bh.setTenSanPham(tenSanpham);
                bh.setSoLuong(soLuong);
                bh.setGiaSp(donGia);
                bh.setTenTheLoai(theLoai);
                bh.setTenChatLieu(chatLieu);
                bh.setTenThuongHieu(thuongHieu);
                bh.setTenNhaCungCap(nhaCungCap);
                bh.setTenMau(mau);
                bh.setSize(size);
                listGH.add(bh);
            }
            return listGH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getSanPham(String timKiem) {
        List<banHang> listSp = new ArrayList<>();
        try {
            String sql = "select id_sanPham,sp.tenSanPham,tl.tenTheLoai,cl.tenChatLieu,th.tenThuongHieu,ncc.tenNhaCungCap,m.tenMau, gia,size, soLuong, ct.ghiChu \n"
                    + "from sanPhamCt ct join sanPham sp on ct.id_sanPham = sp.id_sanPham \n"
                    + "join theloai tl on ct.id_theLoai = tl.id_theLoai \n"
                    + "join chatLieu cl on ct.id_chatLieu = cl.id_chatLieu\n"
                    + "join thuongHieu th on ct.id_thuongHieu = th.id_thuongHieu\n"
                    + "join nhaCungCap ncc on ct.id_nhaCungCap = ncc.id_nhaCungCap\n"
                    + "join mau m on ct.id_mau = m.id_mau where sp.tenSanPham like ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, "%" + timKiem + "%");
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
                int ma = Integer.parseInt(rs.getString(1));
                String tenSp = rs.getString(2);
                String theLoai = rs.getString(3);
                String chatLieu = rs.getString(4);
                String thuongHieu = rs.getString(5);
                String nhaCungCap = rs.getString(6);
                String mau = rs.getString(7);
                double giaSp = Double.parseDouble(rs.getString(8));
                int size = Integer.parseInt(rs.getString(9));
                int soLuong = Integer.parseInt(rs.getString(10));
                String ghiChu = rs.getString(11);

                banHang bh = new banHang();
                bh.setId_sanPhamCt(ma);
                bh.setTenSanPham(tenSp);
                bh.setTenTheLoai(theLoai);
                bh.setTenChatLieu(chatLieu);
                bh.setTenThuongHieu(thuongHieu);
                bh.setTenNhaCungCap(nhaCungCap);
                bh.setTenMau(mau);
                bh.setGiaSp(giaSp);
                bh.setSize(size);
                bh.setSoLuong(soLuong);
                bh.setGhiChu(ghiChu);
                listSp.add(bh);
            }
            return listSp;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sản phẩm không tồn tại");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void taoHoaDon(banHang bh) {
        try {
            String sql = "INSERT INTO hoaDon ( ngayTao,trangThai,id_khachHang,id_khuyenMai,id_nhanVien) \n"
                    + "SELECT  ?, ?, ? ,1,?\n"
                    + "FROM nhanVien nv join TAIKHOAN tk on nv.id_taiKhoan = tk.id_taiKhoan \n"
                    + "WHERE nv.id_nhanVien = ?";
            PreparedStatement prm = conn.prepareStatement(sql);

            prm.setString(1, bh.getNgayTao());
            prm.setString(2, String.valueOf(bh.getTrangThai()));
            prm.setString(3, String.valueOf(bh.getId_khachHang()));
            prm.setInt(4, bh.getId_nhanVien());
            prm.setInt(5, bh.getId_nhanVien());
            int inserted = prm.executeUpdate();
            if (inserted > 0) {
                JOptionPane.showMessageDialog(null, "Tạo thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Tạo thất bại");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tạo thất bại");
            e.printStackTrace();

        }
    }

    @Override
    public void themSanPham(banHang bh) {
        try {
            String sql = "INSERT INTO hoaDon(id_sanPham, soLuong, donGia,id_khachHang,trangThai,id_nhanVien,ngayTao) values(?,?,?,?,?,?,?)";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, String.valueOf(bh.getId_sanPham()));
            prm.setString(2, String.valueOf(bh.getSoLuongThem()));
            prm.setString(3, String.valueOf(bh.getGiaSp()));
            prm.setString(4, String.valueOf(bh.getId_khachHang()));
            prm.setInt(5, bh.getTrangThai());
            prm.setInt(6, bh.getId_nhanVien());
            prm.setString(7, bh.getNgayTao());
            prm.executeUpdate();

            JOptionPane.showMessageDialog(null, "thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaSoLuong(banHang bh) {
        try {
            String sql = "update sanPham set soLuong = ? - ? where id_sanPham = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, bh.getSoLuong());
            prm.setInt(2, bh.getSoLuongThem());
            prm.setInt(3, bh.getId_sanPham());
            prm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

      public List<banHang> getGioHang(String search,String trangThai) {
        List<banHang> listGH = new ArrayList<>();
        int tt;
        if(trangThai.equalsIgnoreCase("Đã thanh toán")) {
            tt=1;
        }else {
            tt=0;
        }
        try {
            String sql = " SELECT sp.tenSanPham, SUM(hd.soLuong) as soLuong, SUM(hd.soLuong * hd.donGia) as donGia, tl.tenTheLoai, cl.tenChatLieu, th.tenThuongHieu, ncc.tennhaCC, sp.mau, sp.size\n"
                    + "FROM hoaDon hd\n"
                    + "JOIN sanPham sp ON sp.id_sanPham = hd.id_sanPham\n"
                    + "JOIN theloai tl ON sp.id_theLoai = tl.id_theLoai\n"
                    + "JOIN chatLieu cl ON sp.id_chatLieu = cl.id_chatLieu\n"
                    + "JOIN thuongHieu th ON sp.id_thuongHieu = th.id_thuongHieu\n"
                    + "JOIN nhaCungCap ncc ON sp.id_nhaCungCap = ncc.id_nhaCC\n"
                    + "JOIN KHACHHANG kh ON kh.id_khachHang = hd.id_khachHang\n"
                    + "WHERE kh.id_khachHang = ?  AND hd.trangthai = ?\n"
                    + "GROUP BY sp.tenSanPham, tl.tenTheLoai, cl.tenChatLieu, th.tenThuongHieu, ncc.tennhaCC, sp.mau, sp.size";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, search);
            prm.setInt(2, tt);
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
//                int id_hoaDon = Integer.parseInt(rs.getString("id_hoaDon"));
                String tenSanpham = rs.getString("tenSanPham");
                int soLuong = Integer.parseInt(rs.getString("soLuong"));
                Double donGia = Double.parseDouble(rs.getString("donGia"));
                String theLoai = rs.getString("tenTheLoai");
                String chatLieu = rs.getString("tenChatLieu");
                String thuongHieu = rs.getString("tenThuongHieu");
                String nhaCungCap = rs.getString("tennhaCC");
                String mau = rs.getString("mau");
                int size = Integer.parseInt(rs.getString("size"));

                banHang bh = new banHang();
//                bh.setId_hoaDon(id_hoaDon);
                bh.setTenSanPham(tenSanpham);
                bh.setSoLuong(soLuong);
                bh.setGiaSp(donGia);
                bh.setTenTheLoai(theLoai);
                bh.setTenChatLieu(chatLieu);
                bh.setTenThuongHieu(thuongHieu);
                bh.setTenNhaCungCap(nhaCungCap);
                bh.setTenMau(mau);
                bh.setSize(size);
                listGH.add(bh);
            }
            return listGH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<banHang> getGioHang(String search) {
        List<banHang> listGH = new ArrayList<>();
        try {
            String sql = " SELECT sp.tenSanPham, SUM(hd.soLuong) as soLuong, SUM(hd.soLuong * hd.donGia) as donGia, tl.tenTheLoai, cl.tenChatLieu, th.tenThuongHieu, ncc.tennhaCC, sp.mau, sp.size\n"
                    + "FROM hoaDon hd\n"
                    + "JOIN sanPham sp ON sp.id_sanPham = hd.id_sanPham\n"
                    + "JOIN theloai tl ON sp.id_theLoai = tl.id_theLoai\n"
                    + "JOIN chatLieu cl ON sp.id_chatLieu = cl.id_chatLieu\n"
                    + "JOIN thuongHieu th ON sp.id_thuongHieu = th.id_thuongHieu\n"
                    + "JOIN nhaCungCap ncc ON sp.id_nhaCungCap = ncc.id_nhaCC\n"
                    + "JOIN KHACHHANG kh ON kh.id_khachHang = hd.id_khachHang\n"
                    + "WHERE kh.id_khachHang = ?  AND hd.trangthai = 0\n"
                    + "GROUP BY sp.tenSanPham, tl.tenTheLoai, cl.tenChatLieu, th.tenThuongHieu, ncc.tennhaCC, sp.mau, sp.size";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, search);
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
                String tenSanpham = rs.getString("tenSanPham");
                int soLuong = Integer.parseInt(rs.getString("soLuong"));
                Double donGia = Double.parseDouble(rs.getString("donGia"));
                String theLoai = rs.getString("tenTheLoai");
                String chatLieu = rs.getString("tenChatLieu");
                String thuongHieu = rs.getString("tenThuongHieu");
                String nhaCungCap = rs.getString("tennhaCC");
                String mau = rs.getString("mau");
                int size = Integer.parseInt(rs.getString("size"));

                banHang bh = new banHang();
                bh.setTenSanPham(tenSanpham);
                bh.setSoLuong(soLuong);
                bh.setGiaSp(donGia);
                bh.setTenTheLoai(theLoai);
                bh.setTenChatLieu(chatLieu);
                bh.setTenThuongHieu(thuongHieu);
                bh.setTenNhaCungCap(nhaCungCap);
                bh.setTenMau(mau);
                bh.setSize(size);
                listGH.add(bh);
            }
            return listGH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void themSoLuong(banHang bh) {
        try {
            String sql = "  update SANPHAM set soLuong = SANPHAM.soLuong+? where tenSanPham =?";
            PreparedStatement prm = conn.prepareStatement(sql);
            //prm.setInt(1, bh.getSoLuong());
            prm.setInt(1, bh.getSoLuongThem());
            prm.setString(2, bh.getTenSanPham());
            prm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void thanhToan(banHang bh) {
        try {
            String sql = "  UPDATE HOADON SET trangthai = 1 WHERE id_khachHang = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, bh.getId_khachHang());
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "thanh toán thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaGioHang(banHang b) {
        try {
            String sql1 = "  DELETE FROM hoaDon\n"
                    + "WHERE EXISTS (\n"
                    + "    SELECT 1 FROM SANPHAM sp \n"
                    + "    JOIN HOADON hd ON hd.id_sanPham = sp.id_sanPham\n"
                    + "    JOIN KHACHHANG kh ON kh.id_khachHang = hd.id_khachHang \n"
                    + "    WHERE sp.tenSanPham = ? AND kh.hoTen = ?\n"
                    + "    AND hoaDon.id_sanPham = hd.id_sanPham AND hoaDon.id_khachHang = hd.id_khachHang\n"
                    + ")";
            PreparedStatement prm1 = conn.prepareStatement(sql1);
            prm1.setString(1, b.getTenSanPham());
            prm1.setString(2, b.getTenKhachHang());
            prm1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<banHang> getTheLoai() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select tenTheLoai from theloai";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenTheLoai(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getChatLieu() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select tenChatLieu from chatLieu";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenChatLieu(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getThuongHieu() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select tenThuongHieu from thuongHieu";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenThuongHieu(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getNhaCungCap() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select tenNhaCc from NHACUNGCAP";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenNhaCungCap(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getMau() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select Mau from SanPham";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenMau(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateGioHang(banHang bh) {
        try {
            String sql = "update hoaDonCT set soLuong = ? + ? where id_hoaDonCt = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, bh.getSoLuongGh());
            prm.setInt(2, bh.getSoLuongThemGh());
            prm.setInt(3, bh.getId_hoaDonCt());
            prm.executeUpdate();
            System.out.println(prm + "+");
            JOptionPane.showMessageDialog(null, "thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "thêm thất bại");
            e.printStackTrace();

        }
    }

    @Override
    public void updateSpct(banHang bh) {
        try {
            String sql = "update sanPhamCt set soLuong = ? - ? where id_hoaDonCt = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, bh.getSoLuong());
            prm.setInt(2, bh.getSoLuongThem());
            prm.setInt(3, bh.getId_sanPhamCt());
            prm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
