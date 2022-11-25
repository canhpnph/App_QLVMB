package com.example.da1_group6.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.da1_group6.database.SQLite;
import com.example.da1_group6.model.ChuyenBay;
import com.example.da1_group6.model.HangMB;

import java.util.ArrayList;

public class DAO_ChuyenBay {
    SQLite sql;
    SQLiteDatabase dtb;

    public DAO_ChuyenBay(Context context) {
        sql = new SQLite(context);
    }
//dcm
    public ArrayList<ChuyenBay> getAll() {
        ArrayList<ChuyenBay> list = new ArrayList<>();
        dtb = sql.getReadableDatabase();
        Cursor cursor = dtb.rawQuery("select * from CHUYENBAY", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ChuyenBay cb = new ChuyenBay();
            cb.setMacb(cursor.getString(0));
            cb.setDiemdi(cursor.getString(1));
            cb.setDiemden(cursor.getString(2));
            cb.setGiave(cursor.getInt(3));
            cb.setTimebay(cursor.getString(4));
            cb.setMamb(cursor.getString(5));
            list.add(cb);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
