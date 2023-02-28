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
    EditText userName, email, password, confirmPassword;
    Button btnSignup;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userName = findViewById(R.id.editTextRegistrationUsername);
        email = findViewById(R.id.editTextRegistrationEmail);
        password = findViewById(R.id.editTextRegistrationPassword);
        confirmPassword = findViewById(R.id.editTextRegistrationConfirmPassword);
        btnSignup = findViewById(R.id.buttonRegistrationSignup);
        tvLogin = findViewById(R.id.textViewRegistrationLogin);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _userName = userName.getText().toString();
                String _email = email.getText().toString();
                String _password = password.getText().toString();
                String _confirmPassword = confirmPassword.getText().toString();
//                System.out.println(_userName);

                DataTransfer dt = new DataTransfer(getApplicationContext(), "socialbook", null, 1);
                if (_userName.length()==0 || _password.length()==0 || _confirmPassword.length()==0 || _email.length()==0){
                    Toast.makeText(getApplicationContext(), "Please Fill All The Field", Toast.LENGTH_SHORT).show();
                }else {
                    if (_password.compareTo(_confirmPassword)==0){
                        if (_password.length()>6){
                            dt.addNewUser(_userName, _email, _password);
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