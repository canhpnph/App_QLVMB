package com.example.da1_group6.ui_admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.da1_group6.R;

public class Fragment_DoiMK extends Fragment {
    ImageView showPass1, showPass2, showPass3;
    EditText edt_oldpass, edt_newpass, edt_retype_newpass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doi_mk, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showPass1 = view.findViewById(R.id.showPass1);
        showPass2 = view.findViewById(R.id.showPass2);
        showPass3 = view.findViewById(R.id.showPass3);
        edt_oldpass = view.findViewById(R.id.edt_oldpass);
        edt_newpass = view.findViewById(R.id.edt_newpass);
        edt_retype_newpass = view.findViewById(R.id.edt_retype_newpass);

        edt_oldpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edt_newpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edt_retype_newpass.setTransformationMethod(PasswordTransformationMethod.getInstance());

        // show/ hint old password
        showPass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.showPass1){
                    if(edt_oldpass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility_off);
                        //Show Password
                        edt_oldpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility);
                        //Hide Password
                        edt_oldpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
            }
        });

        // show / hint new password
        showPass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.showPass2){
                    if(edt_newpass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility_off);
                        //Show Password
                        edt_newpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility);
                        //Hide Password
                        edt_newpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
            }
        });

        // show / hint retype pass
        showPass3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.showPass3){
                    if(edt_retype_newpass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility_off);
                        //Show Password
                        edt_retype_newpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(v)).setImageResource(R.drawable.ic_visibility);
                        //Hide Password
                        edt_retype_newpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
            }
        });
    }
}