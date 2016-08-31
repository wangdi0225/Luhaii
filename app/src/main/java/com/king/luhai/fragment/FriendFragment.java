package com.king.luhai.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.king.luhai.adapter.FriendGridViewAdapter;
import com.king.luhai.adapter.FriendlistAdapter;
import com.king.luhai.product.Friendlist;
import com.king.luhai.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
public class FriendFragment extends Fragment {
    View header;
    private ListView listview;
    private FriendlistAdapter listViewAdapter ;
    private List<Friendlist> listBean;
    private String imgs1;
    private String imgs2;
    private String imgs3;
    private String imgs4;
    private String imgs5;
    private String imgs6;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_friend, container, false);
        header = LayoutInflater.from(getActivity()).inflate(
                R.layout.dongtai_headler, null);
        listview=(ListView)v.findViewById(R.id.dongtai_listview);
        listview.addHeaderView(header);
        listBean=new ArrayList<Friendlist>();
        initData();
        return v;

    }
    private void initData() {
		/*
		 * 添加模拟数据，正常情况下，这些数据是从服务端获取的
		 * 此次添加了七条数据，对应Gridview中图片数量
		 */
        //模拟用户发布的图片，路径用"#"隔开
        imgs1="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58";
        imgs2="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58";
        imgs3="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58";
        imgs4="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58#http://t12.baidu.com/it/u=732128477,3149312025&fm=58";
        imgs5="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58#http://t12.baidu.com/it/u=732128477,3149312025&fm=58#http://t11.baidu.com/it/u=2722915642,3232472693&fm=58";
        imgs6="http://t10.baidu.com/it/u=2565424359,3856609610&fm=58#http://t10.baidu.com/it/u=374721516,1427740298&fm=58#http://t11.baidu.com/it/u=3158457091,3429860559&fm=58#http://t12.baidu.com/it/u=732128477,3149312025&fm=58#http://t11.baidu.com/it/u=2722915642,3232472693&fm=58#http://t12.baidu.com/it/u=1313963321,225077119&fm=58";

        Friendlist bean=null;
        for(int i=0;i<7;i++){
            bean=new Friendlist();
            switch (i) {
                case 0:
                    bean.setUsername("周杰伦");
                    bean.setHeadphoto(R.mipmap.tx4);
                    bean.setContent("奥哟,不错哦");
                    bean.setTime("1分钟前");
                    break;
                case 1:
                    bean.setUsername("刘德华");
                    bean.setHeadphoto(R.mipmap.tx6);
                    bean.setContent("大家好，我是刘德华");
                    bean.setTime("3分钟前");
                    bean.setImages(imgs1);
                    break;
                case 2:
                    bean.setUsername("张学友");
                    bean.setHeadphoto(R.mipmap.tx5);
                    bean.setContent("大家好，我是张学友");
                    bean.setTime("5分钟前");
                    bean.setImages(imgs2);
                    break;
                case 3:
                    bean.setUsername("郭富城");
                    bean.setHeadphoto(R.mipmap.tx7);
                    bean.setContent("大家好，我是郭富城");
                    bean.setTime("1小时前");
                    bean.setImages(imgs3);
                    break;
                case 4:
                    bean.setUsername("黎明");
                    bean.setHeadphoto(R.mipmap.tx9);
                    bean.setContent("大家好，我是黎明");
                    bean.setTime("2小时前");
                    bean.setImages(imgs4);
                    break;
                case 5:
                    bean.setUsername("金城武");
                    bean.setHeadphoto(R.mipmap.tx8);
                    bean.setContent("大家好，我是金城武");
                    bean.setTime("昨天");
                    bean.setImages(imgs5);
                    break;
                case 6:
                    bean.setUsername("古天乐");
                    bean.setHeadphoto(R.mipmap.tx3);
                    bean.setContent("大家好，我是古天乐");
                    bean.setTime("前天");
                    bean.setImages(imgs6);
                    break;
            }
            listBean.add(bean);//添加进list
        }

        listViewAdapter=new FriendlistAdapter(getActivity(), listBean);
        listview.setAdapter(listViewAdapter);

    }

}




