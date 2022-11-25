package com.example.da1_group6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.da1_group6.R;
import com.example.da1_group6.dao.DAO_QLNV;
import com.example.da1_group6.model.NhanVien;

import java.util.ArrayList;

public class Adapter_Recycler_qlnv extends RecyclerView.Adapter<Adapter_Recycler_qlnv.ViewHolder> {
    ArrayList<NhanVien> list;
    Context context;

    public Adapter_Recycler_qlnv(ArrayList<NhanVien> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_Recycler_qlnv.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.layout_item1_qlynhanvien, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Recycler_qlnv.ViewHolder holder, int position) {
        NhanVien nv = list.get(position);

        holder.tvmanv.setText("#" + nv.getManv());
        holder.tvtennv.setText("Họ tên: " + nv.getTennv());
        holder.tvchucvu.setText("Chức vụ: " + nv.getChucvu());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvmanv, tvtennv, tvchucvu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvmanv = itemView.findViewById(R.id.tv_manv);
            tvtennv = itemView.findViewById(R.id.tv_name_staff);
            tvchucvu = itemView.findViewById(R.id.tv_chucvu_staff);
        }
    }
}
