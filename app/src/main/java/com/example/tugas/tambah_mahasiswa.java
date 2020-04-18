package com.example.tugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class tambah_mahasiswa extends AppCompatActivity {

    private EditText nameET,nimET,prodiET;
    private Button addBtn,backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_mahasiswa);

        nameET= (EditText) findViewById(R.id.nameET);
        nimET= (EditText) findViewById(R.id.nimET);
        prodiET= (EditText) findViewById(R.id.prodiET);
        addBtn = (Button) findViewById(R.id.updateBtn);
        backBtn = (Button) findViewById(R.id.backBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mahasiswa mhs = new mahasiswa();
                mhs.setNama(nameET.getText().toString());
                mhs.setNim(nimET.getText().toString());
                mhs.setProdi(prodiET.getText().toString());

                new Firebase().tambah(mhs, new Firebase.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<mahasiswa> mhs, List<String> keys) {

                    }

                    @Override
                    public void DataIsinserted() {
                        Toast.makeText(tambah_mahasiswa.this,"Data" + "berhasil",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

       backBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(tambah_mahasiswa.this,Home.class);
               startActivity(i);
               finish();
           }
       });
    }
}
