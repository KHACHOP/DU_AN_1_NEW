package service;

import connectionProvider.DBConnect;
import model.SanPham;
import service.SanPhamCt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {

    private Connection conn = DBConnect.getConnection();

    @Override
    public List<SanPhamCt> getAll() {
        try {
            List<SanPhamCt> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "select * from sanPham";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idSP = rs.getInt("id_sanPham");
                String tenSP = rs.getString("tenSanPham");
                String ghiChu = rs.getString("ghiChu");

                SanPhamCt sp = new SanPhamCt();
                sp.setiDSanPham(idSP);
                sp.setTenSP(tenSP);
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
    public boolean add(SanPham sp) {
        try {
            String sql = "INSERT sanPham(tenSanPham,ghiChu) VALUES(?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);           
            stm.setString(1, sp.getTenSP());
            stm.setString(2, sp.getGhiChu());
            stm.executeUpdate();
                       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }

}
