/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import service.khachHangService_impl;
import connectionProvider.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class view_khachHang extends javax.swing.JFrame {
    
    private khachHangService_impl service = new khachHangService_impl();
    private long count, sotrang, trang, counthd, sotranghd, tranghd = 1;
    private String data_maKh;
    private String datacontructor;
    
    public view_khachHang(String data_maKh,String datacontructor) {
        initComponents();
        countSanPham();
        if (count % 3 == 0) {
            trang = count / 3;
        } else {
            trang = count / 3 + 1;
        }
        //fillTable(1, "");
        loadKhachHang(1, "");
        lbl_soTrang.setText("1/" + trang);
        Txt_tenNhanVien.setText(datacontructor);
    }
//    public view_khachHang() {
//        initComponents();
//        countSanPham();
//        if (count % 3 == 0) {
//            trang = count / 3;
//        } else {
//            trang = count / 3 + 1;
//        }
//        //fillTable(1, "");
//        loadKhachHang(1, "");
//        lbl_soTrang.setText("1/" + trang);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_khachHang = new javax.swing.JTable();
        txt_timKiem = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        lbl_soTrang = new javax.swing.JLabel();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        Txt_tenNhanVien = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_khachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_khachHang", "tên khách Hàng", "giới tính", "địa chỉ", "số điện thoại"
            }
        ));
        tbl_khachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_khachHang);

        btn_timKiem.setText("Tìm kiếm");
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        btn_Them.setText("Thêm khách hàng");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        lbl_soTrang.setText("jLabel1");

        btn_prev.setText("<<");
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_back.setText("back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_timKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Them)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Txt_tenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_prev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_soTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_next)
                .addGap(33, 33, 33)
                .addComponent(btn_back)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timKiem)
                    .addComponent(btn_Them))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_tenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_soTrang)
                        .addComponent(btn_prev)
                        .addComponent(btn_next)
                        .addComponent(btn_back)))
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        if (sotrang > 1) {
            sotrang--;
            loadKhachHang(sotrang, "");
            lbl_soTrang.setText(sotrang + "/" + trang);
        }
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        if (sotrang < trang) {
            sotrang++;
            loadKhachHang(sotrang, "");
            lbl_soTrang.setText(sotrang + "/" + trang);
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        String search = txt_timKiem.getText();
        loadKhachHang(1, search);
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        String thongTinNV = Txt_tenNhanVien.getText();
        view_themKH viewTKH = new view_themKH(Txt_tenNhanVien.getText());
        viewTKH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
       View_banHang view_bh = new View_banHang(Txt_tenNhanVien.getText(),"");
       view_bh.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void tbl_khachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khachHangMouseClicked
        int index = tbl_khachHang.getSelectedRow();
        String id_KH = tbl_khachHang.getValueAt(index, 0).toString();
        View_banHang viewBh = new View_banHang(Txt_tenNhanVien.getText(),id_KH);
        viewBh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbl_khachHangMouseClicked
    
    void countSanPham() {
        Connection conn = DBConnect.getConnection();
        try {
            String sql = "Select count (id_khachHang) from khachHang";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                count = rs.getLong(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void loadKhachHang(long soTrang, String Search) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_khachHang.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        
        try {
            if (Search.equals("")) {
                String sql = "SELECT TOP 3 id_khachHang,hoTen,gioiTinh,diaChi,soDienThoai\n"
                        + "FROM khachHang\n"
                        + "WHERE id_khachHang NOT IN (SELECT TOP " + (soTrang * 3 - 3) + " id_khachHang FROM khachHang)";
                Connection conn = DBConnect.getConnection();
                Statement stm = conn.createStatement();
                rs = stm.executeQuery(sql);
            } else {
                String sql = "SELECT TOP 3 id_khachHang,hoTen,gioiTinh,diaChi,soDienThoai\n"
                        + "FROM khachHang\n"
                        + "WHERE id_khachHang NOT IN (SELECT TOP " + (soTrang * 3 - 3) + " id_khachHang FROM khachHang)"
                        + "and hoTen like ?";
                Connection conn = DBConnect.getConnection();
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, "%" + Search + "%");
                rs = prm.executeQuery();
            }
            while (rs.next()) {
                int id_khachHang = Integer.parseInt(rs.getString(1));
                String tenKhachHang = rs.getString(2);
                int gioiTinh = Integer.parseInt(rs.getString(3));
                String diaChi = rs.getString(4);
                String soDienThoai = rs.getString(5);
                
                Vector vt = new Vector();
                vt.add(id_khachHang);
                vt.add(tenKhachHang);
                String checkTT;
                if(gioiTinh == 0){
                    checkTT = "Nam";
                }else{
                    checkTT = "Nữ";
                }
                vt.add(checkTT);
                vt.add(diaChi);
                vt.add(soDienThoai);
                mol.addRow(vt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view_khachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_khachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_khachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_khachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_khachHang("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Txt_tenNhanVien;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_soTrang;
    private javax.swing.JTable tbl_khachHang;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
