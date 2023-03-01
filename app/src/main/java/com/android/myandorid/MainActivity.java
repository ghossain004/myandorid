package com.android.myandorid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.myandorid.database.DataTransfer;

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
        DataTransfer dt = new DataTransfer(getApplicationContext(), "socialbook", null,1);

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent it = new Intent(MainActivity.this, RegistrationActivity.class);
//                it.putExtra("username", userName.getText());
//                it.putExtra("password", password.getText());
//                startActivity(it);

                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _userName = userName.getText().toString();
                String _password = password.getText().toString();

//                System.out.println(_password + "" + _userName);

                if (_userName.length()==0 || _password.length()==0){
                    Toast.makeText(getApplicationContext(), "Please fillup all the field", Toast.LENGTH_SHORT).show();
                }else {
                    if (dt.login(_userName, _password)==1){
                        Toast.makeText(getApplicationContext(), "User login success", Toast.LENGTH_SHORT).show();
                        SharedPreferences preferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("userName", _userName);
                        editor.apply();
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(), "User name or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}