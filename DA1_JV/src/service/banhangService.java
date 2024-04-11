/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.banHang;

/**
 *
 * @author MSI
 */
public interface banhangService {
    public void taoHoaDon(banHang bh);
    public void themSanPham(banHang bh);
    public void suaSoLuong(banHang bh);
    public void themSoLuong(banHang bh);
    public void thanhToan(banHang bh);
    public void xoaGioHang(banHang bh);
    public void updateGioHang(banHang bh);
    public void updateSpct(banHang bh);
}

