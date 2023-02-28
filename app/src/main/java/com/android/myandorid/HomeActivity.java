package com.android.myandorid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv1 = findViewById(R.id.textViewHomeTitle1);
        tv2 = findViewById(R.id.textViewHomeTitle2);

        Intent it = getIntent();
        String uname = it.getStringExtra("username");
        String pass = it.getStringExtra("password");

        tv1.setText(uname);
        tv2.setText(pass);
    }
}