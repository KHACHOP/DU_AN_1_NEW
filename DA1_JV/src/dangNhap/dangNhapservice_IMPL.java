
package dangNhap;

import connectionProvider.DBConnect;
import model.nhanVien;

/**
 *
 * @author MSI
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class dangNhapservice_IMPL implements nhanVienIMPL{
    public List<dangNhap> getMatKhau(){
        List<dangNhap> listDn = new ArrayList<>();
        try {
               Connection conn = DBConnect.getConnection();
               String sql = "select tentaiKhoan,matkhau from taiKhoan";
               Statement stm = conn.createStatement();
               ResultSet rs = stm.executeQuery(sql);
               while(rs.next()){
                   String tenDangNhap = rs.getString(1);
                   String matKhau =rs.getString(2);
                   dangNhap dn = new dangNhap();
                   dn.setMatKhau(matKhau);
                   listDn.add(dn);
               }
               return listDn;
           } catch (Exception e) {
               e.printStackTrace();
               return null;
           }
    }
    @Override
    public void themTaiKhoan(dangNhap dn) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "insert into taiKhoan(tentaiKhoan,matKhau,vaiTro) values(?,?,?)";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, dn.getTenDangNhap());
            prm.setString(2, String.valueOf(dn.getMatKhau()));
            prm.setInt(3, dn.getVaiTro());
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "đăng kí thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "đăng kí thất bại");
            e.printStackTrace();
        }
    }

    @Override
    public void doiMatKhau(dangNhap dn) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "update taiKhoan set matKhau = ? where tentaiKhoan= ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, String.valueOf(dn.getMatKhauMoi()));
            prm.setString(2, dn.getTenDangNhap());
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "đổi thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "đổi thất bại");
            e.printStackTrace();
        }
    }
    
    
}
