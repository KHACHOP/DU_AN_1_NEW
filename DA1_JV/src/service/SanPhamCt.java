package service;

public class SanPhamCt {
    public int idSanPhamCt;
    public int iDSanPham;
    //
    public int idTL;
    public int idCL;
    public int idTH;
    public int idNCC;
    public int idMau;
    //
    public String tenSP;
    public String tenTheLoai;
    public String tenChatLieu;
    public String tenThuongHieu;
    public String tenNhaCungCap;
    public String tenMau;
    public double gia;
    public int size;
    public int soLuong;
    public String ghiChu;

    

//    public String theLoai() {
//        if (this.getTheLoai() == 1) {
//            return "chạy";
//        } else if (this.getTheLoai() == 2) {
//            return "đá bóng";
//        } else if (this.getTheLoai() == 3) {
//            return "bóng rổ";
//        } else {
//            return "nhảy cao";
//        }
//    }
//
//    public String chatLieu() {
//        if (this.getChatLieu() == 1) {
//            return "vải";
//        } else if (this.getChatLieu() == 2) {
//            return "da bò";
//        } else if (this.getChatLieu() == 3) {
//            return "cacbon";
//        } else {
//            return "lụa";
//        }
//    }
//
//    public String thuongHieu() {
//        if (this.getThuongHieu() == 1) {
//            return "adidas";
//        } else if (this.getThuongHieu() == 2) {
//            return "puma";
//        } else if (this.getThuongHieu() == 3) {
//            return "poly";
//        } else {
//            return "nike";
//        }
//    }
//
//    public String NCC() {
//        if (this.getNhaCungCap() == 1) {
//            return "Mỹ";
//        } else if (this.getNhaCungCap() == 2) {
//            return "Anh";
//        } else if (this.getNhaCungCap() == 3) {
//            return "Pháp";
//        } else {
//            return "Trung Quốc";
//        }
//    }
//
//    public String loaiMau() {
//        if (this.getMau() == 1) {
//            return "Xanh";
//        } else if (this.getMau() == 2) {
//            return "Đỏ";
//        } else if (this.getMau() == 3) {
//            return "Tím";
//        } else if (this.getMau() == 4) {
//            return "Vàng";
//        } else if (this.getMau() == 5) {
//            return "Đen";
//        } else {
//            return "Hồng";
//        }
//    }

    public SanPhamCt() {
    }

    public SanPhamCt(int iDSanPham, int idTL, int idCL, int idTH, int idNCC, String tenSP, String tenTheLoai, String tenChatLieu, String tenThuongHieu, String tenNhaCungCap, String tenMau, double gia, int size, int soLuong, String ghiChu) {
        this.iDSanPham = iDSanPham;
        this.idTL = idTL;
        this.idCL = idCL;
        this.idTH = idTH;
        this.idNCC = idNCC;
        this.tenSP = tenSP;
        this.tenTheLoai = tenTheLoai;
        this.tenChatLieu = tenChatLieu;
        this.tenThuongHieu = tenThuongHieu;
        this.tenNhaCungCap = tenNhaCungCap;
        this.tenMau = tenMau;
        this.gia = gia;
        this.size = size;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    public SanPhamCt(int idSanPhamCt, int iDSanPham, int idTL, int idCL, int idTH, int idNCC, int idMau, String tenSP, String tenTheLoai, String tenChatLieu, String tenThuongHieu, String tenNhaCungCap, String tenMau, double gia, int size, int soLuong, String ghiChu) {
        this.idSanPhamCt = idSanPhamCt;
        this.iDSanPham = iDSanPham;
        this.idTL = idTL;
        this.idCL = idCL;
        this.idTH = idTH;
        this.idNCC = idNCC;
        this.idMau = idMau;
        this.tenSP = tenSP;
        this.tenTheLoai = tenTheLoai;
        this.tenChatLieu = tenChatLieu;
        this.tenThuongHieu = tenThuongHieu;
        this.tenNhaCungCap = tenNhaCungCap;
        this.tenMau = tenMau;
        this.gia = gia;
        this.size = size;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    public int getIdSanPhamCt() {
        return idSanPhamCt;
    }

    public void setIdSanPhamCt(int idSanPhamCt) {
        this.idSanPhamCt = idSanPhamCt;
    }

    public int getiDSanPham() {
        return iDSanPham;
    }

    public void setiDSanPham(int iDSanPham) {
        this.iDSanPham = iDSanPham;
    }

    public int getIdTL() {
        return idTL;
    }

    public void setIdTL(int idTL) {
        this.idTL = idTL;
    }

    public int getIdCL() {
        return idCL;
    }

    public void setIdCL(int idCL) {
        this.idCL = idCL;
    }

    public int getIdTH() {
        return idTH;
    }

    public void setIdTH(int idTH) {
        this.idTH = idTH;
    }

    public int getIdNCC() {
        return idNCC;
    }

    public void setIdNCC(int idNCC) {
        this.idNCC = idNCC;
    }

    public int getIdMau() {
        return idMau;
    }

    public void setIdMau(int idMau) {
        this.idMau = idMau;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    

   

}
