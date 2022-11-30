package com.example.da1_group6.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {

    public SQLite(Context context) {
        super(context, "DTB_DA1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tb_hmb = "create table HANGMAYBAY (mamb text primary key, tenmb text)";
        String tb_cb = "create table CHUYENBAY (macb text primary key, diemdi text, diemden text, giave integer, timebay text, mamb text, foreign key (mamb) references HANGMAYBAY(mamb))";
        String tb_nv = "create table NHANVIEN (manv text primary key, tennv text, email text, sdt text, gioitinh integer, quoctich integer, chucvu text, matkhau text, image blob)";
        String tb_kh = "create table KHACHHANG (makh integer primary key autoincrement, tenkh text, ngaysinh text, email text, sdt text, cccd text, gioitinh integer, diachi text, quoctich integer, matkhau text, image blob, sodu integer)";
        String tb_vmb = "create table VEMAYBAY (mavmb integer primary key autoincrement, macb text, manv text, makh text, timedatve text, trangthai integer, foreign key (macb) references CHUYENBAY(macb)," +
                "foreign key (manv) references NHANVIEN(manv), foreign key (makh) references KHACHHANG(makh))";
        String tb_admin = "create table ADMIN (user text primary key, pass text)";

        db.execSQL(tb_hmb);
        db.execSQL(tb_cb);
        db.execSQL(tb_nv);
        db.execSQL(tb_kh);
        db.execSQL(tb_vmb);
        db.execSQL(tb_admin);

        String itemhmb = "insert into HANGMAYBAY values ('VNA', 'Vietnam Airlines'), ('VJA', 'VietJet Airs'), ('BBA', 'Bamboo Airways')";
        String itemnv = "insert into NHANVIEN values ('NV01', 'Trần Kim Ngân', '','', '', '', 'NVQL hãng máy bay Vietnam Airlines', 'a',''), ('NV02', 'Nguyễn Đức Duy', '','', '', '', 'NVQL hãng máy bay VietJet Airs', 'a',''), ('NV03', 'Bùi Minh Hiếu', '','', '', '', 'NVQL hãng máy bay Bamboo Airways', 'a','')";
        String itemcb = "insert into CHUYENBAY values ('VNA1092','Hà Nội', 'Đà Nẵng', 2700000, '12:20 30/11/2022', 'VNA')," +
                "('VNA5392','Hà Nội', 'TP. HCM', 6650000, '08:00 28/11/2022', 'VNA')," +
                "('VNA1044','Đà Nẵng', 'Phú Quốc', 3890000, '19:30 03/12/2022', 'VNA')," +
                "('VNA2037','Đà Nẵng', 'Hà Nội', 2800000, '15:30 29/11/2022', 'VNA')," +
                "('VJA5473','Hà Nội', 'Đà Nẵng', 2400000, '10:00 30/11/2022', 'VJA')," +
                "('VJA0039','Hà Nội', 'TP. HCM', 5750000, '05:40 01/12/2022', 'VJA')," +
                "('VJA9982','Hải Phòng', 'Phú Quốc', 7600000, '19:15 05/11/2022', 'VJA')," +
                "('VJA3800','Đà Nẵng', 'Hà Nội', 2800000, '21:45 29/11/2022', 'VJA')," +
                "('BBA2433','Hà Nội', 'Đà Nẵng', 3100000, '15:00 29/11/2022', 'BBA')," +
                "('BBA0623','Đà Nẵng', 'Hà Nội', 3300000, '16:45 30/11/2022', 'BBA')," +
                "('BBA8112','Hà Nội', 'TP. HCM', 6450000, '20:20 30/11/2022', 'BBA')," +
                "('BBA0001','TP. HCM', 'Hà Nội', 6700000, '09:40 01/12/2022', 'BBA')";
        String itemadmin = "insert into ADMIN values ('admin', 'admin')";

        db.execSQL(itemhmb);
        db.execSQL(itemnv);
        db.execSQL(itemcb);
        db.execSQL(itemadmin);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists HANGMAYBAY");
        db.execSQL("drop table if exists CHUYENBAY");
        db.execSQL("drop table if exists NHANVIEN");
        db.execSQL("drop table if exists KHACHHANG");
        db.execSQL("drop table if exists VEMAYBAY");
        db.execSQL("drop table if exists ADMIN");
    }
}
