package service;

import model.TheLoai;
import java.util.List;

public interface TheLoaiService {
    List<TheLoai> getTheLoai();
    public boolean add(TheLoai tl);
     public boolean deletecl(TheLoai tl);

    public boolean deletecl(int idtheLoai);
    public void suaTheLoai(TheLoai tl);
}
