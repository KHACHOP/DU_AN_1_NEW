package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThongKe {

    public int id_hoaDonCt;
    public int id_hoaDon;
    public int id_sanPham;
    public String tenSanPham;
    public int id_nhanVien;
    public String tenNhanVien;
    public int id_khachHang;
    public String tenKhachHang;
    public int id_khuyenMai;
    public String tenKhuyenMai;
    public int soLuong;
    public double gia;
    public int trangThai;
    public String ngayTao;
    public String tenSP;
    public int idTL;
    public int idCL;
    public int idTH;
    public int idNCC;
    public int idMau;
    public int size;
    public String checkTT() {
        if (this.trangThai == 1) {
            return "đã thanh toán";
        } else {
            return "chờ thanh toán";
        }
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
