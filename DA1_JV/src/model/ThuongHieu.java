package model;

public class ThuongHieu {
    public int idThuongHieu;
    public String tenThuongHieu;

    public ThuongHieu() {
    }

    public ThuongHieu(int idThuongHieu, String tenThuongHieu) {
        this.idThuongHieu = idThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }
    
}
