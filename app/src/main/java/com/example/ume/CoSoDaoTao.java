package com.example.ume;

import android.app.Activity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.CoSoDaoTaoBinding;

public class CoSoDaoTao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CoSoDaoTaoBinding binding = DataBindingUtil.setContentView(this,R.layout.co_so_dao_tao);
    }
}