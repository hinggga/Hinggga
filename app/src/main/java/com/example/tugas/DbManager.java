package com.example.tugas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname="progAndro.db";
    public DbManager(Context context){
        super(context, dbname, null, 1);

    }


    public void onCreate (SQLiteDatabase db){
        String qry="create table tbl_user (id integer  primary key  autoincrement, nama text , email text, password text)";
        db.execSQL(qry);
    }

    public void onUpgrade( SQLiteDatabase db, int oldVersion , int newVersion ){
        db.execSQL("DROP TABLE IF EXISTS tbl_user");
        onCreate(db);
    }

    public String addRecord (String p1, String  p2, String p3 ){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nama",p1);
        cv.put("email",p2);
        cv.put("password",p3);

        long res=db.insert("tbl_user", null,cv);

        if (res==-1)
            return "Failed";
        else
            return "Successfully inserted";

    }

    public Boolean  chkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbl_user where email=?", new String[]{email});
        if (cursor.getCount()>0)return false;
        else return     true;
    }

    public  Boolean emailpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tbl_user where email=? and password=?", new String[]{email,password});
        if (cursor.getCount()>0 ) return true;
        else return false;

    }
}
