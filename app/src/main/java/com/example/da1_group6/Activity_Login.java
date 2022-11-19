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

public class Activity_Login extends AppCompatActivity {
    EditText edt_email, edt_pass;
    Button btnLogin;
    ImageView showPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_matkhau);
        showPass = findViewById(R.id.showPass);

        edt_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this, ForAdminActivity.class));
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
    }

}