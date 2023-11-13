package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.ChonTinhNangBinding;


public class ChonTinhNang extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChonTinhNangBinding binding = DataBindingUtil.setContentView(this, R.layout.chon_tinh_nang);

        // Lấy dữ liệu từ Intent : Trang trước gửi thông tin qua trang này nhờ vào keywork tenHocSinh, mình sẽ bắt thông tin lấy từ keyword tenHocSinh này
        Intent intent = getIntent();
        if (intent != null) {
            String tenHocSinhStr = intent.getStringExtra("tenHocSinh");

            if (tenHocSinhStr != null && !tenHocSinhStr.isEmpty()) {
                binding.tenHocSinh.setText(tenHocSinhStr);
            }
        }

        binding.toHopMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), ChonToHopMon.class);
                startActivity(in01);
            }
        });

        binding.tracNghiemSoThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), StartTracNghiem.class);
                startActivity(in01);
            }
        });

        binding.timHieuNgheNghiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), ChonTimHieuNgheNghiep.class);
                startActivity(in01);
            }
        });

        binding.cacNhomTinhCach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), CacNhomTinhCach.class);
                startActivity(in01);
            }
        });

        binding.coSoDaoTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), CoSoDaoTao.class);
                startActivity(in01);
            }
        });

        binding.conSoChuDao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), ConSoChuDao.class);
                startActivity(in01);
            }
        });
    }
}