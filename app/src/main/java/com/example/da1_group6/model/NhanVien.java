package com.example.da1_group6.model;

import android.graphics.Bitmap;

public class NhanVien {
    String manv,tennv, email;
    int gioitinh;
    String quoctich, chucvu, matkhau;
    Bitmap image;

    public NhanVien(String manv, String tennv, String email, int gioitinh, String quoctich, String chucvu, String matkhau, Bitmap image) {
        this.manv = manv;
        this.tennv = tennv;
        this.email = email;
        this.gioitinh = gioitinh;
        this.quoctich = quoctich;
        this.chucvu = chucvu;
        this.matkhau = matkhau;
        this.image = image;
    }

    public NhanVien() {
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getQuoctich() {
        return quoctich;
    }

    public void setQuoctich(String quoctich) {
        this.quoctich = quoctich;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
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
