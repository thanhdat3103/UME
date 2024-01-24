package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.StartTracNghiemBinding;

public class StartTracNghiem extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartTracNghiemBinding binding = DataBindingUtil.setContentView(this, R.layout.start_trac_nghiem);

        binding.buttonStartTracNghiem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent in01=new Intent(arg0.getContext(), CanhBaoTruocKhiLamTracNghiem.class);
                startActivity(in01);
            }
        });

        binding.homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), ChonTinhNang.class);
                startActivity(in01);
            }
        });
    }
}