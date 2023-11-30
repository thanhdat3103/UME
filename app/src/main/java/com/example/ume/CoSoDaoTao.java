package com.example.ume;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//public class CoSoDaoTao extends Activity {
//
//    private SchoolDAO schoolDAO;
//    private ArrayAdapter<School> adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.d("CoSoDaoTao.java", "onCreate()");
//        CoSoDaoTaoBinding binding = DataBindingUtil.setContentView(this,R.layout.co_so_dao_tao);
//
//        schoolDAO = new SchoolDAO(this);
//        schoolDAO.open();
//
//        if (schoolDAO.isDatabaseEmpty()) {
//            schoolDAO.addSampleSchools();
//        }
//
//        List<School> schools = schoolDAO.getAllSchools();
//        adapter = new SchoolAdapter(this, schools);
//        binding.listView.setAdapter(adapter);
//
//        updateSchoolList();
//
//        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                School selectedSchool = adapter.getItem(position);
//                if (selectedSchool != null) {
//                    openWebsite(selectedSchool.getWebsite());
//                }
//            }
//        });
//
//        binding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @SuppressLint("LongLogTag")
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("CoSoDaoTao selectedSchool.id", String.valueOf(adapter.getItem(position).getId()));
//                Log.d("CoSoDaoTao position", String.valueOf(position));
//                Log.d("CoSoDaoTao id", String.valueOf(id));
//                showDeleteDialog(adapter.getItem(position).getId());
//                return true;
//            }
//        });
//    }
//
//    private void openWebsite(String url) {
//        Log.d("CoSoDaoTao.java", "openWebsite(String url)");
//        Intent intent = new Intent(CoSoDaoTao.this, WebViewActivity.class);
//        intent.putExtra("url", url);
//        startActivity(intent);
//    }
//
//    private void showDeleteDialog(final long schoolId) {
//        Log.d("CoSoDaoTao.java", "showDeleteDialog(final long schoolId)");
//        AlertDialog.Builder builder = new AlertDialog.Builder(CoSoDaoTao.this);
//        builder.setTitle("Confirm Delete");
//        builder.setMessage("Are you sure you want to delete this school?");
//
//        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                deleteSchool(schoolId);
//                updateSchoolList();
//            }
//        });
//
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }
//
//    private void deleteSchool(long schoolId) {
//        Log.d("CoSoDaoTao.java", "deleteSchool(long schoolId)");
//        schoolDAO.deleteSchool(schoolId);
//    }
//
//    private void updateSchoolList() {
//        Log.d("CoSoDaoTao.java", "updateSchoolList()");
//        adapter.clear();
//        List<School> schools = schoolDAO.getAllSchools();
//        adapter.addAll(schools);
//
//    }
//
//    public void onAddSchoolClick(View view) {
//        Log.d("CoSoDaoTao.java", "onAddSchoolClick(View view)");
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Thêm trường học");
//
//        // Inflate layout cho dialog
//        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_school, null);
//        builder.setView(dialogView);
//
//        // Thiết lập các controls trong layout
//        EditText editTextSchoolName = dialogView.findViewById(R.id.editTextSchoolName);
//        EditText editTextSchoolWebsite = dialogView.findViewById(R.id.editTextSchoolWebsite);
//
//        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // Lấy giá trị từ EditText
//                String schoolName = editTextSchoolName.getText().toString();
//                String schoolWebsite = editTextSchoolWebsite.getText().toString();
//
//                // Kiểm tra định dạng URL
//                if (isValidUrl(schoolWebsite)) {
//                    // Thêm trường học vào database
//                    School newSchool = new School();
//                    newSchool.setName(schoolName);
//                    newSchool.setWebsite(schoolWebsite);
//                    schoolDAO.addSchool(newSchool);
//
//                    // Cập nhật danh sách trường học
//                    updateSchoolList();
//                } else {
//                    Toast.makeText(CoSoDaoTao.this, "Website không đúng định dạng hoặc không thể load được", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss(); // Đóng dialog
//            }
//        });
//
//        builder.create().show();
//    }
//
//    private boolean isValidUrl(String url) {
//        Log.d("CoSoDaoTao.java", "isValidUrl(String url)");
//        return Patterns.WEB_URL.matcher(url).matches();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("CoSoDaoTao.java", "onDestroy()");
//        schoolDAO.close();
//    }
//}


