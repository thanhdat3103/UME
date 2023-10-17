package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.PhanTichKetQuaBinding;

public class PhanTichKetQua extends Activity {

    int countKiThuat, countNgheThuat, countNghienCuu, countQuanLi, countXaHoi, countNghiepVu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PhanTichKetQuaBinding binding = DataBindingUtil.setContentView(this, R.layout.phan_tich_ket_qua);

        Intent intent = getIntent();
        if (intent != null) {
            countKiThuat = intent.getIntExtra("countKiThuat", 0);
            countNgheThuat = intent.getIntExtra("countNgheThuat", 0);
            countNghienCuu = intent.getIntExtra("countNghienCuu", 0);
            countQuanLi = intent.getIntExtra("countQuanLi", 0);
            countXaHoi = intent.getIntExtra("countXaHoi", 0);
            countNghiepVu = intent.getIntExtra("countNghiepVu", 0);
        }

        if (countKiThuat < 5 && countNgheThuat < 5 && countNghienCuu < 5 && countQuanLi < 5 && countXaHoi < 5 && countNghiepVu < 5) {
            binding.canhBao.setVisibility(View.VISIBLE);
        } else if (countKiThuat == countNgheThuat || countKiThuat == countNghienCuu || countKiThuat == countQuanLi || countKiThuat == countXaHoi || countKiThuat == countNghiepVu || countNgheThuat == countNghienCuu || countNgheThuat == countQuanLi || countNgheThuat == countXaHoi || countNgheThuat == countNghiepVu || countNghienCuu == countQuanLi || countNghienCuu == countXaHoi || countNghienCuu == countNghiepVu || countQuanLi == countXaHoi || countQuanLi == countNghiepVu || countXaHoi == countNghiepVu) {
            binding.canhBao.setVisibility(View.VISIBLE);
        }
    }
}