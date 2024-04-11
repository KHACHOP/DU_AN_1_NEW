 create database    BanGiay_DA1
 go
 use BanGiay_DA1

--ThuongHieu
if object_id('THUONGHIEU') is not null
drop table THUONGHIEU
create table THUONGHIEU
(
	id_thuongHieu int identity(1,1),
	tenThuongHieu nvarchar(50),
	trangThai int, --0 hoạt động, 1 ngừng 
	constraint pk_ThuongHieu primary key(id_thuongHieu)
)

SET IDENTITY_INSERT [dbo].THUONGHIEU ON 
INSERT [dbo].THUONGHIEU (id_thuongHieu, tenThuongHieu,trangThai) VALUES (1, N'adidas',0)
INSERT [dbo].THUONGHIEU (id_thuongHieu, tenThuongHieu,trangThai) VALUES (2, N'puma',0)
INSERT [dbo].THUONGHIEU (id_thuongHieu, tenThuongHieu,trangThai) VALUES (3, N'poly',0)
INSERT [dbo].THUONGHIEU (id_thuongHieu, tenThuongHieu,trangThai) VALUES (4, N'nike',0)
SET IDENTITY_INSERT [dbo].THUONGHIEU OFF

--ChatLieu
if object_id('CHATLIEU') is not null
drop table CHATLIEU
create table CHATLIEU
(
	id_chatLieu int identity(1,1),
	tenChatLieu nvarchar(50),
	trangThai int, --0 hoạt động, 1 ngừng 
	constraint pk_ChatLieu primary key(id_chatLieu)
)

SET IDENTITY_INSERT [dbo].[chatLieu] ON 
INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu],trangThai) VALUES (1, N'vải',0)
INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu],trangThai) VALUES (2, N'da bò',0)
INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu],trangThai) VALUES (3, N'cacbon',0)
INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu],trangThai) VALUES (4, N'lụa',0)
INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu],trangThai) VALUES (5, N'ninon',0)
SET IDENTITY_INSERT [dbo].[chatLieu] OFF

--NhaCungCap
if object_id('NHACUNGCAP') is not null
drop table NHACUNGCAP
create table NHACUNGCAP
(
	id_nhaCC int identity(1,1),
	tennhaCC nvarchar(50),
	trangThai int, --0 hoạt động, 1 ngừng 
	constraint pk_NHACUNGCAP primary key(id_nhaCC)
)
SET IDENTITY_INSERT [dbo].NHACUNGCAP ON 
INSERT [dbo].NHACUNGCAP (id_nhaCC, tennhaCC,trangThai) VALUES (1, N'mỹ',0)
INSERT [dbo].NHACUNGCAP (id_nhaCC, tennhaCC,trangThai) VALUES (2, N'anh',0)
INSERT [dbo].NHACUNGCAP (id_nhaCC, tennhaCC,trangThai) VALUES (3, N'Pháp',0)
INSERT [dbo].NHACUNGCAP (id_nhaCC, tennhaCC,trangThai) VALUES (4, N'trung quốc',0)
SET IDENTITY_INSERT [dbo].NHACUNGCAP OFF

--TheLoai
if object_id('THELOAI') is not null
drop table THELOAI
create table THELOAI
(
	id_theLoai int identity(1,1),
	tenTheLoai nvarchar(50),
	trangThai int, --0 hoạt động, 1 ngừng 
	constraint pk_THELOAI primary key(id_theLoai)
)
SET IDENTITY_INSERT [dbo].THELOAI ON 
INSERT [dbo].THELOAI (id_theLoai, tenTheLoai,trangThai) VALUES (1, N'chạy',0)
INSERT [dbo].THELOAI (id_theLoai, tenTheLoai,trangThai) VALUES (2, N'đá bóng',0)
INSERT [dbo].THELOAI (id_theLoai, tenTheLoai,trangThai) VALUES (3, N'bóng rổ',0)
INSERT [dbo].THELOAI (id_theLoai, tenTheLoai,trangThai) VALUES (4, N'nhảy cao',0)
SET IDENTITY_INSERT [dbo].THELOAI OFF

