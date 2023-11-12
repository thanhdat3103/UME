package com.example.ume;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SchoolAdapter extends ArrayAdapter<School> {

    public SchoolAdapter(Context context, List<School> schools) {
        super(context, 0, schools);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Kiểm tra xem View đã được tái sử dụng chưa, nếu chưa thì tạo mới
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_school, parent, false);
        }

        // Lấy dữ liệu cho vị trí hiện tại
        School school = getItem(position);

        // Ánh xạ các thành phần UI
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView websiteTextView = convertView.findViewById(R.id.websiteTextView);

        // Hiển thị dữ liệu
        nameTextView.setText(school.getName());
        websiteTextView.setText(school.getWebsite());

        return convertView;
    }
}
