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
import com.android.myandorid.entity.Doctor;

public class DoctorDetailsActivity extends AppCompatActivity {

    EditText edDoctorName, edEmail, edAddress;
    Button btnSubmit;
    TextView tvTitle, tvBack;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        edDoctorName = findViewById(R.id.editTextDoctorName);
        edEmail = findViewById(R.id.editTextDcotorEmail);
        edAddress = findViewById(R.id.editTextDoctorAddress);
        btnSubmit = findViewById(R.id.buttonDoctorSubmit);
        tvBack = findViewById(R.id.textViewBack);

        Bundle data = getIntent().getExtras();

        if (data != null){
            id = data.getInt("id");
            String doctorName = data.getString("doctorName");
            String email = data.getString("email");
            String address = data.getString("address");

            edDoctorName.setText(doctorName);
            edEmail.setText(email);
            edAddress.setText(address);
            btnSubmit.setText("Update");
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctorName =  edDoctorName.getText().toString();
                String doctorEmail = edEmail.getText().toString();
                String doctorAddress = edAddress.getText().toString();

                Doctor dc = new Doctor();
                dc.setId(id);
                dc.setDoctorName(doctorName);
                dc.setEmail(doctorEmail);
                dc.setAddress(doctorAddress);

                DataTransfer dt = new DataTransfer(getApplicationContext(), "healthcare", null, 1);
                if (doctorName.length()==0 || doctorEmail.length()==0 || doctorAddress.length()==0){
                    Toast.makeText(getApplicationContext(), "Please Fill All The Field", Toast.LENGTH_SHORT).show();
                }else {
                    if (dc.getId()!=null){
                        System.out.println("update");
                        dt.updateDoctor(dc);
                        startActivity(new Intent(DoctorDetailsActivity.this, DcotorListActivity.class));
                    }else {
                        System.out.println("create");
                        dt.addDoctor(dc);
                        startActivity(new Intent(DoctorDetailsActivity.this, HomeActivity.class));
                        Toast.makeText(getApplicationContext(), "Doctor Created", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, HomeActivity.class));
            }
        });
    }
}