public class CoSoDaoTao extends Activity {
    private RecyclerView recyclerView;
    private SchoolAdapter schoolAdapter;
    private List<School> schoolList;
    private DatabaseReference schoolsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co_so_dao_tao);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        schoolsRef = database.getReference("schools");

        schoolList = new ArrayList<>();

        schoolAdapter = new SchoolAdapter(this, schoolList);
        recyclerView.setAdapter(schoolAdapter);

        schoolsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                schoolList.clear();
                for (DataSnapshot schoolSnapshot : dataSnapshot.getChildren()) {
                    School school = schoolSnapshot.getValue(School.class);
                    school.setKey(schoolSnapshot.getKey()); // Lưu key của từng trường
                    schoolList.add(school);
                }
                schoolAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ListActivity", "Lỗi: " + databaseError.getMessage());
            }
        });

        // Thêm dữ liệu vào Firebase khi ứng dụng khởi chạy DUY NHẤT LẦN ĐẦU KHI DATABASE CHƯA CÓ GÌ
//        addSchoolsToFirebase();

        Button btnAddSchool = findViewById(R.id.btnAddSchool);
        btnAddSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddSchoolDialog();
            }
        });
    }

//    private void addSchoolsToFirebase() {
//        DatabaseReference schoolsRef = FirebaseDatabase.getInstance().getReference("schools");
//
//        String[] schoolNames = {
//                "SỞ GIÁO DỤC VÀ ĐÀO TẠO BÌNH DƯƠNG",
//                "THPT AN MỸ",
//                "THPT BÀU BÀNG",
//                "THPT BẾN CÁT",
//                "THPT BÌNH AN",
//                "THPT BÌNH PHÚ",
//                "THPT CHUYÊN HÙNG VƯƠNG",
//                "THPT DẦU TIẾNG",
//                "THPT DĨ AN",
//                "THPT HUỲNH VĂN NGHỆ",
//                "THPT LÊ LỢI",
//                "THPT LONG HÒA",
//                "THPT NGUYỄN AN NINH",
//                "THPT NGUYỄN ĐÌNH CHIỂU",
//                "THPT NGUYỄN HUỆ",
//                "THPT NGUYỄN TRÃI",
//                "THCS – THPT MINH HÒA",
//                "THPT PHƯỚC HÒA",
//                "THPT PHƯỚC VĨNH",
//                "THPT TÂN PHƯỚC KHÁNH",
//                "THPT TÂY SƠN",
//                "THPT THÁI HÒA",
//                "THPT THƯỜNG TÂN",
//                "THPT TRỊNH HOÀI ĐỨC",
//                "THPT VÕ MINH ĐỨC",
//                "THPT NGUYỄN THỊ MINH KHAI",
//                "THPT LÝ THÁI TỔ",
//                "TRƯỜNG NGÔ THỜI NHIỆM",
//                "TRƯỜNG PETRUS KÝ",
//                "TRƯỜNG NGUYỄN KHUYẾN",
//                "TRƯỜNG PHAN CHU TRINH",
//                "TRƯỜNG VIỆT ANH",
//                "TRƯỜNG TRUNG CẤP MỸ THUẬT – VĂN HÓA BÌNH DƯƠNG",
//                "TRƯỜNG TRUNG CẤP NÔNG LÂM NGHIỆP BÌNH DƯƠNG",
//                "TRƯỜNG TRUNG CẤP KINH TẾ KỸ THUẬT BÌNH DƯƠNG",
//                "Trường Trung cấp Kỹ thuật và Nghiệp vụ Công đoàn Bình Dương",
//                "Trường Trung cấp Công nghiệp Bình Dương",
//                "Trường Trung Cấp Tài Chính Kế Toán Bình Dương",
//                "Trường Trung cấp Kinh tế Công nghệ Đông Nam",
//                "CAO ĐẲNG CÔNG NGHỆ CAO ĐỒNG AN",
//                "CAO ĐẲNG NGHỀ VIỆT NAM SINGAPORE"
//        };
//
//        String[] websites = {
//                "https://www.binhduong.edu.vn/",
//                "http://thptanmy.web.vnedu.vn/",
//                "http://thptbaubang.edu.vn/",
//                "http://thptbencat.edu.vn/",
//                "ĐANG CẬP NHẬT",
//                "http://thptbinhphu.edu.vn/",
//                "http://thptchv.edu.vn/",
//                "http://thptdautieng.edu.vn/",
//                "http://thptdian.edu.vn/",
//                "https://thpthvnbinhduong.edu.vn/",
//                "http://thptleloi.web.vnedu.vn/",
//                "http://thptlonghoa.web.vnedu.vn/",
//                "http://thptnguyenanninh.edu.vn/",
//                "https://thptnguyendinhchieu.gate.edu.vn/",
//                "https://thptnguyenhuebd.edu.vn/",
//                "http://thptnt.edu.vn/",
//                "http://thcs-thptminhhoa.web.vnedu.vn/",
//                "https://thptphuochoa.edu.vn/",
//                "https://thptphuocvinh.edu.vn/",
//                "http://thpttanphuockhanh.binhduong.edu.vn/",
//                "http://thpttayson.edu.vn/",
//                "http://thptthaihoa.edu.vn/",
//                "http://thptthuongtan.web.vnedu.vn/",
//                "http://thpttrinhhoaiduc.edu.vn/",
//                "https://vi-vn.facebook.com/thptvominhduc.binhduong",
//                "http://thptnguyenthiminhkhai.binhduong.edu.vn/",
//                "http://thptlythaito.web.vnedu.vn/",
//                "https://ngothoinhiem.edu.vn/",
//                "http://pek.edu.vn/index.php",
//                "http://truongnguyenkhuyen.edu.vn/",
//                "https://phanchutrinh.edu.vn/",
//                "https://www.vietanhschool.edu.vn/",
//                "mythuatvanhoabinhduong.edu.vn",
//                "http://nonglambd.edu.vn/",
//                "http://www.tcktbinhduong.edu.vn/",
//                "https://truongcongdoanbd.edu.vn",
//                "http://bdi.edu.vn/",
//                "http://tcktbd.edu.vn/",
//                "https://dongnam.edu.vn/",
//                "https://dongan.edu.vn/",
//                "http://www.vsvc.edu.vn/"
//        };
//
//        for (int i = 0; i < schoolNames.length; i++) {
//            School school = new School(schoolNames[i], websites[i]);
//            schoolsRef.push().setValue(school);
//        }
//    }

    private void showAddSchoolDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_school, null);
        dialogBuilder.setView(dialogView);

        EditText editTextName = dialogView.findViewById(R.id.editTextSchoolName);
        EditText editTextWebsite = dialogView.findViewById(R.id.editTextSchoolWebsite);

        dialogBuilder.setTitle("Thêm trường học");
        dialogBuilder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String name = editTextName.getText().toString().trim();
                String website = editTextWebsite.getText().toString().trim();
                if (!name.isEmpty() && !website.isEmpty()) {
                    addSchool(name, website);
                } else {
                    Toast.makeText(CoSoDaoTao.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialogBuilder.setNegativeButton("Hủy", null);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void addSchool(String name, String website) {
        School newSchool = new School(name, website);
        schoolsRef.push().setValue(newSchool);
    }


}
