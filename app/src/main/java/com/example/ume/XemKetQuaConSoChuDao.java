package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.XemKetQuaConSoChuDaoBinding;

public class XemKetQuaConSoChuDao extends Activity {

    int ngaySinh, thangSinh, namSinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XemKetQuaConSoChuDaoBinding binding = DataBindingUtil.setContentView(this,R.layout.xem_ket_qua_con_so_chu_dao);

        Intent intent = getIntent();
        if (intent != null) {
            ngaySinh = intent.getIntExtra("ngaySinh", 1);
            thangSinh = intent.getIntExtra("thangSinh", 1);
            namSinh = intent.getIntExtra("namSinh", 2000);
            Log.d("ngaySinh", String.valueOf(ngaySinh));
            Log.d("thangSinh", String.valueOf(thangSinh));
            Log.d("namSinh", String.valueOf(namSinh));
        }

        int tongChuSo = tinhTongChuSo(ngaySinh) + tinhTongChuSo(thangSinh) + tinhTongChuSo(namSinh);

        while (tongChuSo > 11) tongChuSo = tinhTongChuSo(tongChuSo);

        if (tongChuSo==1) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_1);
        }

        if (tongChuSo==2) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_2);
        }

        if (tongChuSo==3) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_3);
        }

        if (tongChuSo==4) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_4);
        }

        if (tongChuSo==5) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_5);
        }

        if (tongChuSo==6) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_6);
        }

        if (tongChuSo==7) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_7);
        }

        if (tongChuSo==8) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_8);
        }

        if (tongChuSo==9) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_9);
        }

        if (tongChuSo==10) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_10);
        }

        if (tongChuSo==11) {
            binding.ketQuaConSoChuDao.setBackgroundResource(R.drawable.so_11);
        }
    }

    private static int tinhTongChuSo(int so) {
        int tong = 0;
        while (so > 0) {
            tong += so % 10;
            so /= 10;
        }
        return tong;
    }
}