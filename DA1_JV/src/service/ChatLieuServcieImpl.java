package service;

import connectionProvider.DBConnect;
import model.ChatLieu;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ChatLieuServcieImpl {

    private Connection conn = DBConnect.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    List<ChatLieu> listCL;

    public List<ChatLieu> getChatLieu() {
        try {
            List<ChatLieu> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "select DISTINCT * from chatLieu";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idChatLieu = rs.getInt(1);
                String tenChatLieu = rs.getString(2);

                ChatLieu tl = new ChatLieu();
                tl.setIdChatLieu(idChatLieu);
                tl.setTenChatLieu(tenChatLieu);
                list.add(tl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(ChatLieu cl) {
        try {
            String sql = "INSERT chatLieu(tenChatLieu) VALUES(?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, cl.getTenChatLieu());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }

    public boolean deleteSV(ChatLieu cl) {
        String SQL = "DELETE FROM chatLieu WHERE id_chatLieu = ?";
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, cl.getIdChatLieu());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
     public void suaChatLieu(ChatLieu cl) {
        try {
            String sql = "update chatLieu "
                    + "set  tenChatLieu=?  "
                    + "where id_chatLieu = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, cl.getTenChatLieu());
            prm.setString(2, String.valueOf(cl.getIdChatLieu()));
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sửa thất bại");
            e.printStackTrace();
        }
    }

}
