package com.example.da1_group6.ui_staff;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.da1_group6.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fragment_Doanhthu_staff extends Fragment {
    TextView tv_datefrom, tv_dateto;
    ImageView imgdatefrom, imgdateto;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doanhthu_staff, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_datefrom = view.findViewById(R.id.tv_datefrom_doanhthu_staff);
        tv_dateto = view.findViewById(R.id.tv_dateto_doanhthu_staff);
        imgdatefrom = view.findViewById(R.id.img_date_from_doanhthu_staff);
        imgdateto = view.findViewById(R.id.img_date_to_doanhthu_staff);

        imgdatefrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_from();
            }
        });


        imgdateto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_to();
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
                        tv_datefrom.setText(format.format(calendar.getTime()));
                        if(!tv_datefrom.getText().toString().equals("")) {
                            //    show();
                        }
                        if(tv_datefrom.getText().toString().compareTo(tv_dateto.getText().toString()) >0 && !tv_dateto.getText().toString().equals("")) {
                            Toast.makeText(getContext(), "Ngày bắt đầu phải nhỏ hơn ngày kết thúc", Toast.LENGTH_SHORT).show();
                            //    tvTien.setText("");
                        }
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );
        dialog.show();
    }

    public void date_to() {
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
                        tv_dateto.setText(format.format(calendar.getTime()));
                        if(!tv_datefrom.getText().toString().equals("")) {
                            //    show();
                        }
                        if(tv_dateto.getText().toString().compareTo(tv_datefrom.getText().toString()) <0) {
                            Toast.makeText(getContext(), "Ngày kết thúc phải lớn hơn ngày bắt đầu", Toast.LENGTH_SHORT).show();
                            //    tvTien.setText("");
                        }
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
        tv_datefrom.setText("Từ ngày");
        tv_dateto.setText("Đến ngày");
    }
}