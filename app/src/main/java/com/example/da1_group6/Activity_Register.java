package com.example.da1_group6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Activity_Register extends AppCompatActivity {
    EditText edt_email, edt_pass, edt_retype_pass;
    Button btnReg;
    ImageView showPass1, showPass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnReg = findViewById(R.id.btnRegister);
        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_pass);
        edt_retype_pass = findViewById(R.id.edt_retype_pass);
        showPass1 = findViewById(R.id.showPass1_inReg);
        showPass2 = findViewById(R.id.showPass2_inReg);

        edt_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edt_retype_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());

        showPass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.showPass1_inReg){
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

        showPass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.showPass2_inReg){
                    if(edt_retype_pass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility_off);
                        //Show Password
                        edt_retype_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility);
                        //Hide Password
                        edt_retype_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
            }
        });
    }

    public void backto_login(View view) {
        onBackPressed();
    }
}