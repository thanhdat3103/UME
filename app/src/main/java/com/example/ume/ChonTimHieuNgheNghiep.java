package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.ChonTimHieuNgheNghiepBinding;

public class ChonTimHieuNgheNghiep extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChonTimHieuNgheNghiepBinding binding = DataBindingUtil.setContentView(this,R.layout.chon_tim_hieu_nghe_nghiep);

        binding.nhomNganhNgonNgu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(arg0.getContext(), PDFDisplay.class);
                intent.putExtra("pdfFileName", "ngon_ngu.pdf");
                startActivity(intent);
            }
        });

        binding.nhomNganhPhanTichLogic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(arg0.getContext(), PDFDisplay.class);
                intent.putExtra("pdfFileName", "phan_tich_logic.pdf");
                startActivity(intent);
            }
        });

        binding.nhomNganhHinhHocMauSacThietKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(arg0.getContext(), PDFDisplay.class);
                intent.putExtra("pdfFileName", "mau_sac_thiet_ke.pdf");
                startActivity(intent);
            }
        });

        binding.nhomNganhLamViecVoiConNguoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(arg0.getContext(), PDFDisplay.class);
                intent.putExtra("pdfFileName", "lam_viec_voi_con_nguoi.pdf");
                startActivity(intent);
            }
        });

        binding.nhomNganhTheChatCoKhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(arg0.getContext(), PDFDisplay.class);
                intent.putExtra("pdfFileName", "the_chat_co_khi.pdf");
                startActivity(intent);
            }
        });
    }
}