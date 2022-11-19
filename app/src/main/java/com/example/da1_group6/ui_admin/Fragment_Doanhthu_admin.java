package com.example.da1_group6.ui_admin;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.da1_group6.R;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fragment_Doanhthu_admin extends Fragment {
    TextView tv_datefrom, tv_dateto;
    ImageView imgdatefrom, imgdatefrom2, imgdateto, imgdateto2;
    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doanhthu_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_datefrom = view.findViewById(R.id.tv_datefrom);
        tv_dateto = view.findViewById(R.id.tv_dateto);
        imgdatefrom = view.findViewById(R.id.img_date_from);
        imgdatefrom2 = view.findViewById(R.id.img_date_from2);
        imgdateto = view.findViewById(R.id.img_date_to);
        imgdateto2 = view.findViewById(R.id.img_date_to2);
        spinner = view.findViewById(R.id.spinner);

        imgdatefrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_from();
            }
        });

        imgdatefrom2.setOnClickListener(new View.OnClickListener() {
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

        imgdateto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_to();
            }
        });

        String[] list = {"Tất cả nhân viên", "ABC - NV01", "XYZ - NV02", "IJK - NV03"};
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,list);
        spinner.setAdapter(adapter);
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