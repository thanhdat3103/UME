package com.example.ume;

import android.app.Activity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.example.ume.databinding.PdfDisplayBinding;

public class PDFDisplay extends Activity {

    PdfDisplayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.pdf_display);

        String pdfFileName = getIntent().getStringExtra("pdfFileName");
        if (pdfFileName != null) {
            displayPDFFromAssets(pdfFileName);
        }
    }

    private void displayPDFFromAssets(String pdfFileName) {
        binding.pdfView.fromAsset(pdfFileName)
                .load();
    }
}