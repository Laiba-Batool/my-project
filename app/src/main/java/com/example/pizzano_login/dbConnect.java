package com.example.pizzano_login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbConnect extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="pizzano.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME="Login_information";
    public static final String TABLE2_NAME="Menu_Items";

    public static final String Col_1="ID";
    public static final String Col_2="Name";
    public static final String Col_3="Age";
    public static final String Col_4="Contact_Number";
    public static final String Col_5="Email";
    public static final String Col_6="Password";

    public dbConnect(@Nullable Context context) {
        super(context,  DATABASE_NAME,null, DATABASE_VERSION);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Age INTEGER,Contact_Number LONG,Email TEXT, Password TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

    }
    public boolean insertData(String Name,String Age,String Contact_Number,String Email,String Password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_2,Name);
        contentValues.put(Col_3,Age);
        contentValues.put(Col_4,Contact_Number);
        contentValues.put(Col_5,Email);
        contentValues.put(Col_6,Password);
        long result=db.insert(TABLE_NAME,null ,contentValues);
        if(result== -1)
        {
            return false;
        }
        else
        {
            return true;

        }

    }
    public boolean Authentication(String userEmail,String userPassword)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{Col_1,Col_2,Col_3,Col_4,Col_5,Col_6}, Col_5 + "=?",
                new String[]{userEmail},null,null,null);
        if(cursor!=null && cursor.moveToFirst()&& cursor.getCount()>0) {
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5));
            if (userPassword.equals(user1.userPassword)) {
                return true;

            }
        }

        return false;


        }
    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{Col_1, Col_2, Col_3, Col_4, Col_5, Col_6},
                Col_5 + "=?",
                new String[]{email}, null, null, null);
        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {

            return true;
        }
        return false;
    }

}
