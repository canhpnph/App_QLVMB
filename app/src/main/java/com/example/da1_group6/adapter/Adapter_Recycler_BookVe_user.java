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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.da1_group6.R;
import com.example.da1_group6.dao.DAO_KhachHang;
import com.example.da1_group6.dao.DAO_LSGD;
import com.example.da1_group6.dao.DAO_VeMB;
import com.example.da1_group6.model.ChuyenBay;
import com.example.da1_group6.model.KhachHang;
import com.example.da1_group6.model.LSGD;
import com.example.da1_group6.model.VeMB;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Adapter_Recycler_BookVe_user extends RecyclerView.Adapter<Adapter_Recycler_BookVe_user.ViewHolder> {
    ArrayList<ChuyenBay> list;
    Context context;
    int giave = 0;
    String mamb, macb, manv;
    int makh;

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

        String giavestr = String.valueOf(cb.getGiave());
        StringBuilder str_giave = new StringBuilder(giavestr);
        for (int i = str_giave.length(); i > 0; i -= 3) {
            str_giave.insert(i, " ");
        }

        holder.tvgiave.setText(str_giave + " Đ");


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

                String giave_string = String.valueOf(giave);
                StringBuilder str_giave1 = new StringBuilder(giave_string);
                for (int i = str_giave1.length(); i > 0; i -= 3) {
                    str_giave1.insert(i, " ");
                }

                Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_confirm_bookve);
                dialog.show();

                TextView tv_confirm = dialog.findViewById(R.id.tv_notice_confirm_bookve);
                TextView btn_cancel = dialog.findViewById(R.id.btnCancel_confirm_bookve);
                TextView btn_confirm = dialog.findViewById(R.id.btn_confirm_bookve);

                tv_confirm.setText("Xác nhận thanh toán " + str_giave1 + " Đ?");
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

                        int sodu = kh.getSodu();

                        if(sodu < cb.getGiave()) {
                            Toast.makeText(context, "Số dư của bạn không đủ. Vui lòng nạp thêm tiền để tiếp tục sử dụng dịch vụ!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            return;
                        } else {
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String date = format.format(Calendar.getInstance().getTime());

                            dao.addVMB(new VeMB(vmb.getMavmb(), mamb, macb, manv, makh, date, 0));
                            holder.btn_bookve.setText("Đã đặt vé");
                            holder.btn_bookve.setEnabled(false);
                            holder.btn_bookve.setTextColor(Color.WHITE);

                            Toast.makeText(context, "Đặt vé thành công!", Toast.LENGTH_SHORT).show();
                            int sodu_after = sodu - cb.getGiave();
                            dao_user.update_Tien(new KhachHang(kh.getMakh(), kh.getTenkh(), kh.getNgaysinh(), kh.getEmail(), kh.getSdt(), kh.getCccd(), kh.getGioitinh(),
                                    kh.getDiachi(), kh.getQuoctich(), kh.getMatkhau(), kh.getImage(), sodu_after));

                            DAO_LSGD dao_lsgd = new DAO_LSGD(context);
                            LSGD ls = new LSGD();
                            dao_lsgd.addLS(new LSGD(ls.getId(), kh.getMakh(), "Mua vé máy bay", cb.getGiave(), date));
                            dialog.dismiss();
                        }
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
