package com.example.da1_group6.ui_user;

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

import com.example.da1_group6.R;
import com.example.da1_group6.adapter.Adapter_Recycler_VeMB_dxn_user;
import com.example.da1_group6.dao.DAO_VeMB;
import com.example.da1_group6.model.VeMB;

import java.util.ArrayList;


public class Fragment_Ve_daXN extends Fragment {
    RecyclerView recyclerView;
    DAO_VeMB dao;
    ArrayList<VeMB> list;
    Adapter_Recycler_VeMB_dxn_user adapter;
    String email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__ve_daxn, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_vmb_dxn);

        SharedPreferences preferences = getActivity().getSharedPreferences("TB", Context.MODE_PRIVATE);
        email = preferences.getString("User", "");
        reload();

    }

    @Override
    public void onResume() {
        super.onResume();
        reload();
    }

    private void reload() {
        dao = new DAO_VeMB(getContext());
        list = dao.getVMBtheoKH(email, 1);
        adapter = new Adapter_Recycler_VeMB_dxn_user(list, getContext());
        recyclerView.setAdapter(adapter);
    }
}