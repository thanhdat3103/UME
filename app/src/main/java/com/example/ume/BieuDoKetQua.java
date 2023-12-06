package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.BieuDoKetQuaBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class BieuDoKetQua extends Activity {

    int countKiThuat, countNgheThuat, countNghienCuu, countQuanLi, countXaHoi, countNghiepVu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        BieuDoKetQuaBinding binding = DataBindingUtil.setContentView(this, R.layout.bieu_do_ket_qua);

        Intent intent = getIntent();
        if (intent != null) {
            countKiThuat = intent.getIntExtra("countKiThuat", 0);
            countNgheThuat = intent.getIntExtra("countNgheThuat", 0);
            countNghienCuu = intent.getIntExtra("countNghienCuu", 0);
            countQuanLi = intent.getIntExtra("countQuanLi", 0);
            countXaHoi = intent.getIntExtra("countXaHoi", 0);
            countNghiepVu = intent.getIntExtra("countNghiepVu", 0);
        }

        hienThiBieuDo();

        binding.buttonReadMore.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), PhanTichKetQua.class);
                in01.putExtra("countKiThuat", countKiThuat);
                in01.putExtra("countNgheThuat", countNgheThuat);
                in01.putExtra("countNghienCuu", countNghienCuu);
                in01.putExtra("countQuanLi", countQuanLi);
                in01.putExtra("countXaHoi", countXaHoi);
                in01.putExtra("countNghiepVu", countNghiepVu);
                startActivity(in01);
            }
        });
    }

    private void hienThiBieuDo() {
        BarChart barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, countKiThuat));
        entries.add(new BarEntry(1, countNgheThuat));
        entries.add(new BarEntry(2, countNghienCuu));
        entries.add(new BarEntry(3, countQuanLi));
        entries.add(new BarEntry(4, countXaHoi));
        entries.add(new BarEntry(5, countNghiepVu));

        BarDataSet dataSet = new BarDataSet(entries, "Dữ liệu cột");

        // Thêm màu sắc cho từng cột
        dataSet.setColors(new int[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.CYAN});
        dataSet.setValueTextColor(Color.WHITE); // Màu của giá trị trên cột
        dataSet.setDrawValues(true); // Cho phép hiển thị giá trị trên cột

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);

        // Chú thích và nhãn
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Kĩ thuật");
        labels.add("Nghệ thuật");
        labels.add("Nghiên cứu");
        labels.add("Quản lý");
        labels.add("Xã hội");
        labels.add("Nghiệp vụ");

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);

        Description description = new Description();
        description.setText("");
        description.setTextSize(15); // Điều chỉnh kích thước chữ
        description.setTextColor(Color.BLACK); // Điều chỉnh màu chữ

        Legend legend = barChart.getLegend();
        legend.setTextColor(Color.WHITE); // Đặt màu chữ của chú thích
        legend.setEnabled(false);

        xAxis.setTextColor(Color.WHITE); // Đặt màu chữ của nhãn trên trục X

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setTextColor(Color.WHITE); // Đặt màu chữ của nhãn trên trục Y bên trái

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setTextColor(Color.WHITE); // Đặt màu chữ của nhãn trên trục Y bên phải


        barChart.setDescription(description);

        barChart.animateY(2000);
    }
}