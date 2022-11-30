package com.example.da1_group6.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.da1_group6.R;
import com.example.da1_group6.dao.DAO_KhachHang;
import com.example.da1_group6.dao.DAO_VeMB;
import com.example.da1_group6.model.ChuyenBay;
import com.example.da1_group6.model.KhachHang;
import com.example.da1_group6.model.VeMB;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Adapter_Recycler_BookVe_user extends RecyclerView.Adapter<Adapter_Recycler_BookVe_user.ViewHolder> {
    ArrayList<ChuyenBay> list;
    Context context;
    int giave = 0;
    String mamb, macb, manv, makh;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.layout_item1_bookve, parent, false));
    }

    public Adapter_Recycler_BookVe_user(ArrayList<ChuyenBay> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuyenBay cb = list.get(position);

        if (cb.getMamb().equalsIgnoreCase("VNA")) {
            holder.img.setImageResource(R.drawable.logo_vnairlines);
        } else if (cb.getMamb().equalsIgnoreCase("VJA")) {
            holder.img.setImageResource(R.drawable.logo_vietjet);
        } else if (cb.getMamb().equalsIgnoreCase("BBA")) {
            holder.img.setImageResource(R.drawable.logo_bamboo);
        }

        holder.tvmacb.setText("Mã chuyến bay: " + cb.getMacb());
        holder.tvfrom.setText("From: " + cb.getDiemdi());
        holder.tvto.setText("To: " + cb.getDiemden());
        holder.tvtimebay.setText(cb.getTimebay());
        holder.tvgiave.setText(String.valueOf(cb.getGiave()) + " Đ");


        SharedPreferences preferences = context.getSharedPreferences("TB", Context.MODE_PRIVATE);
        String email = preferences.getString("User", "");
        DAO_KhachHang dao_user = new DAO_KhachHang(context);
        ArrayList<KhachHang> list = dao_user.getUser(email);
        KhachHang kh = list.get(0);

        holder.btn_bookve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                macb = cb.getMacb();
                mamb = cb.getMamb();
                makh = kh.getMakh();

                if (mamb.equals("VNA")) {
                    manv = "NV01";
                } else if (mamb.equals("VJA")) {
                    manv = "NV02";
                } else if (mamb.equals("BBA")) {
                    manv = "NV03";
                }
                giave = cb.getGiave();

                Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_confirm_bookve);
                dialog.show();

                TextView tv_confirm = dialog.findViewById(R.id.tv_notice_confirm_bookve);
                TextView btn_cancel = dialog.findViewById(R.id.btnCancel_confirm_bookve);
                TextView btn_confirm = dialog.findViewById(R.id.btn_confirm_bookve);

                tv_confirm.setText("Xác nhận thanh toán " + giave + " Đ?");
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btn_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DAO_VeMB dao = new DAO_VeMB(context);
                        VeMB vmb = new VeMB();

                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        String date = format.format(Calendar.getInstance().getTime());

                        dao.addVMB(new VeMB(vmb.getMavmb(), mamb, macb, manv, makh, date, 0));
                        holder.btn_bookve.setText("Đã đặt vé");
                        holder.btn_bookve.setEnabled(false);
                        holder.btn_bookve.setTextColor(Color.WHITE);
                        dialog.dismiss();
                    }
                });

                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvmacb, tvfrom, tvto, tvtimebay, tvgiave;
        Button btn_bookve;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.logo_mb_it1_bookve);
            tvmacb = itemView.findViewById(R.id.tv_macb_bookve);
            tvfrom = itemView.findViewById(R.id.tv_from_bookve);
            tvto = itemView.findViewById(R.id.tv_to_bookve);
            tvtimebay = itemView.findViewById(R.id.tv_timebay_bookve);
            btn_bookve = itemView.findViewById(R.id.btn_datve);
            tvgiave = itemView.findViewById(R.id.tv_giave_bookve);
        }
    }

}
