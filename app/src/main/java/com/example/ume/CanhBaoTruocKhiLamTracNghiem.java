package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.CanhBaoTruocKhiLamTracNghiemBinding;

public class CanhBaoTruocKhiLamTracNghiem extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CanhBaoTruocKhiLamTracNghiemBinding binding = DataBindingUtil.setContentView(this, R.layout.canh_bao_truoc_khi_lam_trac_nghiem);

        binding.buttonStartTracNghiem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent in01=new Intent(arg0.getContext(), TraLoiTracNghiem.class);
                startActivity(in01);
            }
        });
    }
}