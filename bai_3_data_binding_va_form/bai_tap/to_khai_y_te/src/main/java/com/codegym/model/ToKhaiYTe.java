package com.codegym.model;

public class ToKhaiYTe {
    private Integer id;
    private String hoTen;
    private String namsinh;
    private Integer gioiTinh;
    private String quocTich;
    private String thongTinDiLai;
    private String soHieuPhuongTien;
    private String soGhe;
    private String ngayKhoiHanh;
    private String ngayKetThuc;
    private String diaChiNoiO;
    private String soDienThoai;
    private String email;
    private String[] trieuChung;
    private String[] lichSuPhoiNhiem;

    public ToKhaiYTe() {
    }

    public ToKhaiYTe(Integer id, String hoTen, String namsinh, Integer gioiTinh, String quocTich, String thongTinDiLai,
                     String soHieuPhuongTien, String soGhe, String ngayKhoiHanh, String ngayKetThuc,
                     String diaChiNoiO, String soDienThoai, String email, String[] trieuChung,
                     String[] lichSuPhoiNhiem) {
        this.id = id;
        this.hoTen = hoTen;
        this.namsinh = namsinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.thongTinDiLai = thongTinDiLai;
        this.soHieuPhuongTien = soHieuPhuongTien;
        this.soGhe = soGhe;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.diaChiNoiO = diaChiNoiO;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.trieuChung = trieuChung;
        this.lichSuPhoiNhiem = lichSuPhoiNhiem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getThongTinDiLai() {
        return thongTinDiLai;
    }

    public void setThongTinDiLai(String thongTinDiLai) {
        this.thongTinDiLai = thongTinDiLai;
    }

    public String getSoHieuPhuongTien() {
        return soHieuPhuongTien;
    }

    public void setSoHieuPhuongTien(String soHieuPhuongTien) {
        this.soHieuPhuongTien = soHieuPhuongTien;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }


    public String getDiaChiNoiO() {
        return diaChiNoiO;
    }

    public void setDiaChiNoiO(String diaChiNoiO) {
        this.diaChiNoiO = diaChiNoiO;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String[] trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String[] getLichSuPhoiNhiem() {
        return lichSuPhoiNhiem;
    }

    public void setLichSuPhoiNhiem(String[] lichSuPhoiNhiem) {
        this.lichSuPhoiNhiem = lichSuPhoiNhiem;
    }
}
