package com.example.ume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.TraLoiTracNghiemBinding;

public class TraLoiTracNghiem extends Activity {

    int countKiThuat = 0;
    int countNghienCuu = 0;
    int countNgheThuat = 0;
    int countXaHoi = 0;
    int countQuanLi = 0;
    int countNghiepVu = 0;


    public enum StatusGroup {
        GROUP_KY_THUAT, GROUP_NGHIEN_CUU, GROUP_NGHE_THUAT, GROUP_XA_HOI, GROUP_QUAN_LI, GROUP_NGHIEP_VU, SHOW_KET_QUA
    }

    StatusGroup status = StatusGroup.GROUP_KY_THUAT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        TraLoiTracNghiemBinding binding = DataBindingUtil.setContentView(this, R.layout.tra_loi_trac_nghiem);

        binding.btNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switch (status) {
                    case GROUP_KY_THUAT:
                        binding.groupKyThuat.setVisibility(View.GONE);
                        binding.groupNghienCuu.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_NGHIEN_CUU;
                        break;
                    case GROUP_NGHIEN_CUU:
                        binding.groupNghienCuu.setVisibility(View.GONE);
                        binding.groupNgheThuat.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_NGHE_THUAT;
                        break;
                    case GROUP_NGHE_THUAT:
                        binding.groupNgheThuat.setVisibility(View.GONE);
                        binding.groupXaHoi.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_XA_HOI;
                        break;
                    case GROUP_XA_HOI:
                        binding.groupXaHoi.setVisibility(View.GONE);
                        binding.groupQuanLi.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_QUAN_LI;
                        break;
                    case GROUP_QUAN_LI:
                        binding.groupQuanLi.setVisibility(View.GONE);
                        binding.groupNghiepVu.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_NGHIEP_VU;
                        break;
                    case GROUP_NGHIEP_VU:
                        binding.groupNghiepVu.setVisibility(View.GONE);
                        status = StatusGroup.SHOW_KET_QUA;
                        binding.btCheck.setVisibility(View.VISIBLE);
                        binding.btNext.setVisibility(View.GONE);
                        break;

                }
            }
        });

        binding.btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                switch (status) {
                    case SHOW_KET_QUA:
                        binding.groupNghiepVu.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_NGHIEP_VU;
                        binding.btCheck.setVisibility(View.GONE);
                        binding.btNext.setVisibility(View.VISIBLE);
                        break;
                    case GROUP_NGHIEP_VU:
                        binding.groupNghiepVu.setVisibility(View.GONE);
                        binding.groupQuanLi.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_QUAN_LI;
                        break;
                    case GROUP_QUAN_LI:
                        binding.groupQuanLi.setVisibility(View.GONE);
                        binding.groupXaHoi.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_XA_HOI;
                        break;
                    case GROUP_XA_HOI:
                        binding.groupXaHoi.setVisibility(View.GONE);
                        binding.groupNgheThuat.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_NGHE_THUAT;
                        break;
                    case GROUP_NGHE_THUAT:
                        binding.groupNgheThuat.setVisibility(View.GONE);
                        binding.groupNghienCuu.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_NGHIEN_CUU;
                        break;
                    case GROUP_NGHIEN_CUU:
                        binding.groupNghienCuu.setVisibility(View.GONE);
                        binding.groupKyThuat.setVisibility(View.VISIBLE);
                        status = StatusGroup.GROUP_KY_THUAT;
                        break;
                }

            }
        });

        binding.btCheck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent in01 = new Intent(arg0.getContext(), BieuDoKetQua.class);
                in01.putExtra("countKiThuat", countKiThuat);
                in01.putExtra("countNgheThuat", countNgheThuat);
                in01.putExtra("countNghienCuu", countNghienCuu);
                in01.putExtra("countQuanLi", countQuanLi);
                in01.putExtra("countXaHoi", countXaHoi);
                in01.putExtra("countNghiepVu", countNghiepVu);
                startActivity(in01);
            }
        });

        binding.kyThuatAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });

        binding.kyThuatAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });

        binding.kyThuatAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });

        binding.kyThuatAnswer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });

        binding.kyThuatAnswer5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });

        binding.kyThuatAnswer6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });

        binding.kyThuatAnswer7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });

        binding.kyThuatAnswer8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });

        binding.kyThuatAnswer9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });

        binding.kyThuatAnswer10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotKyThuat(isChecked);
            }
        });


        binding.nghienCuuAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });

        binding.nghienCuuAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });

        binding.nghienCuuAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });

        binding.nghienCuuAnswer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });

        binding.nghienCuuAnswer5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });

        binding.nghienCuuAnswer6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });

        binding.nghienCuuAnswer7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });

        binding.nghienCuuAnswer8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });

        binding.nghienCuuAnswer9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });

        binding.nghienCuuAnswer10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghienCuu(isChecked);
            }
        });


        binding.ngheThuatAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });

        binding.ngheThuatAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });

        binding.ngheThuatAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });

        binding.ngheThuatAnswer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });

        binding.ngheThuatAnswer5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });

        binding.ngheThuatAnswer6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });

        binding.ngheThuatAnswer7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });

        binding.ngheThuatAnswer8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });

        binding.ngheThuatAnswer9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });

        binding.ngheThuatAnswer10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNgheThuat(isChecked);
            }
        });


        binding.xaHoiAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });

        binding.xaHoiAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });

        binding.xaHoiAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });

        binding.xaHoiAnswer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });

        binding.xaHoiAnswer5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });

        binding.xaHoiAnswer5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });

        binding.xaHoiAnswer7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });

        binding.xaHoiAnswer8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });

        binding.xaHoiAnswer9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });

        binding.xaHoiAnswer10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotXaHoi(isChecked);
            }
        });


        binding.quanLiAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });

        binding.quanLiAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });

        binding.quanLiAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });

        binding.quanLiAnswer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });

        binding.quanLiAnswer5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });

        binding.quanLiAnswer6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });

        binding.quanLiAnswer7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });

        binding.quanLiAnswer8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });

        binding.quanLiAnswer9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });

        binding.quanLiAnswer10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotQuanLi(isChecked);
            }
        });


        binding.nghiepVuAnswer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

        binding.nghiepVuAnswer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

        binding.nghiepVuAnswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

        binding.nghiepVuAnswer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

        binding.nghiepVuAnswer5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

        binding.nghiepVuAnswer6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

        binding.nghiepVuAnswer7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

        binding.nghiepVuAnswer8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

        binding.nghiepVuAnswer9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

        binding.nghiepVuAnswer10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedOrNotNghiepVu(isChecked);
            }
        });

    }

    private void isCheckedOrNotKyThuat(boolean isChecked) {
        if (isChecked) {
            countKiThuat++;
        } else {
            if (countKiThuat > 0) {
                countKiThuat--;
            }
        }
    }

    private void isCheckedOrNotNghienCuu(boolean isChecked) {
        if (isChecked) {
            countNghienCuu++;
        } else {
            if (countNghienCuu > 0) {
                countNghienCuu--;
            }
        }
    }

    private void isCheckedOrNotNgheThuat(boolean isChecked) {
        if (isChecked) {
            countNgheThuat++;
        } else {
            if (countNgheThuat > 0) {
                countNgheThuat--;
            }
        }
    }

    private void isCheckedOrNotXaHoi(boolean isChecked) {
        if (isChecked) {
            countXaHoi++;
        } else {
            if (countXaHoi > 0) {
                countXaHoi--;
            }
        }
    }

    private void isCheckedOrNotQuanLi(boolean isChecked) {
        if (isChecked) {
            countQuanLi++;
        } else {
            if (countQuanLi > 0) {
                countQuanLi--;
            }
        }
    }

    private void isCheckedOrNotNghiepVu(boolean isChecked) {
        if (isChecked) {
            countNghiepVu++;
        } else {
            if (countNghiepVu > 0) {
                countNghiepVu--;
            }
        }
    }
}