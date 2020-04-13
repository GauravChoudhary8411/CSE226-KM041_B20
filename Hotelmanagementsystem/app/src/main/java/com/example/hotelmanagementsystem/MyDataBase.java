package com.example.hotelmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDataBase extends SQLiteOpenHelper {
    private static final int dbv = 1;  //database version
    private static final String dbname = "mydb";
    Context ct;

    MyDataBase(Context c) {
        super(c, dbname, null, dbv);
        ct = c;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "create table information(BookName text, name text,id integer,email text,issue integer)";
        db.execSQL(s);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertValues(String book, String s1, int l, String s2, int s3) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();  //creating objects
        cv.put("BookName",book); //inserting book title
        cv.put("name", s1); //inserting name to database
        cv.put("id", l);    //inserting student id
        cv.put("email", s2);  //inserting email address
        cv.put("Issue", s3); //inserting up to

        db.insert("information", null, cv);

        Toast.makeText(ct, "Hotel Reserved Sucessfully", Toast.LENGTH_LONG).show();
    }

    //Viewing Data on ViewContact Activity

    public ArrayList<String> showValues() {
        Toast.makeText(ct, "Account Opened...", Toast.LENGTH_SHORT).show();
        SQLiteDatabase db = getReadableDatabase();
        String s = "select * from information";
        Cursor cr = db.rawQuery(s, null);
        ArrayList<String> al = new ArrayList<>();
        while (cr.moveToNext()) {
            String book =cr.getString(0);
            String s1 = cr.getString(1);
            int l = cr.getInt(2);
            String s2 = cr.getString(3);
            int s3 = cr.getInt(4);
            String s4 = "Hotel Name: " + book + "\nCustomer Name: " + s1 + "\nNo. of customers: " + l+ "\nReserved for : " + s3 +" days" +"\nEmail Id: " + s2;
            al.add(s4);
        }
        return al;
    }

}