package com.example.tugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText e1,e2;
    Button  btnMasuk;
    DbManager db;
    Button masuk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences("masuk", MODE_PRIVATE);
        String cek = preferences.getString("ingat","");

        if (cek.equals("true")){
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
        }




        db = new DbManager(this);
        e1 = (EditText) findViewById(R.id.Email) ;
        e2=(EditText)findViewById(R.id.Password);

        btnMasuk=(Button)findViewById(R.id.btnMasuk);
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferen = getSharedPreferences("masuk", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferen.edit();
                editor.putString("ingat", "true");
                editor.apply();

                //     Toast.makeText(getApplicationContext(),"Email" + email + "password : " + password, Toast.LENGTH_LONG).show();


                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email,password);
                if (Chkemailpass==true) {
                    Toast.makeText(getApplicationContext(), "SUKSES LOGIN", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, Home.class);
                    startActivity(i);
                }
                 else
                    Toast.makeText(getApplicationContext(),"Login Gagal",Toast.LENGTH_LONG).show();



            }
        });




        masuk = findViewById(R.id.btnMasuk);




        TextView daftar = (TextView)findViewById(R.id.btnDaftar);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Daftar.class);
                startActivity(i);
            }
        });



    }
}
