package com.codegym.model;

public class DiaChiLienLac {
    private String tinhThanh;
    private String quanHuyen;
    private String phuongXa;

    public DiaChiLienLac() {
    }

    public DiaChiLienLac(String tinhThanh, String quanHuyen, String phuongXa) {
        this.tinhThanh = tinhThanh;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }
}