--SanPham
if object_id('SANPHAM') is not null
drop table SANPHAM
create table SANPHAM
(
	id_sanPham int identity(1,1),
	id_theLoai int,
	id_chatLieu int,
	id_thuongHieu int,
	id_nhaCungCap int,
	tenSanPham nvarchar(50),
	mau nvarchar(50),
	gia money,
	size int,
	soLuong int,
	ghiChu nvarchar(250),
	trangThai int, --0 hoạt động, 1 ngừng 
	constraint pk_SanPham primary key(id_sanPham),
	constraint fk_SanPham_TheLoai foreign key(id_theLoai) references theloai,
	constraint fk_SanPham_chatLieu foreign key(id_chatLieu) references chatLieu,
	constraint fk_SanPham_thuongHieu foreign key(id_thuongHieu) references thuongHieu,
	constraint fk_SanPham_nhaCungCap foreign key(id_nhaCungCap) references nhaCungCap,
)
select *  from SANPHAM
SET IDENTITY_INSERT [dbo].SANPHAM ON 
INSERT [dbo].SANPHAM (id_sanPham,id_theLoai,id_chatLieu,id_thuongHieu,id_nhaCungCap, tenSanPham,mau,gia,size,soLuong,ghiChu,trangThai) VALUES (1,1,1,1,1, N'Giày 1',N'Đỏ',1000,30,30,'',0)
INSERT [dbo].SANPHAM (id_sanPham,id_theLoai,id_chatLieu,id_thuongHieu,id_nhaCungCap, tenSanPham,mau,gia,size,soLuong,ghiChu,trangThai) VALUES (2,2,2,2,2, N'Giày 2',N'Vàng',1000,40,40,'',0)
INSERT [dbo].SANPHAM (id_sanPham,id_theLoai,id_chatLieu,id_thuongHieu,id_nhaCungCap, tenSanPham,mau,gia,size,soLuong,ghiChu,trangThai) VALUES (3,3,3,3,3, N'Giày 3',N'Trắng',1000,50,50,'',0)
INSERT [dbo].SANPHAM (id_sanPham,id_theLoai,id_chatLieu,id_thuongHieu,id_nhaCungCap, tenSanPham,mau,gia,size,soLuong,ghiChu,trangThai) VALUES (4,4,4,4,4, N'Giày 4',N'Đen',1000,60,60,'',0)
SET IDENTITY_INSERT [dbo].SANPHAM OFF

--taiKhoan
if object_id('TAIKHOAN') is not null
drop table TAIKHOAN
create table TAIKHOAN
(
	id_taiKhoan int identity(1,1),
	tenTaiKhoan nvarchar(50),
	matKhau nvarchar(50),
	vaiTro bit,
	trangThai int, --0 hoạt động, 1 ngừng 
	constraint pk_TAIKHOAN primary key(id_taiKhoan)
)
SET IDENTITY_INSERT [dbo].TAIKHOAN ON 
INSERT [dbo].TAIKHOAN (id_taiKhoan, tenTaiKhoan,matKhau,vaiTro,trangThai) VALUES (1, N'hoanAdmin','hoan123',0,0)
INSERT [dbo].TAIKHOAN (id_taiKhoan, tenTaiKhoan,matKhau,vaiTro,trangThai) VALUES (2, N'hoanNhanVien','hoan123',1,0)
INSERT [dbo].TAIKHOAN (id_taiKhoan, tenTaiKhoan,matKhau,vaiTro,trangThai) VALUES (3, N'hoanTest','hoan123',1,0)
SET IDENTITY_INSERT [dbo].TAIKHOAN OFF

--NhanVien
if object_id('NHANVIEN') is not null
drop table NHANVIEN
create table NHANVIEN
(
	id_nhanVien int identity(1,1),
	id_taiKhoan int,
	hoTen nvarchar(50),
	gioiTinh bit, --0 NAM 1 NỮ
	soDt nvarchar(50),
	diaChi nvarchar(50),
	trangThai int, --0 hoạt động, 1 ngừng 
	constraint pk_NHANVIEN primary key(id_nhanVien),
	constraint fk_NHANVIEN_TAIKHOAN foreign key(id_taiKhoan) references TAIKHOAN
)
SET IDENTITY_INSERT [dbo].NHANVIEN ON 
INSERT [dbo].NHANVIEN (id_nhanVien, id_taiKhoan,hoTen,gioiTinh,soDt,diaChi,trangThai) VALUES (1, 1,N'Hoàn dz',0,'0915836583',N'HÀ NỘI',0)
INSERT [dbo].NHANVIEN (id_nhanVien, id_taiKhoan,hoTen,gioiTinh,soDt,diaChi,trangThai) VALUES (2, 2,N'Hoàn NHÂN VIÊN',0,'0915836583',N'HÀ NỘI',0)
INSERT [dbo].NHANVIEN (id_nhanVien, id_taiKhoan,hoTen,gioiTinh,soDt,diaChi,trangThai) VALUES (3, 3,N'Hoàn test',0,'0915836583',N'HÀ NỘI',0)
SET IDENTITY_INSERT [dbo].NHANVIEN OFF

