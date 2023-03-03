package com.android.myandorid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.myandorid.database.DataTransfer;

public class RegistrationActivity extends AppCompatActivity {
    EditText edfullName, eduserName, edemail, edmobile, edpassword, edconfirmPassword;
    Button btnSignup;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edfullName = findViewById(R.id.editTextRegistrationFullName);
        eduserName = findViewById(R.id.editTextRegistrationUsername);
        edemail = findViewById(R.id.editTextRegistrationEmail);
        edmobile = findViewById(R.id.editTextRegistrationMobile);
        edpassword = findViewById(R.id.editTextRegistrationPassword);
        edconfirmPassword = findViewById(R.id.editTextRegistrationConfirmPassword);
        btnSignup = findViewById(R.id.buttonRegistrationSignup);
        tvLogin = findViewById(R.id.textViewRegistrationLogin);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = edfullName.getText().toString();
                String userName = eduserName.getText().toString();
                String email = edemail.getText().toString();
                String mobile = edmobile.getText().toString();
                String password = edpassword.getText().toString();
                String confirmPassword = edconfirmPassword.getText().toString();
                System.out.println(fullName + " " + userName + " " + email + " " + mobile + " " + password + " " + confirmPassword);

                DataTransfer dt = new DataTransfer(getApplicationContext(), "healthcare", null, 1);
                if (fullName.length()==0 || userName.length()==0 || mobile.length()==0 || password.length()==0 || confirmPassword.length()==0 || email.length()==0){
                    Toast.makeText(getApplicationContext(), "Please Fill All The Field", Toast.LENGTH_SHORT).show();
                }else {
                    if (password.compareTo(confirmPassword)==0){
                        if (password.length()>6){
                            dt.addNewUser(userName, email, password);
                            Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });

//
//        Intent it = getIntent();
//        String uname = it.getStringExtra("username");
//        String pass = it.getStringExtra("password");
//
//        userName.setText(uname);
//        password.setText(pass);
    }
}