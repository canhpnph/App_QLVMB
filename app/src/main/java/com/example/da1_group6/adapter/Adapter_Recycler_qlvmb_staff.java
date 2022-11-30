package com.example.da1_group6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.da1_group6.R;
import com.example.da1_group6.model.VeMB;

import java.util.ArrayList;

public class Adapter_Recycler_qlvmb_staff extends RecyclerView.Adapter<Adapter_Recycler_qlvmb_staff.ViewHolder> {
    ArrayList<VeMB> list;
    Context context;

    public Adapter_Recycler_qlvmb_staff(ArrayList<VeMB> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.layout_item1_qlvmb_staff, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VeMB vmb = list.get(position);

        if(vmb.getMamb().equalsIgnoreCase("VNA")) {
            holder.img.setImageResource(R.drawable.logo_vnairlines);
        } else if (vmb.getMamb().equalsIgnoreCase("VJA")) {
            holder.img.setImageResource(R.drawable.logo_vietjet);
        } else if (vmb.getMamb().equalsIgnoreCase("BBA")) {
            holder.img.setImageResource(R.drawable.logo_bamboo);
        }

        holder.tvmacb.setText("Mã chuyến bay: " + vmb.getMacb());
        holder.tvfrom.setText("From: " + vmb.getDiemdi());
        holder.tvto.setText("To: " + vmb.getDiemden());
        holder.tvtimebay.setText(vmb.getTimebay());
        holder.tvtenkh.setText("Họ tên: " + vmb.getTenkh());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvmacb, tvfrom, tvto, tvtimebay, tvtenkh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.logo_mb_qlvmb_staff);
            tvmacb = itemView.findViewById(R.id.tv_macb_qlvmb_staff);
            tvfrom = itemView.findViewById(R.id.tv_from_qlvmb_staff);
            tvto = itemView.findViewById(R.id.tv_to_qlvmb_staff);
            tvtimebay = itemView.findViewById(R.id.tv_timebay_qlvmb_staff);
            tvtenkh = itemView.findViewById(R.id.tv_hoten_qlvmb_staff);
        }
    }
}
