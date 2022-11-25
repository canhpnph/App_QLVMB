package com.example.da1_group6.model;

import android.graphics.Bitmap;

public class KhachHang {
    String makh,tenkh, ngaysinh, email, sdt, cccd;
    int gioitinh;
    String diachi,  quoctich, matkhau;
    Bitmap image;

    public KhachHang(String makh, String tenkh, String ngaysinh, String email, String sdt, String cccd, int gioitinh, String diachi, String quoctich, String matkhau, Bitmap image) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.sdt = sdt;
        this.cccd = cccd;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.quoctich = quoctich;
        this.matkhau = matkhau;
        this.image = image;
    }

    public KhachHang() {
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getQuoctich() {
        return quoctich;
    }

    public void setQuoctich(String quoctich) {
        this.quoctich = quoctich;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
