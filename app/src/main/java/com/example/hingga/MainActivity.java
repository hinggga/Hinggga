package com.example.hingga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText email,password;

    Button masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences preferences = getSharedPreferences("masuk", MODE_PRIVATE);
        String cek = preferences.getString("ingat","");

        if (cek.equals("true")){
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);

        masuk = findViewById(R.id.btnMasuk);




        TextView daftar = (TextView)findViewById(R.id.btnDaftar);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Daftar.class);
                startActivity(i);
            }
        });




        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferen = getSharedPreferences("masuk", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferen.edit();
                editor.putString("ingat", "true");
                editor.apply();

                Toast.makeText(getApplicationContext(),"Email" + email + "password : " + password, Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, Home.class);
                startActivity(i);
            }
        });



    }
}
