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

public class view_twoFragment extends Fragment {
    private DataDao dataDao;
    private ListData listData;
    private List<ListData> list_list_Data=new ArrayList<>();
    private ListView one_list;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.view_two, container, false);
        Bundle bundle = getArguments();
        dataDao=new DataDao(getContext());
        list_list_Data=new ArrayList<>();
        listData=new ListData("马原必考的三大理论重要考点集锦","搜狐网","4-8","https://m.sohu.com/a/330237159_120066588");
        list_list_Data.add(listData);
        listData=new ListData("考研政治马原六大框架理论","豆瓣小组","4-7","https://www.douban.com/group/topic/79481046/");
        list_list_Data.add(listData);
        listData=new ListData("考研马原","天涯招考网","4-7","http://mip.wzktys.com/k/kaoyanmayuan58geyuanlizongjie/");
        list_list_Data.add(listData);
        listData=new ListData("马原认识理论知识点","沈阳中公教育","4-6","http://m.shenyang.offcn.com/tag/130297.html");
        list_list_Data.add(listData);
//        listData=new ListData("马原认识理论知识点","沈阳中公教育","4-6","http://m.shenyang.offcn.com/tag/130297.html");
//        list_list_Data.add(listData);
        //list_list_Data= dataDao.queryData("",query_stuid.getText().toString());
        one_list=(ListView)view.findViewById(R.id.listView);
        view_oneAdapter oneAdapter=new view_oneAdapter(getContext(),list_list_Data);
        one_list.setAdapter(oneAdapter);
        return view;
    }
}
