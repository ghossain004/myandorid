package com.android.myandorid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView tv1, tv2;
    Button btnLogout, btnAddDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        tv1 = findViewById(R.id.textViewHomeTitle1);
//        tv2 = findViewById(R.id.textViewHomeTitle2);
        btnLogout = findViewById(R.id.buttonHomeLogout);
        btnAddDoctor = findViewById(R.id.buttonAddDoctor);


//        Intent it = getIntent();
//        String uname = it.getStringExtra("username");
//        String pass = it.getStringExtra("password");
//
//        tv1.setText(uname);
//        tv2.setText(pass);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("userName","").toString();
        Toast.makeText(getApplicationContext(),"Welcome "+userName+"!",Toast.LENGTH_SHORT).show();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                Toast.makeText(getApplicationContext(),"Logout success",Toast.LENGTH_SHORT).show();
            }
        });

        btnAddDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DoctorDetailsActivity.class));
            }
        });
    }
}