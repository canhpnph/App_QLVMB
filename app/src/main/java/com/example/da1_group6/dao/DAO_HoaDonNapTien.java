package com.example.da1_group6.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.da1_group6.database.SQLite;
import com.example.da1_group6.model.HoaDonNapTien;

import java.util.ArrayList;

public class DAO_HoaDonNapTien {
    SQLite sql;
    SQLiteDatabase dtb;

    public DAO_HoaDonNapTien(Context context) {
        sql = new SQLite(context);
    }

    public ArrayList<HoaDonNapTien> getAllHoaDon() {
        ArrayList<HoaDonNapTien> list = new ArrayList<>();
        dtb = sql.getReadableDatabase();
        Cursor cursor = dtb.rawQuery("select hd.id, kh.makh, kh.tenkh, hd.sotiennap, hd.timenap, hd.trangthai from HOADONNAPTIEN hd, KHACHHANG kh where hd.makh = kh.makh order by hd.id desc", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            HoaDonNapTien hd = new HoaDonNapTien();
            hd.setId(cursor.getInt(0));
            hd.setMakh(cursor.getInt(1));
            hd.setHotenkh(cursor.getString(2));
            hd.setSotiennap(cursor.getInt(3));
            hd.setTimenap(cursor.getString(4));
            hd.setTrangthai(cursor.getInt(5));
            list.add(hd);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public boolean addHD(HoaDonNapTien hd) {
        dtb = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("makh", hd.getMakh());
        values.put("sotiennap", hd.getSotiennap());
        values.put("timenap", hd.getTimenap());
        values.put("trangthai", hd.getTrangthai());

        if (dtb.insert("HOADONNAPTIEN", null, values) < 0) {
            return false;
        }
        return true;
    }

    public boolean updHD(HoaDonNapTien hd) {
        dtb = sql.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("trangthai", hd.getTrangthai());

        if(dtb.update("HOADONNAPTIEN", values, "id = ?", new String[]{String.valueOf(hd.getId())} ) <0) {
            return false;
        }
        return true;
    }
}
