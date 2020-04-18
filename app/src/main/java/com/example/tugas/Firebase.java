package com.example.tugas;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Firebase {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private List<mahasiswa> mhs = new ArrayList<>();

    public interface DataStatus {
        void DataIsLoaded(List<mahasiswa> mhs, List<String>keys);
        void DataIsinserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public Firebase() {
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("mahasiswa");
    }

    public void readMahasiswa(final DataStatus dataStatus){
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mhs.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keynode : dataSnapshot.getChildren()){
                    keys.add(keynode.getKey());
                    mahasiswa Mahasiswa = keynode.getValue(mahasiswa.class);
                    mhs.add(Mahasiswa);
                }
                dataStatus.DataIsLoaded(mhs,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void tambah(mahasiswa mhs, final DataStatus dataStatus){
        String key  = mReference.push().getKey();
       mReference.child(key).setValue(mhs).addOnSuccessListener(new OnSuccessListener<Void>() {
           @Override
           public void onSuccess(Void aVoid) {
               dataStatus.DataIsinserted();
           }
       });

    }

}

