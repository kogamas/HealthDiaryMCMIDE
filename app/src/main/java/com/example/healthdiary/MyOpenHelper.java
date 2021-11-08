package com.example.healthdiary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_DATABASE);
        sqLiteDatabase.execSQL(CREATE_DATABASE);
    }

    String CREATE_DATABASE = "CREATE TABLE mytable(_id INTEGER PRIMARY KEY AUTOINCREMENT, weight INTEGER, sys INTEGER, dia INTEGER)";
    String DROP_DATABASE = "DROP TABLE IF EXISTS mytable";

}
