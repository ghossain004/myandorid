package com.android.myandorid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.myandorid.database.DataTransfer;

import java.util.ArrayList;

public class DcotorListActivity extends AppCompatActivity {

    Button btnHome;

    ArrayList list;

    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcotor_list);

        btnHome = findViewById(R.id.homeButton);

        DataTransfer dt = new DataTransfer(getApplicationContext(), "socialbook", null, 1);
        list = new ArrayList<>();
        list = dt.getEmployees();

        System.out.println(list.size());;

        sa = new SimpleAdapter(this,
                list,
                R.layout.list_view_layout, new String[]{
                "id", "userName", "email", "password"
        }, new int[]{R.id.viewId, R.id.viewName, R.id.viewEmail, R.id.viewAddress});

        ListView lv = findViewById(R.id.doctorList);
        lv.setAdapter(sa);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DcotorListActivity.this, HomeActivity.class));
            }
        });
    }

}