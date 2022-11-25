package com.example.da1_group6.model;

public class VeMB {
    int mavmb;
    String macb, manv, makh, timedatve;
    int trangthai;

    public VeMB(int mavmb, String macb, String manv, String makh, String timedatve, int trangthai) {
        this.mavmb = mavmb;
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

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
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
