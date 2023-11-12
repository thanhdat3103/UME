package com.example.ume;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public SchoolDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addSchool(School school) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, school.getName());
        values.put(DatabaseHelper.COLUMN_WEBSITE, school.getWebsite());

        return database.insert(DatabaseHelper.TABLE_NAME, null, values);
    }

    public boolean isDatabaseEmpty() {
        Cursor cursor = database.rawQuery("SELECT 1 FROM " + DatabaseHelper.TABLE_NAME, null);
        boolean isEmpty = cursor.getCount() == 0;
        cursor.close();
        return isEmpty;
    }

    public void deleteSchool(long schoolId) {
        database.delete(
                DatabaseHelper.TABLE_NAME,
                DatabaseHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(schoolId)}
        );
    }


    public void addSampleSchools() {
        String[] sampleNames = {
                "THPT AN MỸ",
                "THPT BÀU BÀNG",
                "THPT BẾN CÁT",
                "THPT BÌNH AN",
                "THPT BÌNH PHÚ",
                "THPT CHUYÊN HÙNG VƯƠNG",
                "THPT DẦU TIẾNG",
                "THPT DĨ AN",
                "THPT HUỲNH VĂN NGHỆ",
                "THPT LÊ LỢI",
                "THPT LONG HÒA",
                "THPT NGUYỄN AN NINH",
                "THPT NGUYỄN ĐÌNH CHIỂU",
                "THPT NGUYỄN HUỆ",
                "THPT NGUYỄN TRÃI",
                "THCS – THPT MINH HÒA",
                "THPT PHƯỚC HÒA",
                "THPT PHƯỚC VĨNH",
                "THPT TÂN PHƯỚC KHÁNH",
                "THPT TÂY SƠN",
                "THPT THÁI HÒA",
                "THPT THƯỜNG TÂN",
                "THPT TRỊNH HOÀI ĐỨC",
                "THPT VÕ MINH ĐỨC",
                "THPT NGUYỄN THỊ MINH KHAI",
                "THPT LÝ THÁI TỔ",
                "TRƯỜNG NGÔ THỜI NHIỆM",
                "TRƯỜNG PETRUS KÝ",
                "TRƯỜNG NGUYỄN KHUYẾN",
                "TRƯỜNG PHAN CHU TRINH",
                "TRƯỜNG VIỆT ANH",
                "TRƯỜNG TRUNG CẤP MỸ THUẬT – VĂN HÓA BÌNH DƯƠNG",
                "TRƯỜNG TRUNG CẤP NÔNG LÂM NGHIỆP BÌNH DƯƠNG",
                "TRƯỜNG TRUNG CẤP KINH TẾ KỸ THUẬT BÌNH DƯƠNG",
                "Trường Trung cấp Kỹ thuật và Nghiệp vụ Công đoàn Bình Dương",
                "Trường Trung cấp Công nghiệp Bình Dương",
                "Trường Trung Cấp Tài Chính Kế Toán Bình Dương",
                "Trường Trung cấp Kinh tế Công nghệ Đông Nam",
                "CAO ĐẲNG CÔNG NGHỆ CAO ĐỒNG AN",
                "CAO ĐẲNG NGHỀ VIỆT NAM SINGAPORE"
        };

        String[] sampleWebsites = {
                "http://thptanmy.web.vnedu.vn/",
                "http://thptbaubang.edu.vn/",
                "http://thptbencat.edu.vn/",
                "ĐANG CẬP NHẬT",
                "http://thptbinhphu.edu.vn/",
                "http://thptchv.edu.vn/",
                "http://thptdautieng.edu.vn/",
                "http://thptdian.edu.vn/",
                "https://thpthvnbinhduong.edu.vn/",
                "http://thptleloi.web.vnedu.vn/",
                "http://thptlonghoa.web.vnedu.vn/",
                "http://thptnguyenanninh.edu.vn/",
                "https://thptnguyendinhchieu.gate.edu.vn/",
                "https://thptnguyenhuebd.edu.vn/",
                "http://thptnt.edu.vn/",
                "http://thcs-thptminhhoa.web.vnedu.vn/",
                "https://thptphuochoa.edu.vn/",
                "https://thptphuocvinh.edu.vn/",
                "http://thpttanphuockhanh.binhduong.edu.vn/",
                "http://thpttayson.edu.vn/",
                "http://thptthaihoa.edu.vn/",
                "http://thptthuongtan.web.vnedu.vn/",
                "http://thpttrinhhoaiduc.edu.vn/",
                "https://vi-vn.facebook.com/thptvominhduc.binhduong",
                "http://thptnguyenthiminhkhai.binhduong.edu.vn/",
                "http://thptlythaito.web.vnedu.vn/",
                "https://ngothoinhiem.edu.vn/",
                "http://pek.edu.vn/index.php",
                "http://truongnguyenkhuyen.edu.vn/",
                "https://phanchutrinh.edu.vn/",
                "https://www.vietanhschool.edu.vn/",
                "mythuatvanhoabinhduong.edu.vn",
                "http://nonglambd.edu.vn/",
                "http://www.tcktbinhduong.edu.vn/",
                "https://truongcongdoanbd.edu.vn",
                "http://bdi.edu.vn/",
                "http://tcktbd.edu.vn/",
                "https://dongnam.edu.vn/",
                "https://dongan.edu.vn/",
                "http://www.vsvc.edu.vn/"
        };


        for (int i = 0; i < sampleNames.length; i++) {
            School school = new School();
            school.setName(sampleNames[i]);
            school.setWebsite(sampleWebsites[i]);
            addSchool(school);
        }
    }

    public int updateSchool(School school) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, school.getName());
        values.put(DatabaseHelper.COLUMN_WEBSITE, school.getWebsite());

        return database.update(
                DatabaseHelper.TABLE_NAME,
                values,
                DatabaseHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(school.getId())}
        );
    }

    @SuppressLint("Range")
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            do {
                School school = new School();
                school.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
                school.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
                school.setWebsite(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_WEBSITE)));
                schools.add(school);
            } while (cursor.moveToNext());

            cursor.close();
        }

        return schools;
    }
}

