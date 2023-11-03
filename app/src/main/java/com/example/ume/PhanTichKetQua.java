package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.PhanTichKetQuaBinding;

import java.util.Arrays;

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

        int[] counts = {countKiThuat, countNgheThuat, countNghienCuu, countQuanLi, countXaHoi, countNghiepVu};

        Arrays.sort(counts);
        int highestCount = counts[counts.length - 1];
        int secondHighestCount = counts[counts.length - 2];

        if (highestCount < 5 || highestCount == secondHighestCount) {
            binding.canhBao.setVisibility(View.VISIBLE);

            binding.buttonKiemTraLai.setOnClickListener(arg0 -> {
                Intent in01 = new Intent(arg0.getContext(), StartTracNghiem.class);
                startActivity(in01);
            });
        }
        else {
            if (countKiThuat == highestCount) {
                binding.nhomKyThuatCaoNhat.setVisibility(View.VISIBLE);
            }
            else if (countNgheThuat == highestCount) {
                binding.nhomNgheThuatCaoNhat.setVisibility(View.VISIBLE);
            }
            else if (countNghienCuu == highestCount) {
                binding.nhomNghienCuuCaoNhat.setVisibility(View.VISIBLE);
            }
            else if (countQuanLi == highestCount) {
                binding.nhomQuanLyCaoNhat.setVisibility(View.VISIBLE);
            }
            else if (countXaHoi == highestCount) {
                binding.nhomXaHoiCaoNhat.setVisibility(View.VISIBLE);
            }
            else if (countNghiepVu == highestCount) {
                binding.nhomNghiepVuCaoNhat.setVisibility(View.VISIBLE);
            }
        }

    }
}