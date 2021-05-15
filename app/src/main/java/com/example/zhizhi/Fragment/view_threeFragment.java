package com.example.zhizhi.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.zhizhi.R;
import com.example.zhizhi.adapter.view_oneAdapter;
import com.example.zhizhi.data.ListData;
import com.example.zhizhi.other.DataDao;

import java.util.ArrayList;
import java.util.List;

public class view_threeFragment extends Fragment {
    private DataDao dataDao;
    private ListData listData;
    private List<ListData> list_list_Data=new ArrayList<>();
    private ListView one_list;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.view_three, container, false);
        Bundle bundle = getArguments();
        dataDao=new DataDao(getContext());
        list_list_Data=new ArrayList<>();
        listData=new ListData("毛概理论知识点(第七章)","范文中心","4-8","http://fanwen.geren-jianli.org/531947.html");
        list_list_Data.add(listData);
        listData=new ListData("毛概理论总结","smashing","4-7","https://mip.book118.com/html/2019/0510/8015060134002022.shtm");
        list_list_Data.add(listData);
        listData=new ListData("毛概考试重点","百分网","4-7","http://mip.oh100.com/kaoshi/qimokaoshi/278741.html");
        list_list_Data.add(listData);
        listData=new ListData("广东专插本政治理论毛概四大核心知识点","库课","4-6","https://m.kuke99.com/zsb/34979.html");
        list_list_Data.add(listData);
        //list_list_Data= dataDao.queryData("",query_stuid.getText().toString());
        one_list=(ListView)view.findViewById(R.id.listView);
        view_oneAdapter oneAdapter=new view_oneAdapter(getContext(),list_list_Data);
        one_list.setAdapter(oneAdapter);
        return view;
    }
}
