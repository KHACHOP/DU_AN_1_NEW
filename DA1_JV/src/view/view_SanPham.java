package view;

import service.SanPhamCt;
import connectionProvider.DBConnect;
import model.SanPham;
import service.SanPhamService;
import service.SanPhamServiceImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ThongKe;

public class view_SanPham extends javax.swing.JFrame {

    private SanPhamService service = new SanPhamServiceImpl();
    List<SanPhamCt> listSp = service.getAll();
    DefaultTableModel mol = new DefaultTableModel();
    public static String tenSP,thongTin;
    Connection cn;
    long count, soTrang, trang = 1;
    Statement st;
    ResultSet rs;
    private String dataContructor;

    public view_SanPham(String dataContructor) {
        initComponents();
        txt_thongTinNv.setText(dataContructor);
        setLocationRelativeTo(null);
        setTitle("Sản phẩm");
        countDb();
        if (count % 5 == 0) {
            soTrang = count / 5;
        } else {
            soTrang = count / 5 + 1;
        }
        this.loadData(1);
        lblSoTrang.setText("1/" + soTrang);
        lblTrang.setText("1");
    }

    void fillTable() {
        mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        for (SanPhamCt sp : service.getAll()) {
            Object[] toData = new Object[]{
                sp.getiDSanPham(), sp.getTenSP(), sp.getGhiChu()
            };
            mol.addRow(toData);
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_hoaDon = new javax.swing.JButton();
        btn_sanPham = new javax.swing.JButton();
        btn_khuyenMai = new javax.swing.JButton();
        btn_nhanVien = new javax.swing.JButton();
        btn_banHang = new javax.swing.JButton();
        btn_trangChu = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btn_thongKe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_thongTinNv = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnSPCT = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        lblTrang = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblSoTrang = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 153, 153));

