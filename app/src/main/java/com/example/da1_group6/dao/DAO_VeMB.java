package com.example.da1_group6.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.da1_group6.database.SQLite;
import com.example.da1_group6.model.VeMB;

import java.util.ArrayList;

public class DAO_VeMB {
    SQLite sql;
    SQLiteDatabase dtb;

    public DAO_VeMB(Context context) {
        sql = new SQLite(context);
    }

    public ArrayList<VeMB> getAll() {
        ArrayList<VeMB> list = new ArrayList<>();
        dtb = sql.getReadableDatabase();
        Cursor cursor = dtb.rawQuery("select vmb.mavmb, cb.mamb, cb.macb,nv.manv, nv.tennv,kh.makh, kh.tenkh, cb.diemdi, cb.diemden, cb.timebay, vmb.timedatve, vmb.trangthai\n" +
                "from CHUYENBAY cb , KHACHHANG kh , NHANVIEN nv, VEMAYBAY vmb \n" +
                "where vmb.macb = cb.macb and vmb.manv = nv.manv and vmb.makh = kh.makh", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            VeMB vmb = new VeMB();
            vmb.setMavmb(cursor.getInt(0));
            vmb.setMamb(cursor.getString(1));
            vmb.setMacb(cursor.getString(2));
            vmb.setManv(cursor.getString(3));
            vmb.setTennv(cursor.getString(4));
            vmb.setMakh(cursor.getString(5));
            vmb.setTenkh(cursor.getString(6));
            vmb.setDiemdi(cursor.getString(7));
            vmb.setDiemden(cursor.getString(8));
            vmb.setTimebay(cursor.getString(9));
            vmb.setTimedatve(cursor.getString(10));
            vmb.setTrangthai(cursor.getInt(11));
            list.add(vmb);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public boolean addVMB(VeMB vmb) {
        dtb = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("macb", vmb.getMacb());
        values.put("manv", vmb.getManv());
        values.put("makh", vmb.getMakh());
        values.put("timedatve", vmb.getTimedatve());
        values.put("trangthai", vmb.getTrangthai());
        if(dtb.insert("VEMAYBAY", null, values) <0 ) {
            return false;
        }
        return true;
    }

    public ArrayList<VeMB> getVMBtheoNV(String manv, int status) {
        ArrayList<VeMB> list = new ArrayList<>();
        dtb = sql.getReadableDatabase();
        Cursor cursor = dtb.rawQuery("select vmb.mavmb, cb.mamb, cb.macb,nv.manv, nv.tennv,kh.makh, kh.tenkh, cb.diemdi, cb.diemden, cb.timebay, vmb.timedatve, vmb.trangthai\n" +
                "from CHUYENBAY cb , KHACHHANG kh , NHANVIEN nv, VEMAYBAY vmb \n" +
                "where vmb.macb = cb.macb and vmb.manv = nv.manv and vmb.makh = kh.makh and nv.manv = ? and vmb.trangthai = ?", new String[] {manv, String.valueOf(status)});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            VeMB vmb = new VeMB();
            vmb.setMavmb(cursor.getInt(0));
            vmb.setMamb(cursor.getString(1));
            vmb.setMacb(cursor.getString(2));
            vmb.setManv(cursor.getString(3));
            vmb.setTennv(cursor.getString(4));
            vmb.setMakh(cursor.getString(5));
            vmb.setTenkh(cursor.getString(6));
            vmb.setDiemdi(cursor.getString(7));
            vmb.setDiemden(cursor.getString(8));
            vmb.setTimebay(cursor.getString(9));
            vmb.setTimedatve(cursor.getString(10));
            vmb.setTrangthai(cursor.getInt(11));
            list.add(vmb);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public ArrayList<VeMB> getVMBtheoKH(String email, int status) {
        ArrayList<VeMB> list = new ArrayList<>();
        dtb = sql.getReadableDatabase();
        Cursor cursor = dtb.rawQuery("select vmb.mavmb, cb.mamb, cb.macb,nv.manv, nv.tennv,kh.makh, kh.tenkh, cb.diemdi, cb.diemden, cb.timebay, vmb.timedatve, vmb.trangthai\n" +
                "from CHUYENBAY cb , KHACHHANG kh , NHANVIEN nv, VEMAYBAY vmb \n" +
                "where vmb.macb = cb.macb and vmb.manv = nv.manv and vmb.makh = kh.makh and kh.email = ? and vmb.trangthai = ?", new String[] {email, String.valueOf(status)});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            VeMB vmb = new VeMB();
            vmb.setMavmb(cursor.getInt(0));
            vmb.setMamb(cursor.getString(1));
            vmb.setMacb(cursor.getString(2));
            vmb.setManv(cursor.getString(3));
            vmb.setTennv(cursor.getString(4));
            vmb.setMakh(cursor.getString(5));
            vmb.setTenkh(cursor.getString(6));
            vmb.setDiemdi(cursor.getString(7));
            vmb.setDiemden(cursor.getString(8));
            vmb.setTimebay(cursor.getString(9));
            vmb.setTimedatve(cursor.getString(10));
            vmb.setTrangthai(cursor.getInt(11));
            list.add(vmb);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
