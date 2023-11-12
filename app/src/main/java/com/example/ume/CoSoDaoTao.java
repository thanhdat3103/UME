package com.example.ume;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.CoSoDaoTaoBinding;

import java.util.List;

public class CoSoDaoTao extends Activity {

    private SchoolDAO schoolDAO;
    private ArrayAdapter<School> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CoSoDaoTaoBinding binding = DataBindingUtil.setContentView(this,R.layout.co_so_dao_tao);

        schoolDAO = new SchoolDAO(this);
        schoolDAO.open();

        if (schoolDAO.isDatabaseEmpty()) {
            schoolDAO.addSampleSchools();
        }

        List<School> schools = schoolDAO.getAllSchools();
        adapter = new SchoolAdapter(this, schools);
        binding.listView.setAdapter(adapter);

        updateSchoolList();

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                School selectedSchool = adapter.getItem(position);
                if (selectedSchool != null) {
                    openWebsite(selectedSchool.getWebsite());
                }
            }
        });

        binding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showDeleteDialog(id);
                return true;
            }
        });
    }

    private void openWebsite(String url) {
        Intent intent = new Intent(CoSoDaoTao.this, WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    private void showDeleteDialog(final long schoolId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(CoSoDaoTao.this);
        builder.setTitle("Confirm Delete");
        builder.setMessage("Are you sure you want to delete this school?");

        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteSchool(schoolId);
                updateSchoolList();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void deleteSchool(long schoolId) {
        schoolDAO.deleteSchool(schoolId);
    }


    private void updateSchoolList() {
        adapter.clear();
        List<School> schools = schoolDAO.getAllSchools();
        adapter.addAll(schools);

        // Auto-update ordinal numbers
        for (int i = 0; i < schools.size(); i++) {
            School school = schools.get(i);
            school.setId(i + 1); // Assuming IDs represent the ordinal numbers
            schoolDAO.updateSchool(school);
        }
    }

    public void onAddSchoolClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thêm trường học");

        // Inflate layout cho dialog
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_school, null);
        builder.setView(dialogView);

        // Thiết lập các controls trong layout
        EditText editTextSchoolName = dialogView.findViewById(R.id.editTextSchoolName);
        EditText editTextSchoolWebsite = dialogView.findViewById(R.id.editTextSchoolWebsite);

        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Lấy giá trị từ EditText
                String schoolName = editTextSchoolName.getText().toString();
                String schoolWebsite = editTextSchoolWebsite.getText().toString();

                // Kiểm tra định dạng URL
                if (isValidUrl(schoolWebsite)) {
                    // Thêm trường học vào database
                    School newSchool = new School();
                    newSchool.setName(schoolName);
                    newSchool.setWebsite(schoolWebsite);
                    schoolDAO.addSchool(newSchool);

                    // Cập nhật danh sách trường học
                    updateSchoolList();
                } else {
                    Toast.makeText(CoSoDaoTao.this, "Website không đúng định dạng hoặc không thể load được", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Đóng dialog
            }
        });

        builder.create().show();
    }

    private boolean isValidUrl(String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        schoolDAO.close();
    }
}