--khuyenMai
if object_id('KHUYENMAI') is not null
drop table KHUYENMAI
create table KHUYENMAI
(
	id_khuyenMai int identity(1,1),
	tenKhuyenMai nvarchar(50),
	loai nvarchar(50),
	giaTri nvarchar(20),
	ngayBatDau datetime,
	ngayKetThuc datetime,
	trangThai int, --0 hoạt động, 1 ngừng 
	constraint pk_KHUYENMAI primary key(id_khuyenMai)
)
SET IDENTITY_INSERT [dbo].KHUYENMAI ON 
INSERT [dbo].KHUYENMAI (id_khuyenMai, tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai) VALUES (1, N'Khuyến mãi poly','%',20,'2023-10-11','2023-12-09',1)
INSERT [dbo].KHUYENMAI (id_khuyenMai, tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai) VALUES (2, N'Khuyến mãi dự án 1','%',50,'2023-10-13','2023-11-25',0)
INSERT [dbo].KHUYENMAI (id_khuyenMai, tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai) VALUES (3, N'khuyến mãi poly2','VNĐ',90000,'2023-10-10','2023-10-31',1)
INSERT [dbo].KHUYENMAI (id_khuyenMai, tenKhuyenMai,loai,giaTri,ngayBatDau,ngayKetThuc,trangThai) VALUES (4, N'khuyến mãi poly99','VNĐ',11111,'2023-10-10','2023-10-31',1)
SET IDENTITY_INSERT [dbo].KHUYENMAI OFF

--khachHang
if object_id('KHACHHANG') is not null
drop table KHACHHANG
create table KHACHHANG
(
	id_khachHang int identity(1,1),
	hoTen nvarchar(50),
	gioiTinh bit,
	diaChi nvarchar(20),
	soDienThoai nvarchar(15),
	constraint pk_KHACHHANG primary key(id_khachHang)
)
SET IDENTITY_INSERT [dbo].KHACHHANG ON 
INSERT [dbo].KHACHHANG (id_khachHang,hoTen,gioiTinh,diaChi,soDienThoai) VALUES (1,N'Nguyễn Thị A',1,N'Hà Nội',1)
INSERT [dbo].KHACHHANG (id_khachHang,hoTen,gioiTinh,diaChi,soDienThoai) VALUES (2,N'Nguyễn văn B',0,N'Hà Nội','012345')
INSERT [dbo].KHACHHANG (id_khachHang,hoTen,gioiTinh,diaChi,soDienThoai) VALUES (3,N'Nguyễn Thị C',1,N'Hà Nội','012345')
SET IDENTITY_INSERT [dbo].KHACHHANG OFF

--HoaDon
if object_id('HOADON') is not null
drop table HOADON
create table HOADON
(
	id_hoaDon int identity(1,1),
	id_nhanvien int,
	id_sanPham int,
	id_khachHang int,
	id_khuyenMai int,
	soLuong int,
	donGia float,
	ngayTao datetime,
	constraint pk_HOADON primary key(id_hoaDon),
	constraint fk_HOADON_NhanVien foreign key(id_nhanvien) references nhanvien,
	constraint fk_HOADON_SanPham foreign key(id_sanPham) references sanpham,
	constraint fk_HOADON_khachHang foreign key(id_khachHang) references khachHang,
	constraint fk_HOADON_khuyenMai foreign key(id_khuyenMai) references khuyenMai
)
SET IDENTITY_INSERT [dbo].HOADON ON 
INSERT [dbo].HOADON (id_hoaDon,id_nhanvien,id_sanPham,id_khachHang,id_khuyenMai,soLuong,donGia,
ngayTao) VALUES (1,1,1,1,1,2,4000,'2023-10-10')
INSERT [dbo].HOADON (id_hoaDon,id_nhanvien,id_sanPham,id_khachHang,id_khuyenMai,soLuong,donGia,
ngayTao) VALUES (2,1,1,1,1,2,4000,'2023-10-11')
INSERT [dbo].HOADON (id_hoaDon,id_nhanvien,id_sanPham,id_khachHang,id_khuyenMai,soLuong,donGia,
ngayTao) VALUES (3,1,1,1,1,2,4000,'2023-10-12')
SET IDENTITY_INSERT [dbo].HOADON OFF