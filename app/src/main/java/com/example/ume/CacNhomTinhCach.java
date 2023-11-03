package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.CacNhomTinhCachBinding;

public class CacNhomTinhCach extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CacNhomTinhCachBinding binding = DataBindingUtil.setContentView(this,R.layout.cac_nhom_tinh_cach);

        binding.nhomTinhCachKyThuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), NhomTinhCachKyThuat.class);
                startActivity(in01);
            }
        });

        binding.nhomTinhCachNghiepVu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), NhomTinhCachNghiepVu.class);
                startActivity(in01);
            }
        });

        binding.nhomTinhCachQuanLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), NhomTinhCachQuanLy.class);
                startActivity(in01);
            }
        });

        binding.nhomTinhCachXaHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), NhomTinhCachXaHoi.class);
                startActivity(in01);
            }
        });

        binding.nhomTinhCachNgheThuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), NhomTinhCachNgheThuat.class);
                startActivity(in01);
            }
        });

        binding.nhomTinhCachNghienCuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), NhomTinhCachNghienCuu.class);
                startActivity(in01);
            }
        });
    }
}