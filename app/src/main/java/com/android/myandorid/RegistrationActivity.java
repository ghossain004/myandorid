package com.android.myandorid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userName = findViewById(R.id.editTextRegistrationUsername);
        password = findViewById(R.id.editTextRegistrationPassword);

        Intent it = getIntent();
        String uname = it.getStringExtra("username");
        String pass = it.getStringExtra("password");

        userName.setText(uname);
        password.setText(pass);
    }
}