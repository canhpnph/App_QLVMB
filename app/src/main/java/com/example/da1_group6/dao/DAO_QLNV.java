package com.example.da1_group6.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.da1_group6.database.SQLite;
import com.example.da1_group6.model.NhanVien;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DAO_QLNV {
    SQLite sql;
    SQLiteDatabase dtb;
    ByteArrayOutputStream outputStream;
    byte[] imageByte;

    public DAO_QLNV(Context context) {
        sql = new SQLite(context);
    }

    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> list = new ArrayList<>();
        dtb = sql.getReadableDatabase();
        Cursor cursor = dtb.rawQuery("select * from NHANVIEN", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            NhanVien nv = new NhanVien();
            nv.setManv(cursor.getString(0));
            nv.setTennv(cursor.getString(1));
            nv.setEmail(cursor.getString(2));
            nv.setGioitinh(cursor.getInt(3));
            nv.setQuoctich(cursor.getString(4));
            nv.setChucvu(cursor.getString(5));
            nv.setMatkhau(cursor.getString(6));

            Bitmap bitmap = null;
            byte[] imageByte = cursor.getBlob(7);
            bitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
            nv.setImage(bitmap);

            list.add(nv);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
