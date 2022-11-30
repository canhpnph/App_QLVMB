package com.example.da1_group6.model;

public class VeMB {
    int mavmb;
    String mamb, macb, manv, tennv, makh, tenkh;
    String diemdi, diemden, timebay, timedatve;
    int trangthai;

    public VeMB(int mavmb, String mamb, String macb, String manv, String tennv, String makh, String tenkh, String diemdi, String diemden, String timebay, String timedatve, int trangthai) {
        this.mavmb = mavmb;
        this.mamb = mamb;
        this.macb = macb;
        this.manv = manv;
        this.tennv = tennv;
        this.makh = makh;
        this.tenkh = tenkh;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.timebay = timebay;
        this.timedatve = timedatve;
        this.trangthai = trangthai;
    }

    public VeMB(int mavmb, String mamb, String macb, String manv, String makh, String timedatve, int trangthai) {
        this.mavmb = mavmb;
        this.mamb = mamb;
        this.macb = macb;
        this.manv = manv;
        this.makh = makh;
        this.timedatve = timedatve;
        this.trangthai = trangthai;
    }

    public VeMB() {
    }

    public int getMavmb() {
        return mavmb;
    }

    public void setMavmb(int mavmb) {
        this.mavmb = mavmb;
    }

    public String getMamb() {
        return mamb;
    }

    public void setMamb(String mamb) {
        this.mamb = mamb;
    }

    public String getMacb() {
        return macb;
    }

    public void setMacb(String macb) {
        this.macb = macb;
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

    public String getDiemdi() {
        return diemdi;
    }

    public void setDiemdi(String diemdi) {
        this.diemdi = diemdi;
    }

    public String getDiemden() {
        return diemden;
    }

    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }

    public String getTimebay() {
        return timebay;
    }

    public void setTimebay(String timebay) {
        this.timebay = timebay;
    }

    public String getTimedatve() {
        return timedatve;
    }

    public void setTimedatve(String timedatve) {
        this.timedatve = timedatve;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
