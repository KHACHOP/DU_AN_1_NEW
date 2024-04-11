/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author MSI
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class nhanVien {
    public int id_nhanVien;
    public String tenNhanVien;
    public int gioiTinh;
    public int soDienThoai;
    public String email;
    public String diaChi;
    public int taiKhoan;
    public int trangThai;
    
    public String checkGT(){
        if(this.gioiTinh == 0){
            return "nam";
        }else{
            return "nữ";
        }
    }
    public String checkTT(){
        if(this.trangThai == 0){
            return "đang làm";
        }else{
            return "đã nghỉ";
        }
    }
}
