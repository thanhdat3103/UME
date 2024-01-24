package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
                // Lấy dữ liệu ngày, tháng và năm sinh từ EditText
                String ngaySinhStr = binding.ngaySinh.getText().toString();
                String thangSinhStr = binding.thangSinh.getText().toString();
                String namSinhStr = binding.namSinh.getText().toString();

                // Kiểm tra xem ngày, tháng và năm sinh có phải là số không
                if (isNumber(ngaySinhStr) && isNumber(thangSinhStr) && isNumber(namSinhStr)) {
                    // Chuyển đổi ngày, tháng và năm sinh thành số nguyên
                    int ngaySinh = Integer.parseInt(ngaySinhStr);
                    int thangSinh = Integer.parseInt(thangSinhStr);
                    int namSinh = Integer.parseInt(namSinhStr);

                    // Kiểm tra tính hợp lệ của ngày, tháng và năm sinh (ví dụ: ngày từ 1-31, tháng từ 1-12, ...)
                    if (isValidDate(ngaySinh, thangSinh, namSinh)) {
                        // Nếu hợp lệ, chuyển sang Activity mới
                        Intent in01 = new Intent(arg0.getContext(), XemKetQuaConSoChuDao.class);
                        in01.putExtra("ngaySinh", ngaySinh);
                        in01.putExtra("thangSinh", thangSinh);
                        in01.putExtra("namSinh", namSinh);
                        startActivity(in01);
                    } else {
                        // Hiển thị thông báo hoặc thông điệp lỗi nếu ngày, tháng và năm sinh không hợp lệ
                        Toast.makeText(arg0.getContext(), "Ngày, tháng, hoặc năm sinh không hợp lệ!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Hiển thị thông báo hoặc thông điệp lỗi nếu ngày, tháng và năm sinh không phải là số
                    Toast.makeText(arg0.getContext(), "Ngày, tháng, hoặc năm sinh không phải là số!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Phương thức kiểm tra xem một chuỗi có phải là số không
    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDate(int ngay, int thang, int nam) {
        // Kiểm tra xem tháng có nằm trong khoảng từ 1 đến 12 hay không
        if (thang < 1 || thang > 12) {
            return false;
        }

        // Kiểm tra xem ngày có nằm trong khoảng từ 1 đến số ngày của tháng đó hay không
        int[] soNgayTrongThang = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // số ngày của từng tháng
        if (ngay < 1 || ngay > soNgayTrongThang[thang]) {
            return false;
        }

        // Kiểm tra năm nhuận (nếu là tháng 2) :
        // Năm nhuận là năm chia hết cho 4 và không chia hết cho 100. Trong trường hợp năm đó chia hết cho 4 và chia hết cho 100, năm đó mà chia hết cho 400 thì mới là năm nhuận.
        // Ví dụ : Năm 2100 không phải là năm nhuận vì 2100 chia hết cho 4 và cũng chia hết cho 100
        // Ví dụ : Năm 2400 là năm nhuận vì 2400 chia hết cho 4 và cũng chia hết cho 100, nhưng chia hết cho 400 nên là năm nhuận
        // Ví dụ : Năm 2024 là năm nhuận vì 2024 chia hết cho 4 và không chia hết cho 100
        if (thang == 2 && nam % 4 == 0 && (nam % 100 != 0 || nam % 400 == 0)) {
            // Năm nhuận, tháng 2 có 29 ngày
            return ngay <= 29;
        }

        return true;
    }

}