        btn_hoaDon.setBackground(new java.awt.Color(204, 204, 255));
        btn_hoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/List.png"))); // NOI18N
        btn_hoaDon.setText("Hóa đơn");
        btn_hoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoaDonActionPerformed(evt);
            }
        });

        btn_sanPham.setBackground(new java.awt.Color(204, 204, 255));
        btn_sanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping_cart.png"))); // NOI18N
        btn_sanPham.setText("Sản Phẩm");
        btn_sanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sanPhamActionPerformed(evt);
            }
        });

        btn_khuyenMai.setBackground(new java.awt.Color(204, 204, 255));
        btn_khuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/speaker.png"))); // NOI18N
        btn_khuyenMai.setText("Khuyến mãi");
        btn_khuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khuyenMaiActionPerformed(evt);
            }
        });

        btn_nhanVien.setBackground(new java.awt.Color(204, 204, 255));
        btn_nhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/users_1.png"))); // NOI18N
        btn_nhanVien.setText("Nhân viên");
        btn_nhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhanVienActionPerformed(evt);
            }
        });

        btn_banHang.setBackground(new java.awt.Color(204, 204, 255));
        btn_banHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/business_user.png"))); // NOI18N
        btn_banHang.setText("Bán Hàng");
        btn_banHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_banHangActionPerformed(evt);
            }
        });

        btn_trangChu.setBackground(new java.awt.Color(204, 204, 255));
        btn_trangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Home.png"))); // NOI18N
        btn_trangChu.setText("Trang chủ");
        btn_trangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trangChuActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User.png"))); // NOI18N
        jButton7.setEnabled(false);

        btn_thongKe.setBackground(new java.awt.Color(204, 204, 255));
        btn_thongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Statistics.png"))); // NOI18N
        btn_thongKe.setText("Thống kê");
        btn_thongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_banHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_hoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_sanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_khuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_nhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btn_thongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_trangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_trangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_banHang, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_thongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 153, 153));

        txt_thongTinNv.setText("thông tin nhân viên");
        txt_thongTinNv.setToolTipText("");
        txt_thongTinNv.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_thongTinNv, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(txt_thongTinNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id sản phẩm", "Tên sản phẩm", "Ghi chú"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btnSPCT.setBackground(new java.awt.Color(255, 204, 204));
        btnSPCT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSPCT.setText("Sản phẩm chi tiết");
        btnSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPCTActionPerformed(evt);
            }
        });

        btnFirst.setText("<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPre.setText("<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        lblTrang.setText("....");

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        lblSoTrang.setText("......");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSPCT)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSoTrang)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(btnPre)
                    .addComponent(btnFirst)
                    .addComponent(lblTrang)
                    .addComponent(lblSoTrang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPCTActionPerformed
        // TODO add your handling code here:
        View_SanPhambg spct = new View_SanPhambg("");
        spct.setVisible(true);
        spct.setLocationRelativeTo(null);
        this.dispose();     

    }//GEN-LAST:event_btnSPCTActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tblSanPham.getSelectedRow();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        trang = 1;
        loadData(trang);
        lblTrang.setText("1");
        lblSoTrang.setText("1/" + soTrang);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:
        if (trang > 1) {
            trang--;
            loadData(trang);
            lblTrang.setText("" + trang);
            lblSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (trang < soTrang) {
            trang++;
            loadData(trang);
            lblTrang.setText("" + trang);
            lblSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        trang = soTrang;
        loadData(trang);
        lblTrang.setText("" + soTrang);
        lblSoTrang.setText(soTrang + "/" + soTrang);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btn_sanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanPhamActionPerformed
        JOptionPane.showMessageDialog(null, "bạn đang ở chức năng sản phẩm");
    }//GEN-LAST:event_btn_sanPhamActionPerformed

    private void btn_hoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoaDonActionPerformed
        view_hoaDon viewhd = new view_hoaDon(txt_thongTinNv.getText());
        viewhd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_hoaDonActionPerformed

    private void btn_trangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trangChuActionPerformed
        view_backGroud viewbg = new view_backGroud(txt_thongTinNv.getText());
        viewbg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_trangChuActionPerformed

    private void btn_banHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_banHangActionPerformed
        View_banHang viewbh = new View_banHang(txt_thongTinNv.getText(), "");
        viewbh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_banHangActionPerformed

    private void btn_khuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khuyenMaiActionPerformed
        view_khuyenMai viewKm = new view_khuyenMai(txt_thongTinNv.getText());
        viewKm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_khuyenMaiActionPerformed

    private void btn_nhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhanVienActionPerformed
       view_nhanVien viewNv = new view_nhanVien(txt_thongTinNv.getText());
       viewNv.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_nhanVienActionPerformed

    private void btn_thongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeActionPerformed
        ThongKe viewTK = new thongke(txt_thongTinNv.getText());
        viewTK.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_thongKeActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(view_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_SanPham("").setVisible(true);
            }
        });
    }


    // phân trang
    public void countDb() {
        Connection conn = DBConnect.getConnection();
        try {
            String query = "Select count(id_sanPham) from sanPham";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                count = rs.getLong(1);
                //System.out.println(count);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadData(long trang) {
        Connection conn = DBConnect.getConnection();
        mol = (DefaultTableModel) tblSanPham.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        try {
            String query = "select top 5 * from sanPham where [id_sanPham] not in (select top " + (trang * 5 - 5) + " [id_sanPham] from sanPham )";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Vector v = new Vector();
               int idSP = rs.getInt("id_sanPham");
                String tenSP = rs.getString("tenSanPham");
                String ghiChu = rs.getString("ghiChu");
                v.add(idSP);
                v.add(tenSP);
                v.add(ghiChu);
                mol.addRow(v);
                //System.out.println(v);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSPCT;
    private javax.swing.JButton btn_banHang;
    private javax.swing.JButton btn_hoaDon;
    private javax.swing.JButton btn_khuyenMai;
    private javax.swing.JButton btn_nhanVien;
    private javax.swing.JButton btn_sanPham;
    private javax.swing.JButton btn_thongKe;
    private javax.swing.JButton btn_trangChu;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSoTrang;
    private javax.swing.JLabel lblTrang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txt_thongTinNv;
    // End of variables declaration//GEN-END:variables
}
