package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shape_of_you);
        mediaPlayer.start();

        binding.buttonBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();

                Intent intent = new Intent(v.getContext(), ThongTinHocSinh.class);
                startActivity(intent);
            }
        });

        binding.buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
