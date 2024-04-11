package model;

public class Mau {

    public int idMau;
    public String tenMau;

    public Mau() {
    }

    public Mau(int idMau, String tenMau) {
        this.idMau = idMau;
        this.tenMau = tenMau;
    }

    public int getIdMau() {
        return idMau;
    }

    public void setIdMau(int idMau) {
        this.idMau = idMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    
    @Override
    public String toString() {
        return String.valueOf(idMau);
    }
    
      public Object[] toDataRow() {
        return new Object[]{
           this.idMau,
            this.tenMau
        };
    }

}
