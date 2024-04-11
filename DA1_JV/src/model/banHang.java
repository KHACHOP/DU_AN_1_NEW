/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class banHang {
    // hóa đơn

    public int id_hoaDon;
    public int id_hoaDonCt;
    public String tenSanPham;
    public int id_nhanVien;
    public String tenNhanVien;
    public int id_khachHang;
    public String tenKhachHang;
    public int id_khuyenMai;
    public String tenKhuyenMai;
    public double gia;
    public int trangThai;
    public String ngayTao;
    // sản phẩm
    public int id_sanPhamCt;
    public int id_sanPham;
    public int theLoai;
    public String tenTheLoai;
    public int chatLieu;
    public String tenChatLieu;
    public int thuongHieu;
    public String tenThuongHieu;
    public int nhaCungCap;
    public String tenNhaCungCap;
    public int mau;
    public String tenMau;
    public Double giaSp;
    public int size;
    public int soLuong;
    public int soLuongThem;
    public int soLuongGh;
    public int soLuongThemGh;
    public String ghiChu;
    public String tenTK;
    
    public banHang(int id_hoaDon, String tenSanPham, int soLuong, double gia, String tenTheLoai, String tenChatLieu, String tenThuongHieu, String tenNhaCungCap, String tenMau, int size) {
        this.id_hoaDon = id_hoaDon;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.tenTheLoai = tenTheLoai;
        this.tenChatLieu = tenChatLieu;
        this.tenThuongHieu = tenThuongHieu;
        this.tenNhaCungCap = tenNhaCungCap;
        this.tenMau = tenMau;
        this.size = size;
        this.soLuong = soLuong;
    }


    public String checkTT() {
        if (this.trangThai == 1) {
            return "đã thanh toán";
        } else {
            return "chờ thanh toán";
        }
    }
}
