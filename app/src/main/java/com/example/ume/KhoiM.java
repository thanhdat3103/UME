package com.example.ume;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KhoiM extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khoi_m);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button homeButton = (Button) findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in01 = new Intent(v.getContext(), ChonTinhNang.class);
                startActivity(in01);
            }
        });
    }
}