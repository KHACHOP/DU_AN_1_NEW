package model;

public class SanPham {
    public int iDSanPham;
    public String tenSP;
    public String ghiChu;

    public SanPham() {
    }

    public SanPham(int iDSanPham, String tenSP, String ghiChu) {
        this.iDSanPham = iDSanPham;
        this.tenSP = tenSP;
        this.ghiChu = ghiChu;
    }

    public int getiDSanPham() {
        return iDSanPham;
    }

    public void setiDSanPham(int iDSanPham) {
        this.iDSanPham = iDSanPham;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
