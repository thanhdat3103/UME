package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.ConSoChuDaoBinding;

public class ConSoChuDao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConSoChuDaoBinding binding = DataBindingUtil.setContentView(this,R.layout.con_so_chu_dao);

        binding.buttonXemKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), XemKetQuaConSoChuDao.class);
                in01.putExtra("ngaySinh", Integer.parseInt(binding.ngaySinh.getText().toString()));
                in01.putExtra("thangSinh", Integer.parseInt(binding.thangSinh.getText().toString()));
                in01.putExtra("namSinh", Integer.parseInt(binding.namSinh.getText().toString()));
                startActivity(in01);
            }
        });
    }
}