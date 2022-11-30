package com.example.da1_group6.ui_staff;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.da1_group6.R;
import com.example.da1_group6.adapter.Adapter_Recycler_qlvmb_staff;
import com.example.da1_group6.dao.DAO_VeMB;
import com.example.da1_group6.model.VeMB;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Fragment_QLVMB_staff extends Fragment {
    ImageView img_date;
    TextView tv_date;
    RecyclerView recyclerView;
    DAO_VeMB dao;
    ArrayList<VeMB> list;
    Adapter_Recycler_qlvmb_staff adapter;
    String user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_qlvmb_staff, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img_date = view.findViewById(R.id.img_date_qlvmb_staff);
        tv_date = view.findViewById(R.id.tv_date_qlvmb_staff);
        recyclerView = view.findViewById(R.id.recyclerview_qlvmb_staff);

        SharedPreferences preferences = getActivity().getSharedPreferences("TB", Context.MODE_PRIVATE);
        user = preferences.getString("User", "");

        reload();

        img_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_from();
            }
        });
    }

    public void date_from() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        DatePickerDialog dialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        int nam = i;
                        int thang = i1;
                        int ngay = i2;
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        calendar.set(nam,thang,ngay);
                        tv_date.setText(format.format(calendar.getTime()));
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );
        dialog.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        reload();
    }

    void reload() {
        dao = new DAO_VeMB(getContext());
        list = dao.getVMBtheoNV(user, 1);
        adapter = new Adapter_Recycler_qlvmb_staff(list, getContext());
        recyclerView.setAdapter(adapter);
    }
}