package com.android.myandorid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText userName, password;
        Button btnLogin;
        TextView tvSignup;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.editTextTextLoginUsername);
        password = findViewById(R.id.editTextTextLoginPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        tvSignup = findViewById(R.id.textViewSignup);

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, RegistrationActivity.class);
                it.putExtra("username", userName.getText());
                it.putExtra("password", password.getText());
                startActivity(it);

//                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });
    }
}