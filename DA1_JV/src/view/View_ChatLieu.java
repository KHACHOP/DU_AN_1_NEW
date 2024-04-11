/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.ChatLieu;
import java.util.ArrayList;
import java.util.List;
import service.ChatLieuServcieImpl;
import service.ChatLieuService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sontr
 */
public class View_ChatLieu extends javax.swing.JFrame {

    private ChatLieu s = new ChatLieu();
    private ChatLieuServcieImpl ss = new ChatLieuServcieImpl();
    DefaultTableModel mol = new DefaultTableModel();
    private String dtChatLieu;
    private List<ChatLieu> listCL = new ArrayList<>();
    private int index = -1;

    public View_ChatLieu(String dtChatLieu) {
        initComponents();
        this.fillTable();
        setLocationRelativeTo(null);
        this.dtChatLieu = dtChatLieu;
        this.txtIDSP.setText(dtChatLieu);
    }

    private View_ChatLieu() {
        initComponents();
        this.fillTable();
        setLocationRelativeTo(null);
        this.dtChatLieu = dtChatLieu;
        this.txtIDSP.setText(dtChatLieu);
    }

    void fillTable() {
        mol = (DefaultTableModel) tblCL.getModel();
        mol.setRowCount(0);
        for (model.ChatLieu sp : ss.getChatLieu()) {
            Object[] toData = new Object[]{
                sp.getIdChatLieu(), sp.getTenChatLieu()
            };
            mol.addRow(toData);
        }
    }

    void showSP(int index) {
        index = tblCL.getSelectedRow();
        txt_IDchatLIeu.setText(tblCL.getValueAt(index, 0).toString());
        txtTen.setText(tblCL.getValueAt(index, 1).toString());
    }

    void addCL() {
        String tenCL = txtTen.getText();
        model.ChatLieu cl = new model.ChatLieu();
        cl.setTenChatLieu(tenCL);
        boolean addResult = ss.add(cl);
        if (addResult) {
            JOptionPane.showMessageDialog(this, "Thêm chất liệu thành công.");
        } else {
            JOptionPane.showMessageDialog(this, "thêm chất liệu thất bại.");
        }
        this.fillTable();
    }

    void delete() {
        int selectedRow = tblCL.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        int idChatLieu = Integer.parseInt(tblCL.getValueAt(selectedRow, 0).toString());
        ChatLieu cl = new ChatLieu();
        cl.setIdChatLieu(idChatLieu);
        ChatLieuServcieImpl ss = new ChatLieuServcieImpl();
        boolean deleteResult = ss.deleteSV(cl);

        if (deleteResult) {
            JOptionPane.showMessageDialog(this, "Xóa thành công.");
            // Remove the selected row from the table
            mol.removeRow(selectedRow);
            // Reset the index variable
            index = -1;
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại.");
        }
    }

    void Update() {
        int idChatLieu = Integer.parseInt(txt_IDchatLIeu.getText());
        String ten = txtTen.getText();
        ChatLieu cl = new ChatLieu();
        cl.setIdChatLieu(idChatLieu);
        cl.setTenChatLieu(ten);
        ss.suaChatLieu(cl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCL = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        txt_IDchatLIeu = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtIDSP = new javax.swing.JTextField();
        btn_Delete = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        tblCL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID chất liệu", "Tên chất liệu"
            }
        ));
        tblCL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCL);

        jLabel1.setText("ID chất liệu");

        jLabel2.setText("Tên chất liệu");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txt_IDchatLIeu.setEditable(false);

        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/previous.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtIDSP.setEditable(false);

        btn_Delete.setText("Xóa ");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_IDchatLIeu, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Delete)))
                        .addContainerGap(91, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_IDchatLIeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnReset)
                    .addComponent(btn_Delete)
                    .addComponent(btnSua))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCLMouseClicked
        // TODO add your handling code here:
        int index = tblCL.getSelectedRow();
        this.showSP(index);
    }//GEN-LAST:event_tblCLMouseClicked

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        this.addCL();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txt_IDchatLIeu.setText("");
        txtTen.setText(" 11");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        View_SanPhambg spct = new View_SanPhambg(txtIDSP.getText());
        spct.setVisible(true);
        spct.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed

        delete();
        fillTable();
        txt_IDchatLIeu.setText("");
        txtTen.setText("");


    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        Update();
        fillTable();
    }//GEN-LAST:event_btnSuaActionPerformed

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
            java.util.logging.Logger.getLogger(View_ChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_ChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_ChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_ChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_ChatLieu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCL;
    private javax.swing.JTextField txtIDSP;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txt_IDchatLIeu;
    // End of variables declaration//GEN-END:variables

}
