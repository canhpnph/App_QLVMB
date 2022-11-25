package com.example.da1_group6.ui_admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.da1_group6.R;
import com.example.da1_group6.adapter.Adapter_Recycler_Chuyenbay;
import com.example.da1_group6.dao.DAO_ChuyenBay;
import com.example.da1_group6.model.ChuyenBay;

import java.util.ArrayList;

public class Fragment_ChuyenBay_admin extends Fragment {
    RecyclerView recyclerView;
    DAO_ChuyenBay dao;
    Adapter_Recycler_Chuyenbay adapter;
    ArrayList<ChuyenBay> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__chuyen_bay_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_chuyenbay);
        dao = new DAO_ChuyenBay(getContext());
        list = dao.getAll();
        adapter = new Adapter_Recycler_Chuyenbay(list, getContext());
        recyclerView.setAdapter(adapter);
    }
}