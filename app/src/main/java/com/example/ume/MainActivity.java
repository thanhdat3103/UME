package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonBatDau.setOnClickListener(arg0 -> {
            Intent in01 = new Intent(arg0.getContext(), ThongTinHocSinh.class);
            startActivity(in01);

        });

        binding.buttonThoat.setOnClickListener(arg0 -> System.exit(0));
    }
}
