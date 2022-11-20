package com.example.da1_group6.ui_user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.da1_group6.R;

public class Fragment_Info_user extends Fragment {
    Spinner spin_sex, spin_quoctich;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__info_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spin_quoctich = view.findViewById(R.id.spin_quoctich_user);
        spin_sex = view.findViewById(R.id.spin_sex_user);

        String[] list1 = {"Nam", "Nữ", "Khác"};
        String[] list2 = {"Việt Nam", "Hàn Quốc", "Nhật Bản"};

        ArrayAdapter adapter1 = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list1);
        spin_sex.setAdapter(adapter1);

        ArrayAdapter adapter2 = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list2);
        spin_quoctich.setAdapter(adapter2);
    }
}