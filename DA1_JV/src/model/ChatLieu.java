/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sontr
 */
public class ChatLieu {
    public int idChatLieu;
    public String tenChatLieu;

    public ChatLieu() {
    }

    public ChatLieu(int idChatLieu, String tenChatLieu) {
        this.idChatLieu = idChatLieu;
        this.tenChatLieu = tenChatLieu;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    String idChatLieu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "ChatLieu{" + "idChatLieu=" + idChatLieu + ", tenChatLieu=" + tenChatLieu + '}';
    }
    
      public Object[] toDataRow() {
        return new Object[]{
           this.idChatLieu,
            this.tenChatLieu
        };
    }
}
