package com.example.tugas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.List;

public class list_mahasiswa extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_mahasiswa);

        new Firebase().readMahasiswa(new Firebase.DataStatus() {
            @Override
            public void DataIsLoaded(List<mahasiswa> mhs, List<String> keys) {

            }

            @Override
            public void DataIsinserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }


}
