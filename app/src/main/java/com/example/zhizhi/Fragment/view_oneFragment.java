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

public class view_oneFragment extends Fragment {
    private DataDao dataDao;
    private ListData listData;
    private List<ListData> list_list_Data=new ArrayList<>();
    private ListView one_list;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.view_one, container, false);
        Bundle bundle = getArguments();
        dataDao=new DataDao(getContext());
        list_list_Data=new ArrayList<>();
        listData=new ListData("时事汇总------时事政治","中公教育","4-8","http://m.offcn.com/shizheng/sshz/");
        list_list_Data.add(listData);
        listData=new ListData("时政｜国内外时政考点","江西公考","4-7","https://xw.qq.com/cmsid/20210408A09TM300");
        list_list_Data.add(listData);
        listData=new ListData("国内外时事政治","江苏公务员考试网","4-7","http://m.jsgwyw.org/2021/0406/79465.html");
        list_list_Data.add(listData);
        //list_list_Data= dataDao.queryData("",query_stuid.getText().toString());
        one_list=(ListView)view.findViewById(R.id.listView);
        view_oneAdapter oneAdapter=new view_oneAdapter(getContext(),list_list_Data);
        one_list.setAdapter(oneAdapter);
        return view;
    }
}
