package com.example.da1_group6;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.example.da1_group6.dao.DAO_KhachHang;
import com.example.da1_group6.model.KhachHang;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.res.ResourcesCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.da1_group6.databinding.ActivityForUserBinding;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ForUserActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityForUserBinding binding;
    DAO_KhachHang dao;
    ArrayList<KhachHang> list;
    KhachHang kh;
    TextView tv_hello, sodu;
    CircleImageView avatar;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarForUser.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_dsve_user, R.id.nav_datve_user, R.id.nav_info_user, R.id.nav_wallet_user, R.id.nav_doimk_user)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_for_user);
        navigationView.setItemIconTintList(null);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                if(navDestination.getId() == R.id.nav_thoat) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ForUserActivity.this);
                    builder.setTitle("Thông báo");
                    builder.setMessage("Bạn có chắc là muốn đăng xuất không?");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ProgressDialog dialog1 = new ProgressDialog(ForUserActivity.this);
                            dialog1.setMessage("Đang đăng xuất...");
                            dialog1.show();
                            Thread thread = new Thread() {
                                @Override
                                public void run() {
                                    super.run();
                                    try {
                                        sleep(1444);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    } finally {
                                        finish();
                                    }
                                }
                            };
                            thread.start();
                        }
                    });

                    builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        View viewheader = navigationView.getHeaderView(0);
        tv_hello = (TextView) viewheader.findViewById(R.id.tv_hello_user);
        avatar = (CircleImageView) viewheader.findViewById(R.id.avatar_inheader_user);
        sodu = (TextView) viewheader.findViewById(R.id.sodu_in_header);

        SharedPreferences preferences = getSharedPreferences("TB", Context.MODE_PRIVATE);
        email = preferences.getString("User", "");

        reloadData(email);

        if(kh.getImage() == null) {
            avatar.setImageResource(R.drawable.img_avatar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_for_user);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    protected void onResume() {
        super.onResume();
        reloadData(email);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    public void reloadData(String email) {
        dao = new DAO_KhachHang(this);
        list = dao.getUser(email);
        kh = list.get(0);

        tv_hello.setText("Xin chào, \n" + kh.getTenkh());
        avatar.setImageBitmap(kh.getImage());
        sodu.setText("Số dư: " + kh.getSodu() + " vnđ");
    }

}