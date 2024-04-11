package service;

import connectionProvider.DBConnect;
import model.TheLoai;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TheLoaiServiceImpl {

    private Connection conn = DBConnect.getConnection();

    
    public List<TheLoai> getTheLoai() {
        try {
            List<TheLoai> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "select DISTINCT * from theLoai";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idTheLoai = rs.getInt(1);
                String tenTheLoai = rs.getString(2);

                TheLoai tl = new TheLoai();
                tl.setIdTheLoai(idTheLoai);
                tl.setTenTheLoai(tenTheLoai);
                list.add(tl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

  
    public boolean add(TheLoai tl) {
        try {
            String sql = "INSERT theLoai(tenTheLoai) VALUES(?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tl.getTenTheLoai());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }
 public boolean deleteSV(TheLoai tl) {
        String SQL = "DELETE FROM THELOAI WHERE id_theLoai = ?";
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, tl.getIdTheLoai());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

 public void suaTheLoai(TheLoai tl) {
        try {
            String sql = "update THELOAI "
                    + "set  tenTheLoai=?  "
                    + "where id_theLoai = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, tl.getTenTheLoai());
            prm.setString(2, String.valueOf(tl.getIdTheLoai()));
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sửa thất bại");
            e.printStackTrace();
        }
    }


}
