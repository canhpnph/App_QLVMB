package com.example.da1_group6.ui_user;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.da1_group6.R;
import com.example.da1_group6.adapter.Adapter_Recycler_LSGD;
import com.example.da1_group6.dao.DAO_HoaDonNapTien;
import com.example.da1_group6.dao.DAO_KhachHang;
import com.example.da1_group6.dao.DAO_LSGD;
import com.example.da1_group6.model.HoaDonNapTien;
import com.example.da1_group6.model.KhachHang;
import com.example.da1_group6.model.LSGD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Fragment_Wallet_user extends Fragment {
    LinearLayout btn_naptien;
    TextView tvsodu;
    DAO_KhachHang dao;
    KhachHang kh;
    ArrayList<KhachHang> list;
    RecyclerView recyclerView;
    Adapter_Recycler_LSGD adapter;
    ArrayList<LSGD> list_lsgd;
    DAO_LSGD dao_lsgd;
    TextView tv_no_result;
    ImageView img;
    int makh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wallet_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_naptien = view.findViewById(R.id.btn_naptien);
        tvsodu = view.findViewById(R.id.tv_sodu);
        recyclerView = view.findViewById(R.id.recyclerview_lsgd);
        tv_no_result = view.findViewById(R.id.tv_no_result_lsgd);
        img = view.findViewById(R.id.img_sad_lsgd);

        SharedPreferences preferences = getActivity().getSharedPreferences("TB", Context.MODE_PRIVATE);
        String email = preferences.getString("User", "");

        dao = new DAO_KhachHang(getContext());
        list = dao.getUser(email);
        kh = list.get(0);

        makh = kh.getMakh();
        reload();

        if (list_lsgd.isEmpty()) {
            tv_no_result.setText("Hmm...Bạn chưa có giao dịch nào !!!  ");
            img.setImageResource(R.drawable.img_sad);
        } else {
            tv_no_result.setText("");
            img.setImageDrawable(null);
        }

        tvsodu.setText(String.valueOf(kh.getSodu()));

        btn_naptien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog_naptien();
            }
        });
    }

    public void showDialog_naptien() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View custom = inflater.inflate(R.layout.layout_naptien, null, false);

        EditText edt_sotiennap = custom.findViewById(R.id.edt_sotiennap);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(custom);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (edt_sotiennap.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    HoaDonNapTien hd = new HoaDonNapTien();
                    DAO_HoaDonNapTien dao = new DAO_HoaDonNapTien(getContext());

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String time = format.format(Calendar.getInstance().getTime());

                    dao.addHD(new HoaDonNapTien(hd.getId(), kh.getMakh(), Integer.parseInt(edt_sotiennap.getText().toString()), time, 0));
                    Toast.makeText(getContext(), "Bạn vừa gửi yêu cầu nạp tiền với số tiền là " + edt_sotiennap.getText().toString() + " vnd. Vui lòng chờ admin xác nhận!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void reload() {
        dao_lsgd = new DAO_LSGD(getContext());
        list_lsgd = dao_lsgd.getAllLSGD(makh);
        adapter = new Adapter_Recycler_LSGD(list_lsgd, getContext());
        recyclerView.setAdapter(adapter);
    }
}