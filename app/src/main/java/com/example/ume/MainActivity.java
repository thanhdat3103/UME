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

        binding.buttonBatDau.setOnClickListener(arg0 -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                binding.mainActivity.setVisibility(View.GONE);
                binding.thongTinHocSinh.setVisibility(View.VISIBLE);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String tenHocSinh = binding.editTextName.getText().toString();

                Intent in01 = new Intent(arg0.getContext(), ChonTinhNang.class);
                in01.putExtra("tenHocSinh", tenHocSinh); // Đặt tên dữ liệu để bạn có thể truy cập nó ở màn hình tiếp theo
                startActivity(in01);
            }
        });

        binding.buttonThoat.setOnClickListener(arg0 -> System.exit(0));
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }
}
