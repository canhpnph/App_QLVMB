package com.example.da1_group6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {
    EditText edt_email, edt_pass;
    Button btnLogin;
    ImageView showPass;
//thang alo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_pass);
        showPass = findViewById(R.id.showPass);
//test
        overridePendingTransition(R.anim.animation1, R.anim.animation2);

        edt_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check()) {
                    if(edt_email.getText().toString().trim().equals("1") && edt_pass.getText().toString().trim().equals("a")) {
                        startActivity(new Intent(Activity_Login.this, ForAdminActivity.class));
                        overridePendingTransition(R.anim.slide_in_dialog, R.anim.slide_out_dialog);
                    }
                    else if(edt_email.getText().toString().trim().equals("2") && edt_pass.getText().toString().trim().equals("a")) {
                        startActivity(new Intent(Activity_Login.this, ForStaffActivity.class));
                        overridePendingTransition(R.anim.slide_in_dialog, R.anim.slide_out_dialog);
                    }
                    else if(edt_email.getText().toString().trim().equals("3") && edt_pass.getText().toString().trim().equals("a")) {
                        startActivity(new Intent(Activity_Login.this, ForUserActivity.class));
                        overridePendingTransition(R.anim.slide_in_dialog, R.anim.slide_out_dialog);
                    } else {
                        Toast.makeText(Activity_Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
        });

        showPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.showPass){
                    if(edt_pass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility_off);
                        //Show Password
                        edt_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility);
                        //Hide Password
                        edt_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
            }
        });
    }

    public void from_login_to_register(View view) {
        startActivity(new Intent(Activity_Login.this, Activity_Register.class));
        overridePendingTransition(R.anim.animation1, R.anim.animation2);
    }

    public boolean check() {
        if(edt_email.getText().toString().trim().equals("") && edt_pass.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}