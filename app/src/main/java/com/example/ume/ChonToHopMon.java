package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.ChonToHopMonBinding;

public class ChonToHopMon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChonToHopMonBinding binding = DataBindingUtil.setContentView(this, R.layout.chon_to_hop_mon);

        binding.buttonKhoiA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiA.class);
                startActivity(in01);
            }
        });

        binding.buttonKhoiB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiB.class);
                startActivity(in01);
            }
        });

        binding.buttonKhoiC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiC.class);
                startActivity(in01);
            }
        });

        binding.buttonKhoiD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiD.class);
                startActivity(in01);
            }
        });

        binding.buttonKhoiH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiH.class);
                startActivity(in01);
            }
        });

        binding.buttonKhoiV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiV.class);
                startActivity(in01);
            }
        });

        binding.buttonKhoiR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiR.class);
                startActivity(in01);
            }
        });

        binding.buttonKhoiM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiM.class);
                startActivity(in01);
            }
        });

        binding.buttonKhoiN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiN.class);
                startActivity(in01);
            }
        });

        binding.buttonKhoiT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), KhoiT.class);
                startActivity(in01);
            }
        });
    }
}