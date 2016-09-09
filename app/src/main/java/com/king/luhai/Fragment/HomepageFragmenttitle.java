package com.king.luhai.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.king.luhai.R;
import com.king.luhai.activity.HomepageActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/31.
 */
public class HomepageFragmenttitle extends Fragment {
    RelativeLayout relativeLayout;
    View daqu;
    TextView regoin;
    ImageView duanwei;
    ListView listview;
    HomepageFragment homepageFragment;
    HomepageFragmenttel homepageFragmenttel;
    SimpleAdapter simpleAdapter;
    private boolean ischeck=false;
    private boolean checkduanwei=false;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    private String[] duanweilists={"黄铜V","黄铜IV","黄铜III","黄铜II","黄铜I","白银V","白银IV","白银III","白银II","白银I","黄金V","黄金IV","黄金III","黄金II","黄金I","铂金V","铂金IV","铂金III","铂金II","铂金I","钻石V","钻石IV","钻石III","钻石II","钻石I","超凡大师","最强王者"};
    private String[] frome={"name"};
    private int[] to={R.id.view_duanwei};
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.item_homepagetitle, container, false);
        daqu = LayoutInflater.from(getActivity()).inflate(
                R.layout.item_view, null);
        relativeLayout=(RelativeLayout)v.findViewById(R.id.titel_relative);
        listview=(ListView)daqu.findViewById(R.id.viewlist);
        simpleAdapter=new SimpleAdapter(getActivity(),list,R.layout.item_viewadapter,frome,to);
        duanwei=(ImageView)v.findViewById(R.id.duanwei);
        duanwei.setOnClickListener(onClickListenerduanwei);
        regoin = (TextView) v.findViewById(R.id.region);
        regoin.setOnClickListener(onClickListener);
        setDefaultFragment();
        addlist();
        listview.setAdapter(simpleAdapter);

        return v;
    }

    public void addlist(){
        for (int i=0;i<duanweilists.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name",duanweilists[i]);
            list.add(map);
        }

    }





    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homepageFragment = new HomepageFragment();
        transaction.replace(R.id.fragment_content, homepageFragment);
        transaction.commit();
    }
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                // 开启Fragment事务
                FragmentTransaction transaction = fm.beginTransaction();
                if(ischeck){
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), HomepageActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }else{
                    homepageFragmenttel = new HomepageFragmenttel();
                    transaction.replace(R.id.fragment_content,homepageFragmenttel);
                    Drawable drawable= getResources().getDrawable(R.mipmap.opendaqu);
                    regoin.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                    ischeck=true;
                }
                transaction.commit();
            }
        };
        View.OnClickListener onClickListenerduanwei  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ischeck==false){
                if (checkduanwei){
                    relativeLayout.removeView(daqu);
                    checkduanwei=false;
                }else {
                    relativeLayout.addView(daqu);
                    checkduanwei=true;
                }
                }
            }
        };
}
