package service;

import model.ThongKe;
import java.util.List;

public interface ThongKeService {
    List<ThongKe> getAll();

    public Double tongThang();
    public Double tongNam();
    public  Double tongNgay();
}
