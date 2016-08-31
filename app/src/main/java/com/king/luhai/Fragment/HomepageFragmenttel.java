package com.king.luhai.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.king.luhai.R;
import com.king.luhai.adapter.RegoinAdapter;
import com.king.luhai.product.RegoinList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 */
public class HomepageFragmenttel extends Fragment {
    List<RegoinList> lists;
    RegoinAdapter regoinAdapter;
    SimpleAdapter simpleAdapter;
    private String[] dianxqu = {"艾欧尼亚", "祖安", "洛克萨斯", "班德尔城", "皮尔特洛夫", "战争学院", "巨神峰", "雷瑟守备", "裁决之地", "黑色玫瑰", "暗影岛", "钢铁烈阳", "均衡教派", "水晶之痕"};
    private String[] wangtongqu = {"比尔吉沃特", "德玛西亚", "弗雷尔卓德", "无畏先锋"};
    private TextView quanbu,dianxin,wangtong,qita;

    private ListView list2;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v =  inflater.inflate(R.layout.item_homepagetitletwo, container, false);
        quanbu=(TextView)v.findViewById(R.id.quanbu);
        dianxin=(TextView)v.findViewById(R.id.dianxin);
        wangtong=(TextView)v.findViewById(R.id.wangtong);
        qita=(TextView)v.findViewById(R.id.qita);
        quanbu.setOnClickListener(onClickListener);
        dianxin.setOnClickListener(onClickListener);
        wangtong.setOnClickListener(onClickListener);
        qita.setOnClickListener(onClickListener);
            regoinAdapter=new RegoinAdapter(getActivity());
            list2=(ListView)v.findViewById(R.id.list2);
            list2.setAdapter(regoinAdapter);
            addquanbulist();//添加数据
        return v;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.quanbu:
                    dianxin.setBackgroundResource(R.color.huise);
                    list2.setAdapter(null);
                    lists=null;
                    addquanbulist();
                    list2.setAdapter(regoinAdapter);
                    quanbu.setBackgroundResource(R.color.huise);
                    dianxin.setBackgroundResource(R.color.white);
                    wangtong.setBackgroundResource(R.color.white);
                    qita.setBackgroundResource(R.color.white);
                    break;
                case R.id.dianxin:
                    list2.setAdapter(null);
                    lists=null;
                    adddianxinlist();
                    list2.setAdapter(regoinAdapter);
                    quanbu.setBackgroundResource(R.color.white);
                    dianxin.setBackgroundResource(R.color.huise);
                    wangtong.setBackgroundResource(R.color.white);
                    qita.setBackgroundResource(R.color.white);
                    break;
                case R.id.wangtong:
                    list2.setAdapter(null);
                    lists=null;
                    addwangtonglist();
                    list2.setAdapter(regoinAdapter);
                    quanbu.setBackgroundResource(R.color.white);
                    dianxin.setBackgroundResource(R.color.white);
                    wangtong.setBackgroundResource(R.color.huise);
                    qita.setBackgroundResource(R.color.white);
                    break;
                case R.id.qita:
                    list2.setAdapter(null);
                    lists=null;
                    quanbu.setBackgroundResource(R.color.white);
                    dianxin.setBackgroundResource(R.color.white);
                    wangtong.setBackgroundResource(R.color.white);
                    qita.setBackgroundResource(R.color.huise);
                    break;
            }

        }
    };

    public void addwangtonglist(){
        List<RegoinList> lists = new ArrayList<RegoinList>();
        for(int i=0;i<wangtongqu.length;i++){
            RegoinList regoinList = new RegoinList();
            regoinList.name=wangtongqu[i];
            lists.add(regoinList);
        }
        regoinAdapter.setData(lists);

    }
    public void adddianxinlist(){
        List<RegoinList> lists = new ArrayList<RegoinList>();
        for (int i=0;i<dianxqu.length;i++){
            RegoinList regoinList = new RegoinList();
            regoinList.name=dianxqu[i];
            lists.add(regoinList);
        }
        regoinAdapter.setData(lists);
    }

    public void addquanbulist(){
        List<RegoinList> lists = new ArrayList<RegoinList>();
        for (int i=0;i<dianxqu.length;i++){
            RegoinList regoinList = new RegoinList();
            regoinList.name=dianxqu[i];
            lists.add(regoinList);
        }
        for(int i=0;i<wangtongqu.length;i++){
            RegoinList regoinList = new RegoinList();
            regoinList.name=wangtongqu[i];
            lists.add(regoinList);
        }
        regoinAdapter.setData(lists);
    }
}