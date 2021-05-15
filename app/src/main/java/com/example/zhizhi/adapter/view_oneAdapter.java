package com.example.zhizhi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zhizhi.MainActivity;
import com.example.zhizhi.MapshowActivity;
import com.example.zhizhi.R;
import com.example.zhizhi.data.ListData;

import java.util.ArrayList;
import java.util.List;

public class view_oneAdapter extends BaseAdapter {
    private List<ListData> lists=new ArrayList<>();
    private Context context;
    public view_oneAdapter(Context context,List<ListData> lists) {
        this.context=context;
        this.lists=lists;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item,null);
        }
        TextView list_name=(TextView)convertView.findViewById(R.id.list_name);
        TextView list_theme=(TextView)convertView.findViewById(R.id.list_theme);
        TextView list_Time=(TextView)convertView.findViewById(R.id.list_time);
        ListData listData=lists.get(position);
        list_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(context,MapshowActivity.class);
                intent.putExtra("address", listData.getAddress());
                context.startActivity(intent);
            }
        });
        list_name.setText(listData.getName());
        list_theme.setText(listData.getTheme());
        list_Time.setText(listData.getDay());
        return convertView;
    }
}
