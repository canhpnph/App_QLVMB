package com.example.da1_group6.ui_user;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.da1_group6.R;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Fragment_BookVe_user extends Fragment {
    Spinner spin_from, spin_to, spin_hangmb;
    Button btn_search_chuyenbay, btn_datve;
    ImageView choose_day;
    TextView tv_date;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_ve_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spin_from = view.findViewById(R.id.spin_from);
        spin_to = view.findViewById(R.id.spin_to);
        spin_hangmb = view.findViewById(R.id.spin_hangBay);
        btn_search_chuyenbay = view.findViewById(R.id.btn_search_chuyenbay);
        choose_day = view.findViewById(R.id.img_date_bookve_user);
        tv_date = view.findViewById(R.id.tv_date_bookve_user);
        btn_datve = view.findViewById(R.id.btn_datve);

        String[] list = {"Hà Nội", "Hải Phòng", "Đà Nẵng", "Nha Trang", "TP HCM", "Phú Quốc"};
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        spin_from.setAdapter(adapter);
        spin_to.setAdapter(adapter);

        String[] list1 = {"Vietnam Airlines", "VietJet Airs", "Bamboo Airways"};
        ArrayAdapter adapter1 = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list1);
        spin_hangmb.setAdapter(adapter1);

        choose_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_from();
            }
        });

        btn_datve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog_Confirm();
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

    public void showDialog_Confirm() {
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm_bookve);
        dialog.show();

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}