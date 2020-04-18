package com.example.tugas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private mahasiswaAdapter mMhsAdapter;
    public void  setConfig(RecyclerView recyclerView, Context context, List<mahasiswa> mhs,List<String >keys){
        mContext = context;
        mMhsAdapter = new mahasiswaAdapter(mhs,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mMhsAdapter);
    }

    class mahasiswaItem extends RecyclerView.ViewHolder{
        private TextView t1,t2,t3;
        private String key;

        public mahasiswaItem (ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.activity_list_mahasiswa, parent,false));
            t1  =(TextView) itemView.findViewById(R.id.name_textview);
            t2  =(TextView) itemView.findViewById(R.id.nim_textview);
            t3  =(TextView) itemView.findViewById(R.id.prodi_textview);



        }

        public void bind(mahasiswa mhs, String key){
            t1.setText(mhs.getNama());
            t2.setText(mhs.getNim());
            t3.setText(mhs.getProdi());
            this.key = key;
        }

    }
    class mahasiswaAdapter extends RecyclerView.Adapter<mahasiswaItem>{
        private List<mahasiswa>mMhsList;
        private List<String> mKeys;

        public mahasiswaAdapter(List<mahasiswa> mMhsList, List<String> mKeys) {
            this.mMhsList = mMhsList;
            this.mKeys = mKeys;
        }

        public mahasiswaAdapter() {
            this.mMhsList = mMhsList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public mahasiswaItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new mahasiswaItem(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull mahasiswaItem holder, int position) {
            holder.bind(mMhsList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mMhsList.size();
        }
    }
}
