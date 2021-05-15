package com.example.zhizhi.other;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.zhizhi.data.ListData;

import java.util.ArrayList;
import java.util.List;

public class DataDao {
    private Context context;
    private ListData listData;
    private MyDBHelper mydbh;
    private SQLiteDatabase sqldb;
    private List<ListData> list_list_Date=new ArrayList<>();
    public DataDao(Context context,ListData listData) {
        this.context=context;
        this.listData=listData;
        mydbh=new MyDBHelper(context,"datadudb.db",1);
        sqldb=mydbh.getReadableDatabase();
    }
    public DataDao(Context context){
        this.context=context;
        mydbh=new MyDBHelper(context,"datadudb.db",1);
        sqldb=mydbh.getReadableDatabase();
    }
    public long insertDB()
    {
        ContentValues contentvalues=new ContentValues();
        contentvalues.put("name",listData.getName());
        contentvalues.put("theme",listData.getTheme());
        contentvalues.put("day", listData.getDay());
        contentvalues.put("address",listData.getAddress());
        contentvalues.put("maintheme",listData.getMain_theme());
        long flag=sqldb.insert("itemsdata",null,contentvalues);
        return flag;
    }
    public List<ListData> queryData(String querystr, String str)
    {
        String [] strs={str};
        Cursor cursor=sqldb.rawQuery("select * from itemsdata where "+querystr+" like ?",strs);
        if(cursor.moveToFirst())
        {
            do{
                String name=cursor.getString(cursor.getColumnIndex("name"));
                String theme=cursor.getString(cursor.getColumnIndex("theme"));
                String day=cursor.getString(cursor.getColumnIndex("day"));
                String address=cursor.getString(cursor.getColumnIndex("address"));
                String maintheme=cursor.getString(cursor.getColumnIndex("maintheme"));
                System.out.println("listdata："+name+theme+day+address+maintheme);
                listData=new ListData(name,theme,day,address);
                list_list_Date.add(listData);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return list_list_Date;
    }
}
