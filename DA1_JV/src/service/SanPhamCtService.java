package service;

import java.util.List;
import service.SanPhamCt;

public interface SanPhamCtService {

    List<SanPhamCt> getAll();

    public boolean add(SanPhamCt sp);

    public boolean delete(SanPhamCt sp);

    public boolean update(SanPhamCt sp);

    List<SanPhamCt> timTheoTen(String tenSanPham);

    List<SanPhamCt> timTheoTuSP(String tenSanPham1);

    public boolean checkTrungTheLoai(int id_sanPham, int id_theLoai);

    public boolean checkTrungChatLieu(int id_sanPham, int id_chatLieu);

    public boolean checkTrungThuongHieu(int id_sanPham, int id_thuongHieu);

    public boolean checkTrungNhaCC(int id_sanPham, int id_nhaCungCap);

    public boolean checkTrungMau(int id_sanPham, int id_mau);

    public boolean checkTrungTT( int id_theLoai, int id_chatLieu, int id_thuongHieu, int id_nhaCungCap);
}
