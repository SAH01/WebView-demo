package com.example.zhizhi.other;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private Context context;
    public MyDBHelper(Context context, String name, int version) {
        super(context, name, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table itemsdata(" +
                "id integer primary key autoincrement, " +
                "name varchar,  " +
                "theme varchar," +
                "day varchar," +
                "address varchar," +
                "maintheme varchar)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
