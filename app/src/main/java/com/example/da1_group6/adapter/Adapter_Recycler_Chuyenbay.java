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
import com.example.da1_group6.model.ChuyenBay;

import java.util.ArrayList;

public class Adapter_Recycler_Chuyenbay extends RecyclerView.Adapter<Adapter_Recycler_Chuyenbay.ViewHolder> {
    ArrayList<ChuyenBay> list;
    Context context;

    public Adapter_Recycler_Chuyenbay(ArrayList<ChuyenBay> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_Recycler_Chuyenbay.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.layout_item1_chuyenbay_admin, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Recycler_Chuyenbay.ViewHolder holder, int position) {
        ChuyenBay cb = list.get(position);

        if(cb.getMamb().equalsIgnoreCase("VNA")) {
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
        holder.tvtongtime.setText(cb.getTongtime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvmacb, tvfrom, tvto, tvtimebay, tvtongtime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.logo_mb_chuyenbay);
            tvmacb = itemView.findViewById(R.id.tv_macb);
            tvfrom = itemView.findViewById(R.id.tv_from_it1_cb_admin);
            tvto = itemView.findViewById(R.id.tv_to_it1_cb_admin);
            tvtimebay = itemView.findViewById(R.id.tv_timebay);
            tvtongtime = itemView.findViewById(R.id.tv_tongtime_cb_admin);
        }
    }
}
