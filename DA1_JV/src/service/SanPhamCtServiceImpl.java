package service;

import connectionProvider.DBConnect;
import service.SanPhamCt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SanPhamCtServiceImpl implements SanPhamCtService {

    private Connection conn = DBConnect.getConnection();

    @Override
    public List<SanPhamCt> getAll() {
        try {
            List<SanPhamCt> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "SELECT top 5\n"
                    + "    id_sanPham,\n"
                    + "    tenSanPham,  \n"
                    + "    tl.tenTheLoai,\n"
                    + "    cl.tenChatLieu,\n"
                    + "    th.tenThuongHieu,\n"
                    + "    ncc.tennhaCC,\n"
                    + "    sanPham.mau,\n"
                    + "    sanPham.gia,\n"
                    + "    sanPham.size,\n"
                    + "    sanPham.soLuong,\n"
                    + "    sanPham.ghiChu\n"
                    + "FROM\n"
                    + "   sanPham\n"
                    + "JOIN\n"
                    + "    theloai tl ON sanPham.id_theLoai = tl.id_theLoai\n"
                    + "JOIN\n"
                    + "      chatLieu cl ON sanPham.id_chatLieu = cl.id_chatLieu\n"
                    + "JOIN\n"
                    + "      thuongHieu th ON sanPham.id_thuongHieu = th.id_thuongHieu\n"
                    + "JOIN\n"
                    + "     nhaCungCap ncc ON sanPham.id_nhaCungCap = ncc.id_nhaCC\n";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
              
                String tenSP = rs.getString("tenSanPham");
                String theLoai = rs.getString("tenTheLoai");
                String chatLieu = rs.getString("tenChatLieu");
                String thuongHieu = rs.getString("tenThuongHieu");
                String nhaCungCap = rs.getString("tennhaCC");
                String mau = rs.getString("mau");
                double gia = rs.getDouble("gia");
                int size = rs.getInt("size");
                int soLuong = rs.getInt("soLuong");
                String ghiChu = rs.getString("ghiChu");

                SanPhamCt sp = new SanPhamCt();
              
                sp.setTenSP(tenSP);
                sp.setTenTheLoai(theLoai);
                sp.setTenChatLieu(chatLieu);
                sp.setTenThuongHieu(thuongHieu);
                sp.setTenNhaCungCap(nhaCungCap);
                sp.setTenMau(mau);
                sp.setGia(gia);
                sp.setSize(size);
                sp.setSoLuong(soLuong);
                sp.setGhiChu(ghiChu);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(SanPhamCt sp) {
        try {
            String sql1 = "insert sanPham(id_theLoai,id_chatLieu,id_thuongHieu,id_nhaCungCap,tenSanPham,mau,gia,size,soLuong,ghiChu)VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm1 = conn.prepareStatement(sql1);
            stm1.setInt(1, sp.getIdTL());
            stm1.setInt(2, sp.getIdCL());
            stm1.setInt(3, sp.getIdTH());
            stm1.setInt(4, sp.getIdNCC());
            stm1.setString(5, sp.getTenSP());
            stm1.setString(6, sp.getTenMau());
            stm1.setDouble(7, sp.getGia());
            stm1.setInt(8, sp.getSize());
            stm1.setInt(9, sp.getSoLuong());
            stm1.setString(10, sp.getGhiChu());
            stm1.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(SanPhamCt sp) {
        String sql = "delete sanPham where id_sanPham=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, sp.getIdSanPhamCt());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(SanPhamCt sp) {
        String sql = "update sanPham set id_theLoai=?,id_chatLieu=?,id_thuongHieu=?,id_nhaCungCap=?,tenSanPham=?,mau=?,gia=?,size=?,soLuong=?,ghiChu=?  where id_sanPham =?";
        try {
            PreparedStatement stm1 = conn.prepareStatement(sql);
            stm1.setInt(1, sp.getIdTL());
            stm1.setInt(2, sp.getIdCL());
            stm1.setInt(3, sp.getIdTH());
            stm1.setInt(4, sp.getIdNCC());
            stm1.setString(5, sp.getTenSP());
            stm1.setString(6, sp.getTenMau());
            stm1.setDouble(7, sp.getGia());
            stm1.setInt(8, sp.getSize());
            stm1.setInt(9, sp.getSoLuong());
            stm1.setString(10, sp.getGhiChu());
            stm1.setInt(11, sp.getiDSanPham());
            stm1.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SanPhamCt> timTheoTen(String tenSanPham) {
        try {
            List<SanPhamCt> listTK = new ArrayList<>();
            String sql = "SELECT "
                    + "    sanPham.id_sanPham,\n"
                    + "    sanPham.tenSanPham,  \n"
                    + "    tl.tenTheLoai,\n"
                    + "    cl.tenChatLieu,\n"
                    + "    th.tenThuongHieu,\n"
                    + "    ncc.tennhaCC,\n"
                    + "    sanPham.mau,\n"
                    + "    sanPham.gia,\n"
                    + "    sanPham.size,\n"
                    + "    sanPham.soLuong,\n"
                    + "    sanPham.ghiChu\n"
                    + "FROM\n"
                    + "    sanPham sanPham\n"
                    + "JOIN\n"
                    + "    theloai tl ON sanPham.id_theLoai = tl.id_theLoai\n"
                    + "JOIN\n"
                    + "      chatLieu cl ON sanPham.id_chatLieu = cl.id_chatLieu\n"
                    + "JOIN\n"
                    + "      thuongHieu th ON sanPham.id_thuongHieu = th.id_thuongHieu\n"
                    + "JOIN\n"
                    + "     nhaCungCap ncc ON sanPham.id_nhaCungCap = ncc.id_nhaCC\n"
                    + "  where sanPham.tenSanPham like ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + tenSanPham + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int idSP = rs.getInt("id_sanPham");
                String tenSP = rs.getString("tenSanPham");
                String theLoai = rs.getString("tenTheLoai");
                String chatLieu = rs.getString("tenChatLieu");
                String thuongHieu = rs.getString("tenThuongHieu");
                String nhaCungCap = rs.getString("tennhaCC");
                String mau = rs.getString("mau");
                double gia = rs.getDouble("gia");
                int size = rs.getInt("size");
                int soLuong = rs.getInt("soLuong");
                String ghiChu = rs.getString("ghiChu");

                SanPhamCt spct = new SanPhamCt();
                spct.setiDSanPham(idSP);
                spct.setTenSP(tenSP);
                spct.setTenTheLoai(theLoai);
                spct.setTenChatLieu(chatLieu);
                spct.setTenThuongHieu(thuongHieu);
                spct.setTenNhaCungCap(nhaCungCap);
                spct.setTenMau(mau);
                spct.setGia(gia);
                spct.setSize(size);
                spct.setSoLuong(soLuong);
                spct.setGhiChu(ghiChu);
                listTK.add(spct);

            }
            return listTK;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SanPhamCt> timTheoTuSP(String tenSanPham1) {
        try {
            List<SanPhamCt> listTK = new ArrayList<>();
            String sql = "SELECT "
                    + "    sanPham.id_sanPham,\n"
                    + "    sanPham.tenSanPham,  \n"
                    + "    tl.tenTheLoai,\n"
                    + "    cl.tenChatLieu,\n"
                    + "    th.tenThuongHieu,\n"
                    + "    ncc.tennhaCC,\n"
                    + "    sanPham.mau,\n"
                    + "    sanPham.gia,\n"
                    + "    sanPham.size,\n"
                    + "    sanPham.soLuong,\n"
                    + "    sanPham.ghiChu\n"
                    + "FROM\n"
                    + "    sanPham sanPham\n"
                    + "JOIN\n"
                    + "    theloai tl ON sanPham.id_theLoai = tl.id_theLoai\n"
                    + "JOIN\n"
                    + "      chatLieu cl ON sanPham.id_chatLieu = cl.id_chatLieu\n"
                    + "JOIN\n"
                    + "      thuongHieu th ON sanPham.id_thuongHieu = th.id_thuongHieu\n"
                    + "JOIN\n"
                    + "     nhaCungCap ncc ON sanPham.id_nhaCungCap = ncc.id_nhaCC\n"
                    + "  where sanPham.id_sanPham=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenSanPham1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int idSP = rs.getInt("id_sanPham");
                String tenSP = rs.getString("tenSanPham");
                String theLoai = rs.getString("tenTheLoai");
                String chatLieu = rs.getString("tenChatLieu");
                String thuongHieu = rs.getString("tenThuongHieu");
                String nhaCungCap = rs.getString("tennhaCC");
                String mau = rs.getString("mau");
                double gia = rs.getDouble("gia");
                int size = rs.getInt("size");
                int soLuong = rs.getInt("soLuong");
                String ghiChu = rs.getString("ghiChu");

                SanPhamCt spct = new SanPhamCt();
                spct.setiDSanPham(idSP);
                spct.setTenSP(tenSP);
                spct.setTenTheLoai(theLoai);
                spct.setTenChatLieu(chatLieu);
                spct.setTenThuongHieu(thuongHieu);
                spct.setTenNhaCungCap(nhaCungCap);
                spct.setTenMau(mau);
                spct.setGia(gia);
                spct.setSize(size);
                spct.setSoLuong(soLuong);
                spct.setGhiChu(ghiChu);
                listTK.add(spct);

            }
            return listTK;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkTrungTheLoai(int id_sanPham, int id_theLoai) {
        try {
            String query = "SELECT COUNT(*) FROM sanPham WHERE id_sanPham = ? AND id_theLoai = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_theLoai);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkTrungChatLieu(int id_sanPham, int id_chatLieu) {
        try {
            String query = "SELECT COUNT(*) FROM sanPham WHERE id_sanPham = ? AND id_chatLieu = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_chatLieu);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkTrungThuongHieu(int id_sanPham, int id_thuongHieu) {
        try {
            String query = "SELECT COUNT(*) FROM sanPham WHERE id_sanPham = ? AND id_thuongHieu = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_thuongHieu);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkTrungNhaCC(int id_sanPham, int id_nhaCungCap) {
        try {
            String query = "SELECT COUNT(*) FROM sanPham WHERE id_sanPham = ? AND id_nhaCungCap = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_nhaCungCap);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkTrungMau(int id_sanPham, int id_mau) {
//        try {
//            String query = "SELECT COUNT(*) FROM sanPhamCt WHERE id_sanPham = ? AND id_mau = ? ";
//            PreparedStatement stm = conn.prepareStatement(query);
//            stm.setInt(1, id_sanPham);
//            stm.setInt(2, id_mau);
//            ResultSet rs = stm.executeQuery();
//            if (rs.next()) {
//                int count = rs.getInt(1);
//                return count > 0;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return false;
    }

    @Override
    public boolean checkTrungTT(int id_theLoai, int id_chatLieu, int id_thuongHieu, int id_nhaCungCap) {
        try {
            String query = "SELECT COUNT(*) FROM sanPham WHERE  id_theLoai = ? AND id_chatLieu = ? AND id_thuongHieu = ? AND id_nhaCungCap = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_theLoai);
            stm.setInt(2, id_chatLieu);
            stm.setInt(3, id_thuongHieu);
            stm.setInt(4, id_nhaCungCap);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
