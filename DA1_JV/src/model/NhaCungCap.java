package model;

public class NhaCungCap {
    public int idNhaCungCap;
    public String tenNhaCungCap;

    public NhaCungCap() {
    }

    public NhaCungCap(int idNhaCungCap, String tenNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public int getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(int idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }
    
}
