package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.ThongTinHocSinhBinding;

public class ThongTinHocSinh extends Activity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThongTinHocSinhBinding binding = DataBindingUtil.setContentView(this, R.layout.thong_tin_hoc_sinh);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nhac_nhap_ten_lop);
        mediaPlayer.start();

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                mediaPlayer.stop();
                mediaPlayer.release();

                String tenHocSinh = binding.editTextName.getText().toString();
                Intent in01 = new Intent(arg0.getContext(), ChonTinhNang.class);
                in01.putExtra("tenHocSinh", tenHocSinh); // Đặt tên dữ liệu để bạn có thể truy cập nó ở màn hình tiếp theo
                startActivity(in01);
            }
        });
    }
}
