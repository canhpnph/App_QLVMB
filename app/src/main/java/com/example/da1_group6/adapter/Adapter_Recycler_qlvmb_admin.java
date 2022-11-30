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

public class Adapter_Recycler_qlvmb_admin extends RecyclerView.Adapter<Adapter_Recycler_qlvmb_admin.ViewHolder> {
    ArrayList<VeMB> list;
    Context context;

    public Adapter_Recycler_qlvmb_admin(ArrayList<VeMB> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.layout_item1_qlvmb_admin, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VeMB vmb = list.get(position);

        if(vmb.getMamb().equalsIgnoreCase("VNA")) {
            holder.logo.setImageResource(R.drawable.logo_vnairlines);
        } else if (vmb.getMamb().equalsIgnoreCase("VJA")) {
            holder.logo.setImageResource(R.drawable.logo_vietjet);
        } else if (vmb.getMamb().equalsIgnoreCase("BBA")) {
            holder.logo.setImageResource(R.drawable.logo_bamboo);
        }

        holder.tvmacb.setText("Mã chuyến bay: " + vmb.getMacb());
        holder.tvfrom.setText("From: " + vmb.getDiemdi());
        holder.tvto.setText("To: " + vmb.getDiemden());
        holder.tvtimebay.setText(vmb.getTimebay());
        holder.tvtenkh.setText("Họ tên: " + vmb.getTenkh());

        int status = vmb.getTrangthai();
        if(status == 0) {
            holder.status.setMaxHeight(40);
            holder.status.setMaxWidth(40);
            holder.status.setImageResource(R.drawable.ic_close);
        } else {
            holder.status.setImageResource(R.drawable.ic_tick);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logo, status;
        TextView tvmacb, tvfrom, tvto, tvtimebay, tvtenkh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo_mb_qlvmb_admin);
            tvmacb = itemView.findViewById(R.id.tv_macb_qlvmb_admin);
            tvfrom = itemView.findViewById(R.id.tv_from_qlvmb_admin);
            tvto = itemView.findViewById(R.id.tv_to_qlvmb_admin);
            tvtimebay = itemView.findViewById(R.id.tv_timebay_qlvmb_admin);
            tvtenkh = itemView.findViewById(R.id.tv_hoten_qlvmb_admin);
            status = itemView.findViewById(R.id.img_status);
        }
    }
}
