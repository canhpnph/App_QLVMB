package com.example.da1_group6;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

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

import com.example.da1_group6.databinding.ActivityForStaffBinding;

public class ForStaffActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityForStaffBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForStaffBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarForStaff.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        binding.appBarForStaff.toolbar.post(new Runnable() {
            @Override
            public void run() {
                Drawable draw = ResourcesCompat.getDrawable(getResources(), R.drawable.img_menu_resize, null);
                binding.appBarForStaff.toolbar.setNavigationIcon(draw);
            }
        });

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_qlyvemb_staff, R.id.nav_xnvemb_staff, R.id.nav_doanhthu_staff, R.id.nav_user_staff, R.id.nav_doimk_staff)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_for_staff);

        navigationView.setItemIconTintList(null);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                if(navDestination.getId() == R.id.nav_thoat) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ForStaffActivity.this);
                    builder.setTitle("Thông báo");
                    builder.setMessage("Bạn có chắc là muốn đăng xuất không?");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ProgressDialog dialog1 = new ProgressDialog(ForStaffActivity.this);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_for_staff);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}